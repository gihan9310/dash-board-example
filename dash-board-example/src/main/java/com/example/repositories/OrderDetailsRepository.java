package com.example.repositories;

import com.example.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {

    boolean existsByItemId(Long id);
}
