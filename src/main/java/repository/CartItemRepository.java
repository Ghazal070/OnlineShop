package repository;

import entity.Cart;
import entity.CartItem;
import entity.Product;

import java.util.List;

public interface CartItemRepository extends BaseEntityRepository<CartItem,Integer>{
    CartItem save(CartItem cartItem);
    CartItem update(Integer id,String operator);
    CartItem existByCartIdProductId(Integer cartId, Integer productId);
    List<CartItem> showCartItem(Cart cart);
    Integer calculatePrice(Cart cart);
}
