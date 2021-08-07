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
public class ItemTypeDashBordDTO {

    private Long id;
    private String itemType;
    private String itemDescription;
    private String itemTypeColorCode;
    private String itemColorCode;
}
