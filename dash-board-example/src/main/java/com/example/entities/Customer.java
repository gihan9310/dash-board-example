package com.example.entities;

import com.example.dtos.CustomerDTO;
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
@Table(name = "G_ORDER_CUSTOMERS")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 100,nullable = false)
    private String customerName;
    @Column(length = 100,nullable = false)
    private String customerAddress ;
    @Column(length = 12,unique = true)
    private String nic ;
    @Column(length = 10,unique = true)
    private String mobileNumber;

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
    public CustomerDTO getDto(){
        CustomerDTO item = new CustomerDTO();
        BeanUtils.copyProperties(this,item);
        return item;
    }
}
