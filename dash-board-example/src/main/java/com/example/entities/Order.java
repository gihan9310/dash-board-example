package com.example.entities;

import com.example.dtos.OrderDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "G_T_ORDERS")
public class Order implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 30,unique = true)
    private String orderCode;
    private LocalDate orderDate;
    private Float totalDiscountPer;
    private Double totalDiscountValue;
    private Double subTotal;
    private Double balanceAmount;
    private String orderBy;
    @Column(length = 1)
    private String status;


    private Long customerId;

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
    public OrderDTO getDto(){
        OrderDTO dto = new OrderDTO();
        BeanUtils.copyProperties(this,dto);
        dto.setId(null);
        return dto;
    }
}
