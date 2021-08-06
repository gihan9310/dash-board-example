package com.example.dtos;

import com.example.entities.OrderDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import java.time.LocalDateTime;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDetailsDTO {

    private Long id;
    private Integer itemQty;
    private Double itemPrice;
    private Double itemDiscountPer;
    private Double itemDiscountLine;
    private Long orderId;
    private Long itemId;
    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @JsonIgnore
    public OrderDetails getEntity(){
        OrderDetails details = new OrderDetails();
        BeanUtils.copyProperties(this,details);
        return details;
    }

}
