package com.arc.core.model.request.system.menu;

import com.arc.core.model.request.ArcPageable;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class SysMenuRequest extends ArcPageable {

    private static final long serialVersionUID = 1L;

    //mybatisplus 自增id很大,改进：使用数据库自带的增长策略 @TableId(value = "id", type = IdType.AUTO)

    private Long id;// 主键id
    private Long parentId;// 父级id
    private String code;// 编码（备用）

    private String name;// 名中文称
    private String nameEnglish;// 英文名称 （备用）
    //private int sort;// 排序用权重（数字小的在前面）
    private int level;// 级别，1=第一级，2=第二级，，，
    private int state;// 状态，暂时规划true=非0/false=0
    private String url;// 菜单URL地址
    private String icon;// icon地址
    private String remark;// 备注
    private Long systemId;// 适用系统的id

}
