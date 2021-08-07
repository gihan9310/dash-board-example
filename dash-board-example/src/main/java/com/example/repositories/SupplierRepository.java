package com.example.repositories;

import com.example.entities.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface SupplierRepository extends JpaRepository<Supplier ,Long> {
}
