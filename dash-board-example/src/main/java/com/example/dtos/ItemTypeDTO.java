package com.example.dtos;

import com.example.entities.ItemType;
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
public class ItemTypeDTO {

    private Long id;
    private String code;
    private String description;
    private String colorCode;


    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;


    @JsonIgnore
    public ItemType getEntity(){
        ItemType details = new ItemType();
        BeanUtils.copyProperties(this,details);
        return details;
    }
}
