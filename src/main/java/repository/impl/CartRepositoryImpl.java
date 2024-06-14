package repository.impl;

import entity.Cart;
import entity.Customer;
import repository.CartRepository;
import util.AuthHolder;
import util.QueryUtil;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

public class CartRepositoryImpl extends BaseEntityRepositoryImpl<Cart, Integer> implements CartRepository {
    private final AuthHolder authHolder;

    public CartRepositoryImpl(Connection connection, AuthHolder authHolder) {
        super(connection);
        this.authHolder = authHolder;
    }


    public Cart save(Cart entity) {
        String query = "insert into cart(customer_id) values(?)";
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                query, PreparedStatement.RETURN_GENERATED_KEYS)) {
            preparedStatement.setInt(1, authHolder.tokenId);
            int rowAffected = preparedStatement.executeUpdate();
            if (rowAffected > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    entity.setId(resultSet.getInt("id"));
                resultSet.close();
                }
            }
            return entity;
        } catch (Throwable e) {
            e.getStackTrace();
            throw new RuntimeException("Error In save cart! ");
        }
    }

    @Override
    protected String getTableName() {
        return Cart.TABLE_NAME;
    }

    @Override
    protected List<String> getColumnNames() {
        List<String> columnNameList = new ArrayList<>();
        columnNameList.add(Cart.CUSTOMER_ID);
        return columnNameList;
    }

    @Override
    protected String getQuestionMarks(int length) {
        String result = "";
        for (int i = 0; i <= length; i++) {
            result += "?,";
        }
        return result.substring(0, result.length() - 1);
    }

    @Override
    protected Cart mapResultSetToBaseEntity(ResultSet resultSet) {
//        try {
//            Customer customer = new Customer(authHolder.tokenId,authHolder.tokenName);
//            return new Cart(customer);
//        } catch (Throwable e) {
//            throw new RuntimeException("Error In mapping! ");
//        }
        try {
            return new Cart(resultSet.getInt("id"),
                    new Customer(resultSet.getInt("customer_id"))
            );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Cart findByCustomerID(Integer id) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(QueryUtil.FIND_BY_CUSTOMER_ID_QUERY_TEMPLATE, getTableName()))) {
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? mapResultSetToBaseEntity(resultSet) : null;
        } catch (Throwable e) {
            throw new RuntimeException("Error In find by id! ");
        }
    }

}
