package com.arc.core.model.domain.app.contact;

import com.arc.core.constant.NormalConstants;
import com.arc.core.model.request.app.contact.ContactDTO;
import com.arc.core.util.JSON;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author 叶超
 * @since 2020/2/27 10:46
 */
@Data
@TableName("app_contact")
public class Contact implements Serializable,Cloneable {


    /**
     * 主键id,本系统中的id是主键
     */
    //    @javax.persistence.Id  @GeneratedValue(strategy = GenerationType.IDENTITY)   @Column(name = "id")
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;//后台统中的id是主键
    private Integer status;// 0=逻辑删除
    private String deviceContactId;//是每个通讯录中的id，不唯一，每个设备上的通讯录id各自独立 device_contact_id

    private Long userId;//本系统唯一的用户id

    private String familyName = "";//英文中的人名姓氏 lastName/family name
    private String givenName = "";//名字 = given name / firstName
    private String name = familyName + givenName;//完整用户姓名 中文习惯姓在前名在后则名= familyName + givenName

    private String phones; //电话号码集合
    private String emails;
    private String ims;

    private String addresses;
    private String groupMembership;//group_membership

    private String photo;// BASE64
    private String remark;
//    private String birthday;

    private Date createTime;//创建时间
    private Date updateTime;//更新时间
    private String extend;// 预留 jsonString

    private String organization;
    private String postalAddress;

//    private String website;
//    @Deprecated private String displayName;// 昵称

    public Contact() {
        System.out.println("无参构造器");
    }

    public Contact(ContactDTO source) {
        System.out.println("有参ContactDTO构造器");

        if (source != null) {
            this.id = source.getId();
            this.createTime = new Date();
            this.updateTime = this.createTime;
//            this.createTime = source.getCreateTime() == null ? new Date() : new Date(source.getCreateTime().getLong(TemporalField.));
//            this.updateTime = source.getUpdateTime() == null ? new Date() : source.getUpdateTime();
            this.userId = source.getClient() != null ? source.getClient().getUserId() : null;
            this.familyName = source.getFamilyName();
            this.givenName = source.getGivenName();
            this.name = source.getName();
            this.phones = source.getPhones() == null ? "{}" : JSON.toJSONString(source.getPhones());
            this.emails = source.getEmails() == null ? "{}" : JSON.toJSONString(source.getEmails());
            this.ims = source.getIms() == null ? "{}" : JSON.toJSONString(source.getIms());
            this.organization = source.getOrganization();
            this.postalAddress = source.getPostalAddress();
            this.groupMembership = source.getGroupMembership();
            this.photo = source.getPhoto();
            this.status = source.getStatus() == null ? NormalConstants.STATUS_NOT_DELETE : source.getStatus();
            this.remark = source.getRemark();
            this.extend = source.getExtend() == null ? "{}" : JSON.toJSONString(source.getExtend());
        }
    }

//    public Contact(Long id, LocalDateTime createTime, LocalDateTime updateTime, Long userId, String familyName, String givenName, String phone, String email, String im, String organization, String postalAddress, String groupMembership, String photo, Integer status, String remark, String extend) {
//        this.id = id;
//        this.createTime = createTime;
//        this.updateTime = updateTime;
//        this.userId = userId;
//        this.familyName = familyName;
//        this.givenName = givenName;
//        this.name = familyName + givenName;
//        this.phones = phone;
//        this.emails = email;
//        this.ims = im;
//        this.organization = organization;
//        this.postalAddress = postalAddress;
//        this.groupMembership = groupMembership;
//        this.photo = photo;
//        this.status = status;
//        this.remark = remark;
//        this.extend = extend;
//    }

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}
