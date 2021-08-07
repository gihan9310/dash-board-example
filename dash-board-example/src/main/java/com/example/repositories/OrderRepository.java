package com.example.repositories;

import com.example.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
public interface OrderRepository extends JpaRepository<Order ,Long> {

    Long countAllByStatus(String  status);


}
