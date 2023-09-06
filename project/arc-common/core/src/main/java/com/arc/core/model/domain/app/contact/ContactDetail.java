package com.arc.core.model.domain.app.contact;

import lombok.Data;

import java.time.LocalDateTime;

/**
 * @author 叶超
 * @since 2020/2/27 10:46
 */
@Data
//@Entity
//@Table(name = "app_contact_detail")
public class ContactDetail {


    /**
     * 主键id,本系统中的id是主键
     */
//    @javax.persistence.Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    @Column(name = "id")
    private Long id;

    /**
     * 创建时间
     */
//    @Column(name = "create_time")
    private LocalDateTime createTime;

    /**
     * 更新时间
     */
//    @Column(name = "update_time")
    private LocalDateTime updateTime;

    //contact表的id
//    @Column(name = "contact_id")
    private Long contactId;

    //值=phone/email
//    @Column(name = "value")
    private String value;

    //类型
//    @Column(name = "type")
    private String type;


    //别名
//    @Column(name = "alias")
    private String alias;

}
