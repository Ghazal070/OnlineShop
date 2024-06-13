package repository;

import entity.Customer;

public interface CustomerRepository extends BaseEntityRepository<Customer,Integer> {
    boolean existByName(String username);
    Customer findByUserPassword(String username,String password);
    Customer findByUsername(String username);
    Customer save (Customer customer);
}
