package com.arc.core.model.domain.app.enviroment;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.Date;

/**
 * 简单table
 *
 * @author 叶超
 * @since 2021/04/15
 */
@Deprecated
@Getter
@Setter
@ToString
public class PlanTimeLine implements Serializable {

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

//    private String headKey;
//    private String headValue;

    private String dateLine;

    // 工程的一个版本维度的动作维度

    private Date developDesignReview;//设计评审 6月28日
    private Date testCaseReview;//测试用例评审 6月28日
    private Date finishDevelopSelfTest;//开发自测完成 7月5日
    private Date transferTest;//开发完成提交门户测试 7月6日
    private Date codeReview;//代码review 7月7-11日
    private Date transferOperationsMaintenance;//提交建运 7月13日
    private Date innerTestDarkLaunch;//门户灰度 7月15-18日
    private Date clientTestDarkLaunch;//端测灰度 7月18-20日
    private Date publish;//发布 7月21日

}
