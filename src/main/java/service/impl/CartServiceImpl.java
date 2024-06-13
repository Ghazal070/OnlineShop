package service.impl;

import entity.Cart;
import entity.CartItem;
import entity.Customer;
import repository.CartRepository;
import service.CartService;
import util.AuthHolder;

public class CartServiceImpl extends BaseEntityServiceImpl<Cart,Integer, CartRepository> implements CartService {

private final AuthHolder authHolder;
    public CartServiceImpl(CartRepository baseEntityRepository, AuthHolder authHolder) {

        super(baseEntityRepository);
        this.authHolder = authHolder;
    }

    @Override
    public Cart save(Cart entity) {
        Customer customer = new Customer(authHolder.tokenId,authHolder.tokenName);
        if(customer!=null){
            entity.setCustomer(customer);
        }
        return baseEntityRepository.save(entity);
    }

    @Override
    public Boolean add(CartItem cartItem) {
        return null;
    }
}
