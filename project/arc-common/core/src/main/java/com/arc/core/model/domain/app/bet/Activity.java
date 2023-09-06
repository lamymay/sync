package com.arc.core.model.domain.app.bet;

import com.arc.core.model.domain.BaseModel;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author yechao
 * @since 2021/1/25 7:13 下午
 */
@Data
public class Activity extends BaseModel {
    private Long id;// 自增id
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间

}
