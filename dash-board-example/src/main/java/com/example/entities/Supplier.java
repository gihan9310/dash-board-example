package com.example.entities;

import com.example.dtos.OrderDetailsDTO;
import com.example.dtos.SupplierDTO;
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
@Table(name = "G_M_SUPPLIERS")
public class Supplier {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,length = 25,unique = true)
    private String regNumber;
    @Column(nullable = false,length = 99)
    private String supplierName;
    @Column(nullable = false,length = 99)
    private String businessName;
    @Column(nullable = false,length = 12)
    private String nic;
    @Column(nullable = false,length = 200)
    private String supplierAddress;
    @Column(nullable = false,length = 10)
    private String phoneNumber;
    @Column(nullable = false,length = 10)
    private String mobileNumber;
    @Column(nullable = false,length = 200)
    private String email;
    @Column(length = 50)
    private String businessReqNo;

    private LocalDate regDate;

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
    public SupplierDTO getDto(){
        SupplierDTO details = new SupplierDTO();
        BeanUtils.copyProperties(this,details);
        return details;
    }
}
