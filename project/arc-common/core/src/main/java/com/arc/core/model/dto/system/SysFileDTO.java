package com.arc.core.model.dto.system;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * @author may
 * @since 2021.09.27 6:36 下午
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class SysFileDTO {

    private Long id;//id
    private Date createTime;// 创建时间
    private Date updateTime;// 更新时间

    private String code;//编号

    //文件 本身属性： 名称/大小/后缀/文件位置/类型
    private String name;// 显示名称
    private String lengthUnit;// 文件大小单位
    private Long length;// 文件大小

    private String suffix;// 后缀
    private String type;// 类型 文件还是图片  一般来说图片是可以直接预览的,

    private String remark;// 描述

    private String path;// 文件本地存放位置--如果是自己的环境应该是服务器的绝对路径

    private String location;// 文件持久化位置，用于 判断拼接url前部分    SERVER / DEVELOP
    private String host;// 文件持久化位置，用于 判断拼接url前部分    SERVER / DEVELOP  或者偷懒直接写 ip
    private String uri;// 文件存放 url=      {host}:{port} +/xxx/yyy/zzz

    private String thumbnailUri;//缩略图 注意仅仅图片应该由此相数据 图片类型有此属性，缩略图地址，其磁盘路径与主图path相似，在文件名称中加入small标识，格式：123_small.png

    private Integer version;// 版本信息id
    private Integer state;// 逻辑删除用的标识

    private String key;// 文件标识
    private String checkType;// 校验方式
    private String checkCode;// 校验码

}
