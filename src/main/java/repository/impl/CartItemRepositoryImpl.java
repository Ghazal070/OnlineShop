package repository.impl;

import entity.Cart;
import entity.CartItem;
import entity.Product;
import repository.CartItemRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class CartItemRepositoryImpl extends BaseEntityRepositoryImpl<CartItem,Integer> implements CartItemRepository {
    public CartItemRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        String insertQuery = "insert into cart_item(cart_id,product_id,count_in_cart) values (?,?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery,
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setInt(1, cartItem.getCart().getId());
            preparedStatement.setInt(2, cartItem.getProduct().getId());
            preparedStatement.setInt(3, cartItem.getCountInCart());
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    cartItem.setId(resultSet.getInt("id"));
                    resultSet.close();
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException("Error In save cart item ! ");
        }
        return cartItem;
    }


    @Override
    protected String getTableName() {
        return CartItem.TABLE_NAME;
    }

    @Override
    protected List<String> getColumnNames() {
        return null;
    }

    @Override
    protected String getQuestionMarks(int length) {
        return null;
    }

    @Override
    protected CartItem mapResultSetToBaseEntity(ResultSet resultSet) {
        return null;
    }
}
