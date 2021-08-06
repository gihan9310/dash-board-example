package com.example.repositories;

import com.example.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface CustomerRepository extends JpaRepository<Customer ,Long> {

    Customer findByNicOrMobileNumber(String nic ,String mobileNumber);
}
