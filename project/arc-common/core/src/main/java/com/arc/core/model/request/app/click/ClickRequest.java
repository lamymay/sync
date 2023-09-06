package com.arc.core.model.request.app.click;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.time.LocalDateTime;

/**
 * 打卡相关的模型
 * 记录打卡者 时间\地点\身份\平台\组织
 *
 * @author yechao
 * @since 2021/4/2 13:43
 */
@Data
public class ClickRequest implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 自增id
     */
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 更新时间
     */
    private LocalDateTime updateTime;

    /**
     * 创建时间
     */
    private LocalDateTime createTime;


    /**
     * 状态(0(false)：正常 1:暂停)
     */
    private Integer state;

    /**
     * 备注
     */
    private String remark;

    /**
     * 打卡时间
     */
    private LocalDateTime checkInTime;

    /**
     * 年月日格式: 20210426
     */
    private Integer checkInDay;


    /**
     * 用户id
     */
    private Long userId;

    /**
     * ip地址
     * IP地址是一个32位的二进制地址，
     * 为了便于记忆，将它们分为4组，每组8位，由小数点分开，用四个字节来表示，而且，用点分开的每个字节的数值范围是0~255，
     * 如202.116.0.1 从数值范围可以判断最大值为255。
     */
    private String ip;

    /**
     * 纬度
     * 表示经纬度有多样模式，以下是其中一些例子。
     * 度分秒表示（度:分:秒）－49°30'00"-49d30m00s
     * 度分表示（度:分）－49°30.0'-49d30.0m
     * 度数表示－49.5000°-49.5000d（一般会有四位小数）。
     */
    private BigDecimal latitude;


    /**
     * 经度
     */
    private BigDecimal longitude;

    /**
     * 地点
     */
    private String location;

    /**
     * 设备
     */
    private String device;

    /**
     * 系统
     */
    private String system;

    /**
     * 组织id
     */
    private Integer organizationId;

    /**
     * 考情方案
     */
    private Integer attendanceSolution;
    private Integer start;
    private Integer pageSize;

    /**
     * 将数字转成ip地址
     *
     * @param ipNumber 数字
     * @return 转换后的ip地址
     */
    public static String convertIpToString(long ipNumber) {
        long[] mask = {0x000000FF, 0x0000FF00, 0x00FF0000, 0xFF000000};
        long num;
        StringBuffer ipInfo = new StringBuffer();
        for (int i = 0; i < 4; i++) {
            num = (ipNumber & mask[i]) >> (i * 8);
            if (i > 0) {
                ipInfo.insert(0, ".");
            }
            ipInfo.insert(0, Long.toString(num, 10));
        }
        return ipInfo.toString();
    }

    /**
     * 将ip 地址转换成数字
     *
     * @param ipAddress 传入的ip地址
     * @return 转换成数字类型的ip地址
     */
    public static int convertIpToLong(String ipAddress) {
        String[] ip = ipAddress.split("\\.");
        int a = Integer.parseInt(ip[0]);
        int b = Integer.parseInt(ip[1]);
        int c = Integer.parseInt(ip[2]);
        int d = Integer.parseInt(ip[3]);

        return a * 256 * 256 * 256 + b * 256 * 256 + c * 256 + d;

    }

    public static void main(String[] args) {
        Integer longIp = convertIpToLong("127.0.0.1");
        System.out.println(longIp);
        System.out.println(("" + longIp).length());
        System.out.println(("" + Integer.MAX_VALUE).length());
    }

}
