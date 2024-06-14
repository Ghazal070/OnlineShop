package repository.impl;

import entity.Customer;
import entity.Product;
import entity.enumration.ProductCategory;
import entity.enumration.ProductSubType;
import repository.ProductRepository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

public class ProductRepositoryImpl extends BaseEntityRepositoryImpl<Product, Integer> implements ProductRepository {
    public ProductRepositoryImpl(Connection connection) {
        super(connection);
    }

    @Override
    public Product save(Product product) {
        String insertQuery = "insert into product(name,product_category,product_sub_type,price,countinshop) values (?,cast(? as product_category),cast(? as product_sub_type),?,?)";

        try (PreparedStatement preparedStatement = connection.prepareStatement(insertQuery,
                PreparedStatement.RETURN_GENERATED_KEYS)) {

            preparedStatement.setString(1, product.getName());
            preparedStatement.setString(2, String.valueOf(product.getProductCategory()));
            preparedStatement.setString(3, String.valueOf(product.getProductSubType()));
            preparedStatement.setDouble(4, product.getPrice());
            preparedStatement.setInt(5, product.getCountInShop());
            if (preparedStatement.executeUpdate() > 0) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                if (resultSet.next()) {
                    product.setId(resultSet.getInt("id"));
                    resultSet.close();
                }
            }
        } catch (Throwable e) {
            throw new RuntimeException("Error In save product ! ");
        }


        return product;
    }


    @Override
    public Product update(Integer id,String operator) {
        Product productOld = findByID(id);
        int countNew= productOld.getCountInShop();
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
                                update product set countinshop=?
                                where id=?
                                """;
        try (PreparedStatement preparedStatement = connection.prepareStatement(selectQuery)) {
            preparedStatement.setInt(1,countNew);
            preparedStatement.setInt(2, id);
            preparedStatement.executeUpdate();
            productOld.setCountInShop(countNew);
            return productOld;

        } catch (Throwable e) {
            throw new RuntimeException("Error In find username or password ! ");
        }
    }

    @Override
    protected String getTableName() {
        return Product.TABLE_NAME;
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
    protected Product mapResultSetToBaseEntity(ResultSet resultSet) {
        try {
            return new Product(resultSet.getInt("id"),resultSet.getString("name"),
               ProductCategory.valueOf(resultSet.getString("product_category")),
                    ProductSubType.valueOf(resultSet.getString("product_sub_type")),
                    resultSet.getDouble("price"),resultSet.getInt("countinshop")
                    );
        } catch (Throwable e) {
            throw new RuntimeException(e);
        }

    }
}
