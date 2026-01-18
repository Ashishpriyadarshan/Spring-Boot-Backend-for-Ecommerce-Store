package com.eazybytes.repository;

import com.eazybytes.model.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface CustomerRepository extends CrudRepository<Customer,Long> {

    //here the paramter can be anything i have given email doesn't mean it will search record using email
    //findByEmail is the name of the function and this helps JPA to understand that ok whatever parameter is provided i have
    //to find the Email using that parameter value that's why naming of function is very imp here:
    Optional<Customer> findByEmail(String email);

    boolean existsByEmail(String email);
}
