package com.arc.core.model.domain.app.enviroment;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 测试用例总体说明--以一个总体事情的维度去说明的--考虑和task公用模型
 *
 * @author 叶超
 * @since 2022/07/19
 */
@Deprecated
@Getter
@Setter
@ToString
public class TestCaseRoot implements Serializable {

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
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 测试用例编写者
     */
    private Long userId;

    /**
     * 测试用例编写者名称
     */
    private String username;

    /**
     * 主测试人的用户id
     */
    private Long testUserId;

    /**
     * 主开发人的用户id
     */
    private String testUsername;


    /**
     * 主开发人的用户id
     */
    private Long developUserId;

    /**
     * 主开发人的用户名
     */
    private String developerUsername;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 数据隔离用
     */
    private Integer profile;

    /**
     * 备注
     */
    private String remark;


    private LocalDateTime submitTestTime;

    private LocalDateTime finishSelfTestTime;

    private LocalDateTime finishTestTime;

    private LocalDateTime finalTestSuccessTime;

    /**
     * 测试用例执行了几次
     */
    private Integer totalTestTime;

    /**
     * 打回次数
     */
    private Integer totalRejectTime;

    /**
     * 关联的主任务id
     */
    private Long taskId;

    /**
     * 扩展字段
     */
    private String extend;

}
