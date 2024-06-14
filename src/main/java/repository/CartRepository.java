package repository;

import entity.Cart;

public interface CartRepository extends BaseEntityRepository<Cart,Integer> {


    Cart save(Cart entity);
    Cart findByCustomerID (Integer id);

}
