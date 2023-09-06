package com.arc.core.model.domain.app.blog;


import com.arc.core.model.domain.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 文章分类表
 *
 * @author Z
 */
@Getter
@Setter
@ToString
public class BlogCategory extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;// 文章自增ID
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间

    private String name;// 分类名称
    private Integer weight;// 该分类排序的权重
}
