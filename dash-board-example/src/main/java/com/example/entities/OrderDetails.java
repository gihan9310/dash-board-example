package com.example.entities;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

import com.example.dtos.OrderDetailsDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "G_T_ORDERS_Details")
public class OrderDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer itemQty;
    private Double itemPrice;
    private Double itemDiscountPer;
    private Double itemDiscountLine;
    @Column(nullable = false)
    private Long orderId;
    @Column(nullable = false)
    private Long itemId;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @JsonIgnore
    @PrePersist
    public void setCreatedDate() {
        this.createdDate = LocalDateTime.now();
    }
    @JsonIgnore
    @PreUpdate
    public void setUpdatedDate() {
        this.updatedDate = LocalDateTime.now();
    }
    @JsonIgnore
    public OrderDetailsDTO getEntity(){
        OrderDetailsDTO details = new OrderDetailsDTO();
        BeanUtils.copyProperties(this,details);
        return details;
    }
}
