package com.example.entities;

import com.example.dtos.CustomerDTO;
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
@Table(name = "G_T_INVENTORY_DETAILS")
public class InventoryDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate orderDate;

    private LocalDateTime verifiedDate ;

    private Double orderQty;

    private Double actualQtyRecieved;

    private Double remainingQty;

    private Double discountPer;

    private Double discoutnValue;

    private Double itemPrice;

    private Double actualBuyingPrice;

    private Long itemType;

    private String itemCode;

    private Long itemId;

    private Long inventoryId;

    private LocalDate madeDate;

    private LocalDate expiryDate;

    @Column(length = 30)
    private String verifiedBy;

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
    public InventoryDetailsDTO getDto(){
        InventoryDetailsDTO item = new InventoryDetailsDTO();
        BeanUtils.copyProperties(this,item);
        return item;
    }

}
