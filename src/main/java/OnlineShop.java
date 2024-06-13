import entity.Cart;
import entity.CartItem;
import entity.Customer;
import entity.Product;
import entity.enumration.ProductCategory;
import entity.enumration.ProductSubType;
import util.ApplicationContext;

import java.sql.Connection;

public class OnlineShop {
    public static void main(String[] args) {
//        try {
//            ApplicationContext.getInstance().getMenu().show();
//        }catch (Throwable e){
//            e.getMessage();
//        }
//     ApplicationContext.getInstance().getMenu().show();
               testDatabaseConnection();

    }

    public static void testDatabaseConnection() {

//    Product product = ApplicationContext.getInstance().productService.save(new Product("radio", ProductCategory.Electronics,
//            ProductSubType.RADIO, 5000, 5));
//    Product product1 = ApplicationContext.getInstance().productService.save(new Product("television", ProductCategory.Electronics,
//            ProductSubType.TELEVISION, 10000, 10));
//    Product product3 = ApplicationContext.getInstance().productService.save(new Product("sportShoes", ProductCategory.Shoes,
//            ProductSubType.SPORT, 2000, 10));
    Product product4 = ApplicationContext.getInstance().productService.findByID(4);
    Cart cart = ApplicationContext.getInstance().cartService.findByID(6);
        ApplicationContext.getInstance().cartItemService.save(new CartItem(product4,cart,1));
//        System.out.println(product4);
//        CartItem cartItem = new CartItem(product4,)
//        ApplicationContext.getInstance().cartItemService.save()

}
}

