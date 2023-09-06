package com.arc.core.model.domain.app.task;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 测试用例明细
 *
 * @author 叶超
 * @since 2021/04/15
 */
@Getter
@Setter
@ToString
@Deprecated
public class TestCase implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 本系统中的id是主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新时间
     */
    private Date updateTime;

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
     * 主开发人的用户名称
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
     * 备注-测试者
     */
    private String remark;

    /**
     * 备注-开发者
     */
    private String developRemark;


    /**
     * 测试用例编号
     */
    private String code;

    /**
     * 测试用例等级
     */
    private Integer level;

    /**
     * 用例描述
     */
    private String description;

    /**
     * 用例背景环境、参数、条件等
     */
    private String environment;

    /**
     * CURL
     */
    private String curl;

    /**
     * 怎么测试的
     */
    private String testPlan;

    /**
     * 预期结果
     */
    private String expectedResult;


    /**
     * 实际结果
     */
    private String actualResult;


    private LocalDateTime submitTestTime;

    private LocalDateTime finishSelfTestTime;

    private LocalDateTime finishTestTime;

    private LocalDateTime finalTestSuccessTime;

    /**
     * 测试用例执行了几次
     */
    private Integer testTime;

    /**
     * 打回次数
     */
    private Integer rejectTime;

    /**
     * 扩展字段
     */
    private String extend;

    /**
     * 关联的主任务id-冗余
     */
    private Long taskId;




}
