package com.arc.core.model.domain.app.enviroment;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 计划表模型
 *
 * @author 叶超
 * @since 2021/04/15
 */
@Getter
@Setter
@ToString
public class Plan implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 本系统中的id是主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;

    /**
     * 跟新时间
     */
    private LocalDateTime updateTime;

    /**
     * 本系统唯一的用户id
     */
    private Long userId;

    /**
     * 小目标存在此字段上,是有效数据,长度2048
     */
    private String todo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 数据隔离用
     */
    private Integer profile;

    /**
     * 状态
     */
    private Integer status;





}
