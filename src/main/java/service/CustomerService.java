package service;

import entity.Customer;

public interface CustomerService extends BaseEntityService<Customer,Integer>{
    boolean signUp(String username,String password);
    boolean login(String username,String password);
}
