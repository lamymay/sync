package com.arc.core.model.domain.system.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.Date;

/**
 * key-value表(偷懒用)
 * 注意 key是没有做唯一约束的, 要想定位唯一的一个键值对需要加上range
 *
 * @author may
 * @since 2021/04/14
 */
@Getter
@Setter
@ToString
@TableName("sys_key_value")
public class KeyValue implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Date createTime;// 创建时间
    private Date updateTime;// 更新时间
    /**
     * 键
     */
    @TableField(value = "`key`")
    private String key;

    /**
     * 值
     */
    @TableField(value = "`value`")
    private String value;

    //private String valueType;

    /**
     * 适用范围,即类型
     */
    @TableField(value = "`range`")
    private String range;

    /**
     * 注释
     */
    private String remark;

    /**
     * 毫秒数
     */
    private long ttl;

    //    private EnableEnum enable;//枚举属性测试,非零=true=可用的/零=false=不可用(默认)
    //    private byte[] valueBinary;//值-二进制属性测试,blob类型

    public KeyValue() {

    }

    public KeyValue(String key, String value) {
        this.key = key;
        this.value = value;
    }
}
