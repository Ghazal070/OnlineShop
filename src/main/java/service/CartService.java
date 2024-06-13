package service;

import entity.Cart;
import entity.Customer;

public interface CartService extends BaseEntityService<Cart,Integer>{
    Cart save(Cart entity) ;
}
