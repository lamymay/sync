package com.arc.core.model.request.app.contact;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

/**
 * @author 叶超
 * @since 2020/2/28 12:47
 */
@Data
@NoArgsConstructor
public class ContactBatchRequest {

    /**
     * 同步方案 {@link com.arc.core.enums.system.ContactSyncFlagEnum }
     */
    private Integer flag = 0;

    /**
     * /**
     * 是否强制删除
     */
    private boolean force;

    /**
     * 客户端用户身份
     */
    private Client client;

    /**
     * 联系人列表
     */
    private Set<ContactDTO> contacts;


}
