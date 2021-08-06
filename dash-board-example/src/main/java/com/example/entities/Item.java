package com.example.entities;

import com.example.dtos.ItemDTO;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.*;
import java.time.LocalDateTime;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "G_T_ITEMS")
public class Item {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(length = 20,unique = true,nullable = false,updatable = false)
    private String itemCode;
    @Column(length = 100)
    private String itemDescription;
    private String itemType;
    private String itemPrice;
    private Integer aviableQty;
    private Double sellingPrice;

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
    public ItemDTO getDto(){
        ItemDTO item = new ItemDTO();
        BeanUtils.copyProperties(this,item);
        return item;
    }
}
