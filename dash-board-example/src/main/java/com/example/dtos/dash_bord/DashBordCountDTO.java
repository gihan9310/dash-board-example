package com.example.dtos.dash_bord;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class DashBordCountDTO {

    private Long ordersCount =0l;
    private Long itemsCount =0l;
    private Long numberOfCustomer =0l;

}
