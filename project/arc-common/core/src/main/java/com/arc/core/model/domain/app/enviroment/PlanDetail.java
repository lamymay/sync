package com.arc.core.model.domain.app.enviroment;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 简单table
 *
 * @author 叶超
 * @since 2021/04/15
 */
@Getter
@Setter
@ToString
public class PlanDetail implements Serializable {

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
     * 主任务id
     */
    private Long plainId;



}
