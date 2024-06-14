package service.impl;

import entity.Cart;
import entity.CartItem;
import entity.Customer;
import repository.CartRepository;
import service.CartItemService;
import service.CartService;
import service.ProductService;
import util.AuthHolder;

public class CartServiceImpl extends BaseEntityServiceImpl<Cart,Integer, CartRepository> implements CartService {

private final AuthHolder authHolder;
private final ProductService productService;
private final CartItemService cartItemService;
    public CartServiceImpl(CartRepository baseEntityRepository, AuthHolder authHolder, ProductService productService, CartItemService cartItemService) {

        super(baseEntityRepository);
        this.authHolder = authHolder;
        this.productService = productService;
        this.cartItemService = cartItemService;
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
        if(cartItem!=null){
            if(productService.findByID(cartItem.getProduct().getId()).getCountInShop()>0){
                CartItem cartItemWithID= cartItemService.existByCartIdProductId(cartItem.getCart().getId(),cartItem.getProduct().getId());
                if(cartItemWithID!=null){
                    int countInCart=cartItemWithID.getCountInCart();
                    cartItemWithID.setCountInCart(countInCart++);
                    cartItemService.update(cartItemWithID.getId(),"+");
                    productService.update(cartItem.getProduct().getId(),"-");
                }else {
                    cartItemService.save(cartItem);
                }
                return true;
            }
        }
        return false;
    }
    @Override
    public Boolean remove(CartItem cartItem) {
        if(cartItem!=null){
            if(productService.findByID(cartItem.getProduct().getId()).getCountInShop()>0){
                CartItem cartItemWithID= cartItemService.existByCartIdProductId(cartItem.getCart().getId(),cartItem.getProduct().getId());
                if(cartItemWithID!=null){
                    int countInCart=cartItemWithID.getCountInCart();
                    cartItemWithID.setCountInCart(countInCart++);
                    cartItemService.update(cartItemWithID.getId(),"+");
                    productService.update(cartItem.getProduct().getId(),"-");
                }else {
                    cartItemService.save(cartItem);
                }
                return true;
            }
        }
        return false;
    }

    @Override
    public Cart findByCustomerID(Integer id) {
        return baseEntityRepository.findByCustomerID(id);
    }

}
