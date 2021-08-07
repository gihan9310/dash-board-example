package com.example.dtos;

import com.example.entities.Supplier;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.BeanUtils;

import javax.persistence.Column;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SupplierDTO {

    private Long id;
    private String regNumber;
    @NotBlank(message = "Supplier Name required.")
    @Size(max = 99 ,message = "Supplier Name registration number max characters 99.")
    private String supplierName;
    @NotBlank(message = "Business name required.")
    @Size(max = 99 ,message = "Business name number max characters 99.")
    private String businessName;
    @NotBlank(message = "Nic number required.")
    @Size(max = 12 ,message = "Nic number max characters 12.")
    private String nic;
    @NotBlank(message = "Supplier Address required.")
    @Size(max = 200 ,message = "Supplier Address max characters 200.")
    private String supplierAddress;
    @Column(nullable = false,length = 10)
    @NotBlank(message = "Supplier phone Number required.")
    @Size(max = 10 ,message = "Supplier phone Number max characters 10.")
    private String phoneNumber;
    @NotBlank(message = "Supplier mobile number required.")
    @Size(max = 10 ,message = "Supplier mobile Number max characters 10.")
    private String mobileNumber;
    @NotBlank(message = "Supplier email number required.")
    @Size(max = 200 ,message = "Supplier email Number max characters 200.")
    private String email;
    @NotBlank(message = "Supplier business registration number required.")
    @Size(max = 50 ,message = "Supplier business registration Number max characters 50.")
    private String businessReqNo;
    private LocalDate regDate;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @JsonIgnore
    public Supplier getEntity(){
        Supplier details = new Supplier();
        BeanUtils.copyProperties(this,details);
        return details;
    }
}
