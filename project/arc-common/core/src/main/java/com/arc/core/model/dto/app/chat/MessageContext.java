package com.arc.core.model.dto.app.chat;

import com.arc.core.model.domain.app.chat.Message;
import org.springframework.beans.BeanUtils;

/**
 * 聊天上下文用数据封装
 */
public class MessageContext extends MessageDTO {


    public MessageContext() {
    }

    public MessageContext(Message message) {
        MessageContext messageContext = new MessageContext();
        BeanUtils.copyProperties(message, messageContext);
    }
}
