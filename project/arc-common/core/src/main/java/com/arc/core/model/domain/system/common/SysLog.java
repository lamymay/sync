package com.arc.core.model.domain.system.common;

import lombok.Data;

import java.io.Serializable;
import java.util.Date;


/**
 * 系统操作动作记录
 * excel 导入记录（实际上是个汇总表）
 *
 * @author MAY
 * @since 2022/01
 */
@Data
//@TableName("sys_log")
public class SysLog implements Serializable {

    private static final long serialVersionUID = 1L;

    /*
    CREATE TABLE `action_log` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `status` int DEFAULT NULL COMMENT '逻辑删除用的标识',
  `operator_id` bigint DEFAULT NULL COMMENT '操作人id',
  `template_id` bigint DEFAULT NULL COMMENT '模版id',
  `file_name` varchar(255) DEFAULT NULL COMMENT '文件名称',
  `remark` varchar(1000) DEFAULT NULL COMMENT '注释',
  `content` varchar(3000) DEFAULT NULL COMMENT '内容',
  `source_file_uri` varchar(3000) DEFAULT NULL COMMENT '原文件地址',
  `result_file_uri` varchar(3000) DEFAULT NULL COMMENT '结果地址',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `expire_time` datetime NOT NULL COMMENT '过期时间',
  `flag` int DEFAULT NULL COMMENT '1=excel操作记录 2=email验证码',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB AUTO_INCREMENT=1508123608134733827 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统操作动作记录';
     */
//    @TableId(value = "id", type = IdType.AUTO)
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
     * 操作人id
     */
    private Long operatorId;

    /**
     * 模版id
     */
    private Long templateId;

    /**
     * 文件名称
     */
    private String fileName;

    /**
     * 注释 1000
     */
    private String remark;

    /**
     * 内容 3000
     */
    private String content;

    /**
     * 过期时间
     */
    private Date expireTime;

    /**
     * 1=excel操作记录 2=email验证码
     */
    private Integer flag;

    /**
     * 原文件地址
     */
    private String sourceFileUri;

    /**
     * 结果地址
     */
    private String resultFileUri;

}

//    private Long id;
//
//    /**
//     * 完成解析时间
//     */
//    private Date finish_parse_time;
//
//    /**
//     * 完成处理时间
//     */
//    private Date finish_process_time;
//
//
//
//    /**
//     * 模版CODE（唯一区分模版的标识） excel支持多sheet 如果不同sheet数据结构不同应该对应不同模版的！
//     */
//    private String templateCode;
//
//    //  `total_row` bigint NOT NULL COMMENT 'Excel总行数',
//    //  `success_row` int DEFAULT NULL COMMENT '本批操作成功行数',
//    //  `failure_row` int DEFAULT NULL COMMENT '本批操作失败行数',
//    //  `community_id` bigint NOT NULL COMMENT '小区id(涉及小区id是单小区情况下)',
//    //  `city_name` varchar(16) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT '0' COMMENT '城市名称（单城市情况下)',
//    //  PRIMARY KEY (`id`) USING BTREE
//    //) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='';
//
//
//    /**
//     * 操作动作记录  varchar(1000)
//     */
//    private String message;

