package entity;

import java.util.ArrayList;
import java.util.List;

public class Cart extends BaseEntity<Integer>{
    public static final String TABLE_NAME = "cart";
    public static final String CUSTOMER_ID = "customer_id";
    private Customer customer;
    List<CartItem> cartItemList= new ArrayList<CartItem>();
//    private List <CartItem> cartItemList = new ArrayList<>();

    public Cart(Integer id, Customer customer) {
        super(id);
        this.customer = customer;
    }
    public Cart(Customer customer) {
        this.customer = customer;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    @Override
    public String toString() {
        return "Cart{" +
                "customer=" + customer +
                "} " + super.toString();
    }
    //    public List<CartItem> getCartItemList() {
//        return cartItemList;
//    }
//
//    public void setCartItemList(List<CartItem> cartItemList) {
//        this.cartItemList = cartItemList;
//    }
//    public void addCartItemToList(CartItem cartItem){
//        cartItemList.add(cartItem);
//    }
}
