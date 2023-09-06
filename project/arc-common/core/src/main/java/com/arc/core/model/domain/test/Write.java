package com.arc.core.model.domain.test;

import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * key-value表(偷懒用)
 * 注意 key是没有做唯一约束的, 要想定位唯一的一个键值对需要加上range
 *
 * @author may
 * @since 2021/04/14
 */
@Getter
@Setter
@ToString
@TableName("test_write")
public class Write implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;// 自增id
    private LocalDateTime createTime;// 创建时间
    private LocalDateTime updateTime;// 更新时间


    /**
     * 自定义值-字符串格式
     */
    private String value;

    public Write() {

    }

    public Write(LocalDateTime createTime, LocalDateTime updateTime, String value) {
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.value = value;
    }

    public Write(String value) {
        this.createTime = LocalDateTime.now();
        this.updateTime = LocalDateTime.now();
        this.value = value;
    }
}
