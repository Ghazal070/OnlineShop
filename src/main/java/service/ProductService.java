package service;

import entity.Product;

public interface ProductService extends BaseEntityService<Product,Integer> {
    Product save(Product product);
    Product update(Integer id,String operator);
}
