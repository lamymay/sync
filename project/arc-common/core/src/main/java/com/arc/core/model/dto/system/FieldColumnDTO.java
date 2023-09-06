package com.arc.core.model.dto.system;

import lombok.Data;

@Data
public class FieldColumnDTO {

    /**
     * 字段
     */
    private String dataIndex;

    /**
     * 字段中文
     */
    private String title;

    /**
     * react中对每个元素的标识key
     */
    private String key;


    public FieldColumnDTO(String key, String dataIndex, String title) {
        this.key = key;
        this.dataIndex = dataIndex;
        this.title = title;
    }
}
