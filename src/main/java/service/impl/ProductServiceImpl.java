package service.impl;

import entity.Product;
import repository.ProductRepository;
import repository.impl.CartRepositoryImpl;
import service.ProductService;

public class ProductServiceImpl extends BaseEntityServiceImpl<Product,Integer, ProductRepository>implements
        ProductService {
    public ProductServiceImpl(ProductRepository baseEntityRepository) {
        super(baseEntityRepository);
    }

    @Override
    public Product save(Product product) {
        return baseEntityRepository.save(product);
    }

    @Override
    public Product update(Integer id, String operator) {
        return baseEntityRepository.update(id,operator);
    }
}
