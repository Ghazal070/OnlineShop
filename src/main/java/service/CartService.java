package service;

import entity.Cart;
import entity.CartItem;
import entity.Customer;

public interface CartService extends BaseEntityService<Cart,Integer>{
    Cart save(Cart entity) ;
    Boolean add(CartItem cartItem);
    Boolean remove(CartItem cartItem);
    Cart findByCustomerID(Integer id);

}
