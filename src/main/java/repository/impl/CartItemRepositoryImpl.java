package repository.impl;

import entity.Cart;
import entity.CartItem;
import entity.Product;
import entity.enumration.ProductCategory;
import entity.enumration.ProductSubType;
import repository.CartItemRepository;
import util.QueryUtil;

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
    public CartItem update(Integer id, String operator) {
        CartItem cartItem = findByID(id);
        int countNew= cartItem.getCountInCart();
        switch (operator){
            case "+":{
                countNew++;
                break;
            }
            case "-":{
                countNew--;
                break;
            }
        }
        String selectQuery = """
                                update cart_item set count_in_cart=?
                                where id=?
                                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1,countNew);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            cartItem.setCountInCart(countNew);
            return cartItem;

        } catch (Throwable e) {
            throw new RuntimeException("Error In update cartItem ! ");
        }
    }
    @Override
    public CartItem existByCartIdProductId(Integer cartId, Integer productId) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(QueryUtil.EXISTS_BY_CART_ID_PRODUCT_ID_QUERY_TEMPLATE, getTableName()))) {
            preparedStatement.setInt(1, cartId);
            preparedStatement.setInt(2, productId);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? mapResultSetToBaseEntity(resultSet) : null;

        } catch (Throwable e) {
            throw new RuntimeException("Error In exist by cartId and productId ! ");
        }
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
        try {
            return new CartItem(resultSet.getInt("id"),
                    new Cart(resultSet.getInt("cart_id")),
                    new Product(resultSet.getInt("product_id")),
                    resultSet.getInt("count_in_cart"));
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }
}
