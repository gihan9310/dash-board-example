package com.example.utils;

/**
 * |** @author 'Gihan Rathnayaka'**|
 */
public enum UNIQUE_KEYS {

    ITEM_TYPE_KEY ("TYPE_KEY00"),
    SUPPLIER_REQ ("SUPPLIER_REQ");
    ;

    private String key;

    UNIQUE_KEYS(String key) {
        this.key = key;
    }

    public String getKey() {
        return key;
    }


}
