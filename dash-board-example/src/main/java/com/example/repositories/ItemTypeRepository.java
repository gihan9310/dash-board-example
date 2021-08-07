package com.example.repositories;

import com.example.entities.ItemType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Repository
public interface ItemTypeRepository extends JpaRepository<ItemType,Long> {

}
