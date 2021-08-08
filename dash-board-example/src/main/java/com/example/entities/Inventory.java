package com.example.entities;

import com.example.dtos.InventoryDTO;
import com.example.dtos.InventoryDetailsDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "G_T_INVENTORIES")
public class Inventory {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDate orderDate;
    @Column(length = 30,nullable = false)
    private String inventoryCode;
    @Column(length = 1,nullable = false)
    private String status;
    private Double totalDiscountPer;
    private Double totalDiscountValue;
    private Double subTotal;
    private Double fullValue;
    private Long supplierId;

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
    public InventoryDTO getDto(){
        InventoryDTO item = new InventoryDTO();
        BeanUtils.copyProperties(this,item);
        return item;
    }

}
