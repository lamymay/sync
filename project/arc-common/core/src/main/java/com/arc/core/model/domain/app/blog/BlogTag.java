package com.arc.core.model.domain.app.blog;


import com.arc.core.model.domain.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 文章标签表，多对多
 */
@Getter
@Setter
@ToString
public class BlogTag extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;// 文章自增ID
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间

    private String tagName;// 标签名称
}
