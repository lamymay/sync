package com.arc.core.model.domain.system.common;

import com.arc.core.constant.NormalConstants;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.multipart.MultipartFile;

import java.io.Serializable;
import java.util.Date;

/**
 * 系统文件记录
 */
@Data
@Slf4j
@TableName("sys_file")
public class SysFile implements Serializable {

    /*
    CREATE TABLE `sys_file` (
  `id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
  `display_name` varchar(1024) DEFAULT NULL,
  `code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件编码',
  `hash` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '显示名称',
  `suffix` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '后缀',
  `length` bigint NOT NULL COMMENT '文件大小',
  `length_unit` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'B' COMMENT '文件大小单位',
  `remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
  `type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件类型',
  `location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `path` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '本地磁盘可访问地址(如果是本地文件)',
  `uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL,
  `context_path` varchar(32) NOT NULL COMMENT 'context_path',
  `flag` varchar(16) DEFAULT NULL,
  `status` int NOT NULL COMMENT '逻辑删除用的标识',
  `version` int NOT NULL COMMENT '版本信息id',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',
  PRIMARY KEY (`id`) USING BTREE,
  KEY `idx_code` (`code`) USING BTREE COMMENT '普通索引'
) ENGINE=InnoDB AUTO_INCREMENT=26 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统文件记录';

    * */
    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;
    private Date createTime;// 创建时间
    private Date updateTime;// 更新时间

    private String code;//编号
    private String hash;//hash
    private String displayName;//显示名称 文件 本身属性： 名称/大小/后缀/文件位置/类型
    private String suffix;// 后缀

    private String type;//   类型 文件还是图片 IMAGE/FILE  一般来说图片是可以直接预览的,
    private String remark;// 描述


    @Deprecated
    private String name;// 显示名称 //文件 本身属性： 名称/大小/后缀/文件位置/类型
    private Long length;// 文件大小
    private String lengthUnit;// 文件大小单位

    private String path;// 文件本地存放位置--如果是自己的环境应该是服务器的绝对路径
    private String host;// 文件持久化位置，用于 判断拼接url前部分    SERVER / DEVELOP  或者偷懒直接写 ip
    private String contextPath;// contextPath
    private String uri;// 文件存放  url = {host}:{port}+ uri


    private String location;// 文件持久化位置，用于 判断拼接url前部分    SERVER / DEVELOP
    private Integer version;// 版本信息id
    private Integer status;// 逻辑删除用的标识 0=删除的不可使用的

//    private String key;// 文件标识
//    private String checkType;// 校验方式
//    private String checkCode;// 校验码
//    private String thumbnailUri;//缩略图 注意仅仅图片应该由此相数据 图片类型有此属性，缩略图地址，其磁盘路径与主图path相似，在文件名称中加入small标识，格式：123_small.png
        /*


CREATE TABLE `sys_file` (

`id` bigint NOT NULL AUTO_INCREMENT COMMENT '主键id',
`display_name`  varchar(1024) DEFAULT NULL,
`code` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL COMMENT '文件编码',
`name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '显示名称',
`suffix` varchar(64) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '后缀',
`length` bigint NOT NULL COMMENT '文件大小',
`length_unit` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci NOT NULL DEFAULT 'B' COMMENT '文件大小单位',

`remark` varchar(500) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '描述',
`type` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '文件类型',

`host` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
`location` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
`path` varchar(2048) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL COMMENT '本地磁盘可访问地址(如果是本地文件)',
`uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci DEFAULT NULL,
`flag`          varchar(16)   DEFAULT NULL,
`status` int DEFAULT NULL COMMENT '逻辑删除用的标识',
`version` int DEFAULT NULL COMMENT '版本信息id',

`create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间',
`update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间',

PRIMARY KEY (`id`) USING BTREE,
KEY `idx_code` (`code`) USING BTREE COMMENT '普通索引'
) ENGINE=InnoDB AUTO_INCREMENT=1562385843270819842 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci COMMENT='系统文件记录';

       */

    public SysFile() {

    }

    public SysFile(Long id) {
        this.id = id;
    }

    public SysFile(String path, String code) {
        this.path = path;
        this.code = code;
    }


    /**
     * 构建可入库的数据
     *
     * @param file       MultipartFile
     * @param toDiskPath toDiskPath
     */
    public SysFile(MultipartFile file, String toDiskPath) {

        //全名
        String originalFilename = String.valueOf(file.getOriginalFilename());

        this.name = originalFilename;
        this.setRemark("MultipartFile");
        String suffix = "";
        int lastIndexOf = originalFilename.lastIndexOf(".");
        if (lastIndexOf != -1) {
            suffix = originalFilename.substring(lastIndexOf + 1);
        }
        this.suffix = suffix;
        this.length = file.getSize();
        this.path = toDiskPath;
//        int index = toDiskPath.lastIndexOf(File.separator);
//        this.setCode(toDiskPath.substring(index + 1, index + 45 + 1));
        Date now = new Date();
        this.createTime = now;
        this.updateTime = now;
        this.status = NormalConstants.STATUS_NOT_DELETE;
        this.version = NormalConstants.VERSION_INIT1;

    }

    public SysFile(String code, String displayName, String extension, String type, String remark, String name, Long length, String lengthUnit, String path, String host, String contextPath, String uri, String location) {
        this(code, displayName, extension, type, remark, name, length, lengthUnit, path, host, contextPath, uri, location, null, null);

    }

    public SysFile(String code, String displayName, String suffix, String type, String remark, String name, Long length, String lengthUnit, String path, String host, String contextPath, String uri, String location, Integer version, Integer status) {
        Date now = new Date();
        this.createTime = now;
        this.updateTime = now;

        this.code = code;
        this.displayName = displayName;
        this.suffix = suffix;
        this.type = type;
        this.remark = remark;
        this.name = name;
        this.length = length;
        this.lengthUnit = lengthUnit;

        this.path = path;
        this.host = host;
        this.contextPath = contextPath;
        this.uri = uri;

        this.location = location;

        this.status = status == null ? NormalConstants.STATUS_NOT_DELETE : status;
        this.version = version == null ? NormalConstants.VERSION_INIT1 : version;

    }
}

