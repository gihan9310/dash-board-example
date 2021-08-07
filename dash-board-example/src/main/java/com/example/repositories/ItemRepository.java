package com.example.repositories;

import com.example.dtos.dash_bord.ItemTypeDashBordDTO;
import com.example.entities.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Repository
public interface ItemRepository extends JpaRepository<Item,Long> {

    boolean existsByItemCode(String code);

    Long countAllByItemCodeIsNotNull();

    @Query(value ="SELECT new com.example.dtos.dash_bord.ItemTypeDashBordDTO( a.id, a.itemType,a.itemDescription,a.itemTypeColorCode,a.itemCode) FROM Item a GROUP BY a.itemType")
    List<ItemTypeDashBordDTO> getAllItemType();

    boolean existsByItemType(String itemType);
}
