package com.example.dtos;

import com.example.entities.Item;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDateTime;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ItemDTO {

    private Long id;
    @NotBlank(message = "Item code can not be empty.")
    @Size(max = 20 ,message = "Item code too long")
    private String itemCode;
    private String itemDescription;
    @NotBlank(message = "Item type can not be empty.")
    private String itemType;
    private String itemPrice;
    private Integer aviableQty;
    private Double sellingPrice;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @JsonIgnore
    public Item getEntity(){
        Item item = new Item();
        BeanUtils.copyProperties(this,item);
        return item;
    }
}
