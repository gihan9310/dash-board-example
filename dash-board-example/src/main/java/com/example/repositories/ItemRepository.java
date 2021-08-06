package com.example.repositories;

import com.example.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    boolean existsByItemCode(String code);
}
