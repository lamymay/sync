package com.arc.core.model.domain.system.security;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 组织(公司)
 *
 * @author 叶超
 * @since 2018/12/26 11:28
 */
@Data
@TableName("sys_group")
@Deprecated
public class Group implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 自增id
    @Deprecated
    private String code;// 编号
    private Integer status;// 状态

    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间
    private String creator;//创建者
    private String editor;//更新者

    private String name;// 组织(公司)名称
    private String avatar;// 图标
    private String description;// 描述

    public Group() {
    }


}