package com.example.servies;

import com.example.dtos.OrderDTO;
import com.example.entities.*;
import com.example.exceptions.OrderException;
import com.example.repositories.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Service
@Slf4j
public class OrderService {

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

    @Transactional
    public OrderDTO create(OrderDTO dto){

        try {
        log.info("create invoice.");
            Customer customer = dto.getCustomerDTO().getEntity();
            Customer foundCustomer = customerRepository.findByNicOrMobileNumber(customer.getNic(), customer.getMobileNumber());
           if(foundCustomer==null){
               foundCustomer = customerRepository.save(customer);
           }
            Order entity = dto.getEntity();
            dto.setOrderDate(LocalDate.now());
            entity.setCustomerId(foundCustomer.getId());
            OrderCode orderCode = null;
            Optional<OrderCode> orderCodeIsPresent = orderCodeRepository.findById(1l);
            if(orderCodeIsPresent.isPresent()){
                orderCode  =orderCodeIsPresent.get();
            }else {
                orderCode= orderCodeRepository.save(new OrderCode(1l,"ABC",1l, LocalDateTime.now(),null));
            }
            entity.setOrderCode(orderCode.getPerfix()+"-"+orderCode.getNextNumber());
            orderCode.setNextNumber(orderCode.getNextNumber()+1);
            entity.setOrderDate(LocalDate.now());
            Order order = orderRepository.save(entity);
            List<OrderDetails> list = new ArrayList<>();

            dto.getDtoList().forEach(i->{
                i.setOrderId(order.getId());
                list.add(i.getEntity());
                if(itemRepository.findById(i.getItemId()).isPresent()){
                    Item item = itemRepository.findById(i.getItemId()).get();
                    if(item.getAviableQty()<i.getItemQty()){
                        throw new OrderException("Quantity Not Aviable.");
                    }
                    item.setAviableQty(item.getAviableQty()-i.getItemQty());
                }else {
                    throw  new OrderException("Item Cannot Fount.");
                }
            });

            orderDetailsRepository.saveAll(list);
            return order.getDto();

        }catch (Exception e){
            e.printStackTrace();
            throw  new OrderException("Order can not create. error Occure");
        }
    }
}
