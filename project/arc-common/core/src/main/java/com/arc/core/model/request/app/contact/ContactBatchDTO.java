package com.arc.core.model.request.app.contact;

import com.arc.core.util.JSON;
import lombok.Getter;
import lombok.Setter;

import java.util.Set;

/**
 * 响应用
 *
 * @author 叶超
 * @since 2020/2/28 12:47
 */
@Setter
@Getter
public class ContactBatchDTO {

    /**
     * 同步的结果
     */
    private boolean success;
    private String code;
    private String message;

    /**
     * 同步方案
     */
    private Integer flag;

    private Integer rows;

    private long cost;

    private long serverTime;

    /**
     * 客户端用户身份
     */
    private Client client;

    /**
     * 最终联系人列表
     */
    private Set<ContactDTO> contacts;

    public ContactBatchDTO() {
    }

    public ContactBatchDTO(String message) {
        this.message = message;
    }

    public ContactBatchDTO(ContactBatchRequest config, boolean success, int rows) {
        this.success = success;
        this.rows = rows;
        if (config != null) {
            this.flag = config.getFlag();
            this.client = config.getClient();
            this.contacts = config.getContacts();
        }

    }


    public ContactBatchDTO(ContactBatchRequest config, boolean success, String message) {
        this.success = success;
        this.message = message;
        if (config != null) {
            this.flag = config.getFlag();
            this.client = config.getClient();
            this.contacts = config.getContacts();
            this.rows = config.getContacts() == null ? 0 : config.getContacts().size();

        }
    }

    @Override
    public String
    toString() {
        return JSON.toJSONString(this);
    }
}
