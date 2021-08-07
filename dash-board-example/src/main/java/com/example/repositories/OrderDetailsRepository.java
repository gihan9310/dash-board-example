package com.example.repositories;

import com.example.entities.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface OrderDetailsRepository extends JpaRepository<OrderDetails,Long> {

    boolean existsByItemId(Long id);
    @Query(value="SELECT sum(a.itemQty) FROM OrderDetails a WHERE a.itemId=?1")
    Long countByItemId(Long id);
}
