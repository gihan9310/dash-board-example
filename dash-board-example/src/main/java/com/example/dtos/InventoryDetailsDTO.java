package com.example.dtos;

import com.example.entities.InventoryDetails;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InventoryDetailsDTO {

    private Long id;

    private LocalDateTime verifiedDate ;

    private Double orderQty;

    private Double actualQtyRecived;

    private Double remainingQty;

    private Double discountPer;

    private Double discoutnValue;

    private Long itemType;

    private Double itemPrice;

    private Double actualBuyingPrice;

    private String itemCode;

    @NotNull(message = "Item id con not null")
    private Long itemId;

    private Long inventoryId;

    private LocalDate madeDate;

    private LocalDate expiryDate;

    @Column(length = 30)
    private String verifiedBy;

    private LocalDateTime createdDate;

    private LocalDateTime updatedDate;

    @JsonIgnore
    public InventoryDetails getDto(){
        InventoryDetails item = new InventoryDetails();
        BeanUtils.copyProperties(this,item);
        return item;
    }
}
