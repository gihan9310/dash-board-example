package com.example.servies;

import com.example.dtos.ItemTypeDTO;
import com.example.entities.ItemType;
import com.example.exceptions.ItemTypeException;
import com.example.repositories.ItemRepository;
import com.example.repositories.ItemTypeRepository;
import com.example.utils.UNIQUE_KEYS;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Service
@Slf4j
public class ItemTypeService {

    @Autowired
    private ItemTypeRepository itemTypeRepository;
    @Autowired
    private UniqueKeyService uniqueKeyService;
    @Autowired
    private ItemRepository itemRepository;

    @Transactional
    public ItemTypeDTO create(ItemTypeDTO dto){
        try {
            log.debug("Saving Item Type.");
            ItemType entity = dto.getEntity();
            entity.setCode(uniqueKeyService.getNexCode(UNIQUE_KEYS.ITEM_TYPE_KEY.getKey()));
            return this.itemTypeRepository.save(entity).getDto();
        }catch (Exception e){
           throw new ItemTypeException("Item can not save.");
        }

    }

    public List<ItemTypeDTO> getAllItemTypes(){
        try {
            log.debug("Finding All Items............");
            List<ItemTypeDTO> list = new ArrayList<>();
            List<ItemType> all = itemTypeRepository.findAll();
            all.forEach(i->list.add(i.getDto()));
            return list;
        }catch (Exception e){
            throw new ItemTypeException("Can not get all Item typs");
        }
    }

    public ItemTypeDTO update(ItemTypeDTO dto) {

        try {
            log.debug("Updating Item Type.");
            ItemType entity = dto.getEntity();
            return this.itemTypeRepository.save(entity).getDto();
        }catch (Exception e){
            throw new ItemTypeException("Item can not update.");
        }
    }

    public Long delete(Long id){
        try {
            log.debug("Updating Item Type.");
            Optional<ItemType> itemType = itemTypeRepository.findById(id);
            if(!itemType.isPresent()){
                throw new ItemTypeException("Item type not fount.");
            }
            if(itemRepository.existsByItemType(itemType.get().getCode())){
                throw new ItemTypeException("Item type in a relationship.");
            }
            this.itemTypeRepository.delete(itemType.get());
            return id;
        }catch (Exception e){
            e.printStackTrace();
            throw new ItemTypeException(e.getMessage());
        }
    }
}
