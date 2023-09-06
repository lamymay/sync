package com.arc.core.model.domain.system.common;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

/**
 * 菜单表实体
 *
 * @author X
 */
@Getter
@Setter
@TableName("sys_menu")
public class Menu implements Serializable, Comparable<Menu> {

    private static final long serialVersionUID = 1L;

    //mybatisplus 自增id很大,改进：使用数据库自带的增长策略
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;// 自增id
    private Date createTime;// 创建时间
    private Date updateTime;// 更新时间

    private Integer systemId;// 适用系统的id
    private int level;// 级别，1=第一级，2=第二级，，，
    private Long parentId;// 父级id


    private String code;// 编码（备用）

    private String name;// 名中文称
    private String nameEnglish;// 英文名称 （备用）
    private int sort;// 排序用权重（数字小的在前面）
    private int status;// 状态，暂时规划true=非0/false=0
    private String url;// 菜单URL地址
    private String icon;// icon地址
    private String remark;// 备注

    @TableField(exist = false)//表示该属性不为数据库表字段
    private List<Menu> children; //非db字段

    public Menu() {
    }

    public Menu(Long id, Integer systemId, String name) {
        this.id = id;
        this.systemId = systemId;
        this.name = name;
    }

    @Override
    public int compareTo(Menu menu) {
        return this.sort - menu.getSort();
    }
}


/*

mybatis-plus使用对象属性进行SQL操作，经常会出现对象属性非表字段的情况，忽略映射字段时可以在实体类属性上使用以下注解：
@TableField(exist = false)：表示该属性不为数据库表字段

@TableField(exist = true)：表示该属性为数据库表字段。

@TableName：数据库表相关

@TableId：表主键标识

@TableField：表字段标识

@TableLogic：表字段逻辑处理注解（逻辑删除）


--
Hibernate实体类忽略非数据库字段注解：
@Transient

该注解可以加在属性上或者get方法上


* */