package com.arc.core.model.request.app.contact;

import com.arc.core.constant.NormalConstants;
import com.arc.core.model.request.ArcPageable;
import lombok.Data;

@Data
public class ContactPageable extends ArcPageable {

    private int pageNumber = NormalConstants.PAGE_NUMBER_FIRST;

    private int pageSize = NormalConstants.PAGE_SIZE20;

    private Long userId;

    /**
     * 客户端id
     * app在不同设备上对应挂在不同人的账户下
     */
    private String clientId;

    public ContactPageable() {
    }

    public ContactPageable(int pageNumber, int pageSize, Long userId) {
        this.pageNumber = pageNumber;
        this.pageSize = pageSize;
        this.userId = userId;
    }
}
