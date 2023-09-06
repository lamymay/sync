package com.arc.core.model.domain.app.chat;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 消息-write
 *
 * @author ray
 * @since 2023/08/18
 */
@Getter
@Setter
@ToString
@TableName("app_chat_message")
public class Message implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 发信人id
     */
    @TableField(value = "`form`")
    private Long form;

    /**
     * 收信人id
     */
    @TableField(value = "`to`")
    private Long to;

    /**
     * 消息id
     */
    private Long message_id;

    /**
     * 群id
     */
    private Long room_id;

    /**
     * 消息「已发」，消息由发信者传送至server
     * 消息「已达」，消息由server传送至收信者， 用于调试中定位消息状态：发信者网络异常情况下用于标识消息是否确认已达server
     * 消息「已读」，目标收信者已读到消息，对server更新更新写消息状态，server主动ack发信者，完成完整消息传送，【终态】
     * <p>
     * server_ack_form
     * to_ack_server
     * to_ack_form
     */
    private short ack;

    // message

    /**
     * 消息类型：
     * 方案一 细化消息类型： txt=文本/image=图片/pdf=pdf/doc=文档/xls=Excel文档/mp3=mp3音乐/wav=文件
     * 方案二 简单分类： 1=text=文本/2=file=文档/3=audio=音频/4=video=视频
     */
    private byte message_type;

    /**
     * for debug 调试开发中用的
     */
    private String message;

    /**
     * 数据本身转化为二进制,第一版使用明文非压缩的二进制，后续考虑加密压缩
     */
    private byte[] message_binary;

    /**
     * 二进制数据长度
     */
    private long length;

    /**
     * 单条数据如过大则切分，切分计数器
     */
    private int shard_count;

    /**
     * 数据分片编号
     */
    private long shard_serial_number;

    // time

    /**
     * 发信者创建消息的时刻
     */
    private Long create_time;

    /**
     * 服务端接受处理成功时刻
     */
    private Long server_accept_time;

    /**
     * 第一个客户端获取到时刻
     */
    private Long client_accept_time;
}
