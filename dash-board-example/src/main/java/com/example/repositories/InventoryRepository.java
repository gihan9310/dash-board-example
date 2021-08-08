package com.example.repositories;

import com.example.entities.Inventory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface InventoryRepository extends JpaRepository<Inventory ,Long> {
}
