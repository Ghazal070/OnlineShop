package entity;

import java.util.ArrayList;
import java.util.List;

public class Cart extends BaseEntity<Long>{

    private Customer customer;
//    private List <CartItem> cartItemList = new ArrayList<>();

    public Cart(Long id, Customer customer) {
        super(id);
        this.customer = customer;
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
