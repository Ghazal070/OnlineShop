package service;

import entity.CartItem;
import entity.Product;
import repository.BaseEntityRepository;

public interface CartItemService extends BaseEntityService<CartItem,Integer> {
    CartItem save(CartItem cartItem);

}
