package com.arc.core.model.request.app;

import com.arc.core.model.request.ArcPageable;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

@Data
public class PlanVersionRequest extends ArcPageable {

    private static final long serialVersionUID = 1L;

    //本系统中的id是主键
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    //本系统唯一的用户id
    private Long userId;

    /**
     * 有效数据,长度2048
     */
    private String todo;

    private String remark;

    private String profile;
    private Integer state;
}
