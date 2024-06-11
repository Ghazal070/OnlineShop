package service.impl;

import entity.Customer;
import repository.BaseEntityRepository;
import repository.CustomerRepository;
import service.CustomerService;
import util.AuthHolder;

public class CustomerServiceImpl extends BaseEntityServiceImpl<Customer, Integer, CustomerRepository> implements CustomerService {
    private final AuthHolder authHolder;

    public CustomerServiceImpl(CustomerRepository baseEntityRepository, AuthHolder authHolder) {
        super(baseEntityRepository);
        this.authHolder = authHolder;
    }

    @Override
    public boolean signUp(String username, String password) {
        if (!baseEntityRepository.existByName(username)) {
            baseEntityRepository.save(new Customer(username, password), Integer.class);
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
}
