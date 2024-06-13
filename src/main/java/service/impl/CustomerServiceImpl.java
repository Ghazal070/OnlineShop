package service.impl;

import entity.Cart;
import entity.Customer;
import repository.BaseEntityRepository;
import repository.CustomerRepository;
import service.CartService;
import service.CustomerService;
import util.AuthHolder;

public class CustomerServiceImpl extends BaseEntityServiceImpl<Customer, Integer, CustomerRepository> implements CustomerService {
    private final AuthHolder authHolder;
    private final CartService cartService;

    public CustomerServiceImpl(CustomerRepository baseEntityRepository, AuthHolder authHolder,CartService cartService) {
        super(baseEntityRepository);
        this.authHolder = authHolder;
        this.cartService = cartService;
    }

    @Override
    public boolean signUp(String username, String password) {
        if (!baseEntityRepository.existByName(username)) {
            Customer customer = baseEntityRepository.save(new Customer(username, password));
            if (customer != null) {
                authHolder.tokenId = customer.getId();
                authHolder.tokenName = customer.getUsername();
                cartService.save(new Cart(customer));
                return true;
            }

            return true;
        }
        return false;
    }

    @Override
    public boolean login(String username, String password) {
        Customer customer = baseEntityRepository.findByUserPassword(username, password);
        if (customer != null) {
            authHolder.tokenId = customer.getId();
            authHolder.tokenName = customer.getUsername();
            return true;
        }
        return false;
    }

    @Override
    public Customer findByUsername(String username) {
        return baseEntityRepository.findByUsername(username);
    }

    @Override
    public Customer save(Customer customer) {
        return baseEntityRepository.save(customer);
    }
}
