package com.example.dtos;

import com.example.entities.Inventory;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

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
public class InventoryDTO {

    private Long id;
    private LocalDate orderDate;
    private String inventoryCode;
    private String status;
    private Double totalDiscountPer;
    private Double totalDiscountValue;
    private Double subTotal;
    private Double fullValue;
    private Long supplierId;

    @Valid
    List<InventoryDetailsDTO> details;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @JsonIgnore
    public Inventory getEntity(){
        Inventory item = new Inventory();
        BeanUtils.copyProperties(this,item);
        return item;
    }
}
