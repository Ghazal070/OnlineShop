package repository.impl;

import entity.Customer;
import repository.CustomerRepository;
import util.QueryUtil;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CustomerRepositoryImpl extends BaseEntityRepositoryImpl<Customer,Integer> implements CustomerRepository {
    public CustomerRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    protected String getTableName() {
        return Customer.TABLE_NAME;
    }

    @Override
    protected List<String> getColumnNames() {
        List<String> columnNameList = new ArrayList<>();
        columnNameList.add(Customer.USERNAME);
        columnNameList.add(Customer.PASSWORD);
        return columnNameList;
    }

    @Override
    protected String getQuestionMarks(int length) {
        String result ="";
        for (int i = 0; i <= length; i++) {
            result+="?,";
        }
        return  result.substring(0,result.length()-1);
    }

    @Override
    protected Customer mapResultSetToBaseEntity(ResultSet resultSet) {
        try {
            return new Customer(resultSet.getString("username"),resultSet.getString("password"));
        } catch (Throwable e) {
            throw new RuntimeException("Error In mapping! ");
        }
    }

    @Override
    public boolean existByName(String username) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(QueryUtil.EXISTS_BY_NAME_QUERY_TEMPLATE, getTableName()))) {
            preparedStatement.setObject(1, username);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next();

        } catch (Throwable e) {
            throw new RuntimeException("Error In exist by name! ");
        }
    }

    @Override
    public Customer findByUserPassword(String username, String password) {
        try (PreparedStatement preparedStatement = connection.prepareStatement(
                String.format(QueryUtil.FIND_BY_USERNAME_PASSWORD_QUERY_TEMPLATE, getTableName()))) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(1, password);
            ResultSet resultSet = preparedStatement.executeQuery();
            return resultSet.next() ? mapResultSetToBaseEntity(resultSet) : null;
        } catch (Throwable e) {
            throw new RuntimeException("Error In find username or password ! ");
        }
    }
}
