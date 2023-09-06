package com.arc.core.model.request.mall;

import lombok.Getter;
import lombok.Setter;

import java.util.Date;

/**
 * @author Z
 */
@Getter
@Setter
public class MallQuestion {


    private Long id;// 主键ID
    private Long mallId;//mall的id，做关联
    private String question;// 名称
    private String answer;// 答案
    private String reason;// 依据
    private String remark;// 备注
    private Date createDate;// 创建时间
    private Date updateDate;// 更新时间
}
