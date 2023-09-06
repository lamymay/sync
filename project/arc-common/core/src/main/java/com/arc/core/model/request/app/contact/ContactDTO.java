package com.arc.core.model.request.app.contact;


import com.arc.core.model.domain.app.contact.Contact;
import com.arc.core.util.JSON;
import com.fasterxml.jackson.core.type.TypeReference;
import lombok.Data;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.*;

/**
 * 用户手机通讯录数据模型设计：
 * 用户实体
 * <p>
 * <p>
 * 设计目标：
 * 1 服务端支持多用户多设备之间的同步
 * <p>
 * <p>
 * 手机通讯录数据模型特点：
 * 1 一个账号同时可以拥有多设备,设备1上有通讯录1,在设备2上有一份通讯录2,则同步时候需要区分的不是通讯录1、2 而是通讯录中的联系人
 * 2 每个设备上的通讯录id各自独立。所以客户端的通讯录中联系人id是无意义的，只有服务端端的联系人id是有意义的
 * 3 一个联系人可以有多个手机号码
 * 4 联系人之间手机号码支持重复(用户在录入时候可能出错，对于录入错误的系统无法推断手机号归属誰，于是直接原样存储，但是可以提示用户有脏数据)
 *
 * <p>
 * <p>
 * 关键:
 * 判断一个账号通讯录中的联系人是否是相同方法是： 账号+联系人名称, 解释,
 *
 * @author yechao
 * @since 2022.01.24 1:23 下午
 */
@Data//注解是使用插件 Lombok,  java bean 可以省略手动写getter setter
public class ContactDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;//后台统中的id是主键
    private Integer status;// 0=逻辑删除

    private LocalDateTime createTime;//创建时间
    private LocalDateTime updateTime;//更新时间

    private String deviceContactId;//是每个通讯录中的id，不唯一，每个设备上的通讯录id各自独立
    private Long userId;//本系统唯一的用户id

    private String familyName = "";//英文中的人名姓氏 lastName/family name
    private String givenName = "";//名字 = given name / firstName
    private String name = familyName + givenName;//完整用户姓名 中文习惯姓在前名在后则名= familyName + givenName
//    @Deprecated private String displayName;// 昵称

    private String organization;
    private String postalAddress;
    private String groupMembership;//group_membership

    private String photo;
    private String remark;

    private String website;
    private String birthday;


    private Set<String> phones = new HashSet<>(); //电话号码集合
    private Set<String> emails = new HashSet<>();
    private Set<String> ims = new HashSet<>();

    private Set<String> addresses = new HashSet<>();
    private Set<String> notes = new HashSet<>();

    private Map<String, Object> extend;// 预留 jsonString


    private Client client;//客户端 用户身份数据

    ///

    public ContactDTO() {
    }

    public ContactDTO(String name, String phone) {
        this.name = name;
        Set<String> phoneSet = new TreeSet<>();
        phoneSet.add(phone);
        this.phones = phoneSet;
    }

    public ContactDTO(String familyName, String givenName, Set<String> phones, Set<String> emails) {
        this.givenName = givenName;
        this.familyName = familyName;
        this.phones = phones;
        this.emails = emails;

        this.name = this.familyName + this.givenName;

    }

    public ContactDTO(Contact source) {
        if (source != null) {
            this.id = source.getId();
            this.familyName = source.getFamilyName();
            this.givenName = source.getGivenName();
            this.name = source.getName();
            this.phones = source.getPhones() == null ? null : JSON.parseObject(source.getPhones(), new TypeReference<TreeSet<String>>() {
            });
            this.emails = source.getEmails() == null ? null : JSON.parseObject(source.getEmails(), new TypeReference<TreeSet<String>>() {
            });
            this.ims = source.getIms() == null ? null : JSON.parseObject(source.getIms(), new TypeReference<TreeSet<String>>() {
            });
            this.photo = source.getPhoto();
            this.organization = source.getOrganization();
            this.postalAddress = source.getPostalAddress();
            this.groupMembership = source.getGroupMembership();
//            this.createTime = source.getCreateTime();
//            this.updateTime = source.getUpdateTime();
            this.status = source.getStatus();
            this.extend = source.getExtend() == null ? null : JSON.parseObject(source.getExtend(), new TypeReference<>() {
            });
            this.remark = source.getRemark();
            this.client = new Client(source.getUserId());
        }
    }

    public ContactDTO(Long id, String familyName, String givenName, String name, Set<String> phones, Set<String> emails, Set<String> ims, String photo, String organization, String postalAddress, String groupMembership, LocalDateTime createTime, LocalDateTime updateTime, Integer status, String remark, Map<String, Object> extend, Client client) {
        this.id = id;
        this.familyName = familyName;
        this.givenName = givenName;
        this.name = name;
        this.phones = phones;
        this.emails = emails;
        this.ims = ims;
        this.photo = photo;
        this.organization = organization;
        this.postalAddress = postalAddress;
        this.groupMembership = groupMembership;
        this.createTime = createTime;
        this.updateTime = updateTime;
        this.status = status;
        this.remark = remark;
        this.extend = extend;
        this.client = client;
    }

    public void appendPhone(String phoneNumber) {
        Set<String> existPhones = this.phones;
        if (existPhones == null) {
            existPhones = new HashSet<>();
        }
        existPhones.add(phoneNumber);
        this.phones = existPhones;
    }
}
