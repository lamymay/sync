package com.arc.core.model.domain.app.task;

import com.arc.core.model.dto.system.FieldColumnDTO;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author 叶超
 * @since 2021/04/15
 */
@Slf4j
@Getter
@Setter
@ToString
public class Task implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 本系统中的id是主键
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 编号
     */
    private String code;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 跟新时间
     */
    private Date updateTime;

    /**
     * 操作人ID(本系统唯一的用户id)/测试用例编写者
     */
    private Long operatorId;

    /**
     * 操作人名称
     */
    private String operator;

    /**
     * 数据分组(数据隔离用)
     */
    private Integer profile;

    /**
     * 目标(长限制2048)
     */
    private String todo;

    /**
     * 备注
     */
    private String remark;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 扩展字段
     */
    private String extend;


//    /**
//     * 测试用例编写者
//     */
//    private Long userId;
//
//    /**
//     * 测试用例编写者名称
//     */
//    private String username;

//    /**
//     * 主测试人的用户id
//     */
//    private Long testUserId;
//
//    /**
//     * 主开发人的用户id
//     */
//    private String testUsername;


//    /**
//     * 主开发人的用户id
//     */
//    private Long developUserId;
//
//    /**
//     * 主开发人的用户名
//     */
//    private String developerUsername;


    //提交测试时间 submit_test_time
    private Date submitTestTime;

    //完成自测时间  finish_self_test_time
    private Date finishSelfTestTime;

    //完成测试时间  finish_test_time
    private Date finishTestTime;

    //最终完成时间 final_finish_time
    private Date finalFinishTime;

    /**
     * 测试用例执行了几次 total_test_time
     */
    private Integer totalTestTime;

    /**
     * 打回次数 reopen_time
     */
    private Integer reopenTime;


    // 工程的一个版本维度的动作维度
//    private String dateLine;

//    private String 需求;
//    private String 方案;
//    private String 执行;
//    private String 终止;
//
//
//    private Date developDesignReview;//设计评审 6月28日
//    private Date testCaseReview;//测试用例评审 6月28日
//    private Date finishDevelopSelfTest;//开发自测完成 7月5日
//    private Date transferTest;//开发完成提交门户测试 7月6日
//    private Date codeReview;//代码review 7月7-11日
//    private Date transferOperationsMaintenance;//提交建运 7月13日
//    private Date innerTestDarkLaunch;//门户灰度 7月15-18日
//    private Date clientTestDarkLaunch;//端测灰度 7月18-20日
//    private Date publish;//发布 7月21日

    public static List<FieldColumnDTO> getHeaderDescription() {
        List<FieldColumnDTO> fields = new ArrayList<>();
        fields.add(new FieldColumnDTO("id", "id", "ID"));
        fields.add(new FieldColumnDTO("code", "code", "编号"));
        fields.add(new FieldColumnDTO("profile", "profile", "数据分组(数据隔离用)"));
        fields.add(new FieldColumnDTO("todo", "todo", "目标(长限制2048)"));
        fields.add(new FieldColumnDTO("remark", "remark", "备注"));
        fields.add(new FieldColumnDTO("status", "status", "状态"));
        fields.add(new FieldColumnDTO("totalTestTime", "totalTestTime", "测试用例执行了几次"));
        fields.add(new FieldColumnDTO("reopenTime", "reopenTime", "打回次数"));
        fields.add(new FieldColumnDTO("submitTestTime", "submitTestTime", "提交测试时间"));
        fields.add(new FieldColumnDTO("finishSelfTestTime", "finishSelfTestTime", "完成自测时间"));
        fields.add(new FieldColumnDTO("finishTestTime", "finishTestTime", "完成测试时间"));
        fields.add(new FieldColumnDTO("finalFinishTime", "finalFinishTime", "最终完成时间"));
        fields.add(new FieldColumnDTO("createTime", "createTime", "创建时间"));
        fields.add(new FieldColumnDTO("updateTime", "updateTime", "更新时间"));
        fields.add(new FieldColumnDTO("operatorId", "operatorId", "操作人ID"));
        fields.add(new FieldColumnDTO("operator", "operator", "操作人名称"));
        fields.add(new FieldColumnDTO("extend", "extend", "扩展字段"));

        return fields;
    }

    /* public static void main(String[] args) {
         if (System.out.printf("A")==null) {
             System.out.println("A");
             PrintStream a = System.out.printf("A");
         } else {
             System.out.println("B");
         }
     }*/


}
