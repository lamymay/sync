package com.arc.core.model.domain.app.blog;

import com.arc.core.model.domain.BaseModel;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

/**
 * 博客说明表
 */
@Getter
@Setter
@ToString
public class BlogDescription extends BaseModel {

    private static final long serialVersionUID = 1L;

    private Long id;// 主键ID
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间
    private LocalDateTime updateDate;// 创建、更新时间

    private Long articleId;// 博客文章ID
    private String title;// 博客标题
    private String description;// 博客描述，如果缺省则去文章前200字
    private Integer word;// 文章字数
    private String keyword;// 博客关键字
    private Integer prefer;// 喜欢数
    private Integer clickCount;// 点击次数/查看人数
    private Long authorId;// 作者ID
    private Integer state;// 状态哦，是否置顶:0为否，1为是
}
