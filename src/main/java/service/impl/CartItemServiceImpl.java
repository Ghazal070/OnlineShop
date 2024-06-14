package service.impl;
import entity.CartItem;
import repository.CartItemRepository;
import service.CartItemService;

import java.sql.Connection;

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
}

