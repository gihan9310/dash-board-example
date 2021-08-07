package com.example.servies;

import com.example.dtos.dash_bord.ChartDTO;
import com.example.dtos.dash_bord.DashBordCountDTO;
import com.example.dtos.dash_bord.DataListDTO;
import com.example.dtos.dash_bord.ItemTypeDashBordDTO;
import com.example.exceptions.ItemException;
import com.example.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Service
@Slf4j
public class DashBoardService {

    @Autowired
    private OrderRepository orderRepository;
    @Autowired
    private OrderDetailsRepository orderDetailsRepository;
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private OrderCodeRepository orderCodeRepository;
    @Autowired
    private ItemRepository itemRepository;


    public DashBordCountDTO getCount(){

        log.info("Get Count.......");
        try {
            Long orderCount = orderRepository.countAllByStatus("A");
            Long itemCount =itemRepository.countAllByItemCodeIsNotNull();
            long customerCount = customerRepository.count();
            return new DashBordCountDTO(orderCount,itemCount,customerCount);
        }catch (Exception e){
            throw new ItemException(e.getMessage());
        }

    }


    public ChartDTO getAllItemTypes() {

        try {
            List<ItemTypeDashBordDTO> itemTypeDashBordDTOS = itemRepository.getAllItemType();
            List<String> lable = new ArrayList<>();
            DataListDTO dataList = new DataListDTO();
             List<Long> data = new ArrayList<>();
             List<String> backgroundColor = new ArrayList<>();
             List<String>hoverBackgroundColo = new ArrayList<>();
             int count =1;
             for (ItemTypeDashBordDTO i: itemTypeDashBordDTOS){
                 lable.add(i.getItemDescription());
                 data.add(orderDetailsRepository.countByItemId(i.getId()));
                 backgroundColor.add(i.getItemTypeColorCode());
                 hoverBackgroundColo.add(i.getItemTypeColorCode());
                 ++count;
             }
            dataList.setBackgroundColor(backgroundColor);
            dataList.setData(data);
            dataList.setHoverBackgroundColor(hoverBackgroundColo);
            return new ChartDTO(lable,dataList);
        }catch (Exception e){
            throw new ItemException(e.getMessage());
        }

    }
}
