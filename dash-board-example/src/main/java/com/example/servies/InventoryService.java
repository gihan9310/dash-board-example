package com.example.servies;

import com.example.dtos.InventoryDTO;
import com.example.entities.Inventory;
import com.example.entities.InventoryDetails;
import com.example.exceptions.CommonException;
import com.example.repositories.InventoryDetailsRepository;
import com.example.repositories.InventoryRepository;
import com.example.utils.UNIQUE_KEYS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Service
@Slf4j
public class InventoryService {

    @Autowired
    private InventoryRepository inventoryRepository;
    @Autowired
    private InventoryDetailsRepository inventoryDetailsRepository;
    @Autowired
    private UniqueKeyService uniqueKeyService;

    @Transactional
    public InventoryDTO create(InventoryDTO dto) {

        try {
            Inventory entity = dto.getEntity();
            String nexCode = uniqueKeyService.getNexCode(UNIQUE_KEYS.INV_CODE.getKey());
            entity.setInventoryCode(nexCode);
            Inventory inventory = inventoryRepository.save(entity);
            List<InventoryDetails> listOfDetails = new ArrayList<>();
            dto.getDetails().forEach(i->{
                i.setInventoryId(inventory.getId());
                listOfDetails.add(i.getDto());
            });
            inventoryDetailsRepository.saveAll(listOfDetails);
            return inventory.getDto();

        }catch (Exception e){
            throw new CommonException("Can not save inventory.");
        }
    }
}
