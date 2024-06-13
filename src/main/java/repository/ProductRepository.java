package repository;

import entity.Product;

public interface ProductRepository extends BaseEntityRepository<Product,Integer>{
    Product save(Product product);
    Product update(Integer id,String operator);
}
