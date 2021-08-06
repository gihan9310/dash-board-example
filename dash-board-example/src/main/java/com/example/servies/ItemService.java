package com.example.servies;

import com.example.dtos.ItemDTO;
import com.example.entities.Item;
import com.example.exceptions.ItemException;
import com.example.repositories.ItemRepository;
import com.example.repositories.OrderDetailsRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Service
public class ItemService {

    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;

    @Transactional
    public ItemDTO save(ItemDTO dto){
        try {
            if(itemRepository.existsByItemCode(dto.getItemCode())){
                throw new ItemException("Already Used ItemCode");
            }
           return itemRepository.save(dto.getEntity()).getDto();
        } catch (Exception  e) {
            e.printStackTrace();
            return null;
        }
    }

    public List<ItemDTO> getAllItems() {
        try {
            List<Item> items = itemRepository.findAll();
            List<ItemDTO> itemsList = new ArrayList<>();
            items.forEach(i->itemsList.add(i.getDto()));
            return itemsList;
        }catch (Exception e){
            throw new ItemException("Items Selection Error");
        }
    }

    public ItemDTO update(ItemDTO dto) {

        try {
            return itemRepository.save(dto.getEntity()).getDto();
        }catch (ItemException  e) {
            throw new ItemException("Already Used ItemCode");
        } catch (Exception  e) {
            e.printStackTrace();
            return null;
        }
    }

    public Long delete(Long id) {

        try {
            if(orderDetailsRepository.existsByItemId( id)){
                throw new ItemException("Item In relationship.");
            }
             itemRepository.delete(itemRepository.getById(id));
            return id;
        }catch (ItemException  e) {
            throw new ItemException(e.getMessage());
        } catch (Exception  e) {
            e.printStackTrace();
            return null;
        }
    }
}
