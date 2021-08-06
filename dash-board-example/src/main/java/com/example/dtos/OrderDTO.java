package com.example.dtos;

import com.example.entities.Order;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.validation.Valid;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {

    private Long id;
    private String orderCode;
    private LocalDate orderDate;
    private Float totalDiscountPer;
    private Double totalDiscountValue;
    private Double subTotal;
    private Double balanceAmount;
    private String orderBy;
    private String status;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @Valid
    private List<OrderDetailsDTO> dtoList ;

    @Valid
    private CustomerDTO customerDTO;

    @JsonIgnore
    public Order getEntity(){
        Order item = new Order();
        BeanUtils.copyProperties(this,item);
        return item;
    }
}
