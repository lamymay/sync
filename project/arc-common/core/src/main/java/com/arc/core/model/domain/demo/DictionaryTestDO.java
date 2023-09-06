package com.arc.core.model.domain.demo;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.sql.Timestamp;

/**
 * 数据字典DO
 *
 * @author may
 * @since 22.7.21 12:35 下午
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class DictionaryTestDO {

    /**
     * id
     */
    private Long id;

    /**
     * key
     */
    private String key;

    /**
     * 值
     */
    private String value;

    /**
     * 标识, 一个类型的字典其标识一样， tag+key 可以确定唯一一个数据
     */
    private String tag;

    /**
     * 注释
     */
    private String remark;

    /**
     * 状态 1:正常显示，2:隐藏
     */
    private Integer status;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 创建时间
     */
    private Timestamp createTime;

    /**
     * 更新时间
     */
    private Timestamp updateTime;

    public DictionaryTestDO(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
