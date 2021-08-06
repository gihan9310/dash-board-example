package com.example.dtos;

import com.example.entities.Customer;
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
public class CustomerDTO {

    private Long id;

    @NotBlank(message = "Customer name required.")
    @Size(max = 100,message = "Customer name max lenght 100 charactors.")
    private String customerName;
    @NotBlank(message = "Customer name required.")
    @Size(max = 100,message = "Customer name max lenght 100 charactors.")
    private String customerAddress ;
    @NotBlank(message = "Customer nic required.")
    @Size(max = 100,min = 10 ,message = "Customer nic max lenght 10 min leght 10 charactors.")
    private String nic ;
    @NotBlank(message = "Customer mobile number required.")
    @Size(max = 12,min = 10 ,message = "Customer mobile number  max leght 10 min lenght 10 charactors.")
    private String mobileNumber;

    private LocalDateTime createdDate;
    private LocalDateTime updatedDate;

    @JsonIgnore
    public Customer getEntity(){
        Customer item = new Customer();
        BeanUtils.copyProperties(this,item);
        return item;
    }

}
