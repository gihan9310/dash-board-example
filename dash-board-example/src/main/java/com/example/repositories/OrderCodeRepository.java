package com.example.repositories;

import com.example.entities.OrderCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface OrderCodeRepository extends JpaRepository<OrderCode,Long> {

    boolean existsById(Long id);
}
