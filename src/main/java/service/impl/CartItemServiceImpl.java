package service.impl;
import entity.Cart;
import entity.CartItem;
import repository.CartItemRepository;
import service.CartItemService;

import java.sql.Connection;
import java.util.List;

public class CartItemServiceImpl extends BaseEntityServiceImpl<CartItem,Integer, CartItemRepository> implements
        CartItemService {
    public CartItemServiceImpl(CartItemRepository baseEntityRepository) {
        super(baseEntityRepository);
    }

    @Override
    public CartItem save(CartItem cartItem) {
        return baseEntityRepository.save(cartItem);
    }

    @Override
    public CartItem update(Integer id, String operator) {
        return baseEntityRepository.update(id,operator);
    }

    @Override
    public CartItem existByCartIdProductId(Integer cartId, Integer productId) {
        return baseEntityRepository.existByCartIdProductId(cartId,productId);
    }

    @Override
    public List<CartItem> showCartItem(Cart cart) {
        return baseEntityRepository.showCartItem(cart);
    }

    @Override
    public Integer calculatePrice(Cart cart) {
        return baseEntityRepository.calculatePrice(cart);
    }
}

