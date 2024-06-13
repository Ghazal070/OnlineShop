import entity.Cart;
import entity.Customer;
import util.ApplicationContext;

import java.sql.Connection;

public class OnlineShop {
    public static void main(String[] args) {
//        try {
//            ApplicationContext.getInstance().getMenu().show();
//        }catch (Throwable e){
//            e.getMessage();
//        }
     ApplicationContext.getInstance().getMenu().show();
 //       testDatabaseConnection();

    }

//    public static void testDatabaseConnection() {
//Customer ghazal = ApplicationContext.getInstance().customerService.findByUsername("ghazal");
//System.out.println(ghazal);


//        Cart cart = ApplicationContext.getInstance().cartService.save(new Cart(),Integer.class);
//        System.out.println(cart);
////
//        System.out.println(ghazal);

//        Customer customer = ApplicationContext.getInstance().customerService.save(new Customer("sara"),Integer.class);
//        System.out.println(customer);
////        try (Connection connection = ApplicationContext.getInstance().connection) {
////            String sql = "SELECT * FROM customer";
////            try (PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
////                ResultSet resultSet = preparedStatement.executeQuery();
////                while (resultSet.next()) {
////                    Customer customer = new Customer();
////                    customer.setId(resultSet.getInt("id")); // Assuming 'id' is the column name for the customer ID
////                    customer.setUsername(resultSet.getString("username"));
////                    customer.setPassword(resultSet.getString("password"));
////                    System.out.println(customer);
////                }
////                System.out.println("Database connection test successful.");
////            }
////        } catch (Exception e) {
////            System.out.println("Error testing database connection: " + e.getMessage());
////        }
 //   }

}

