package com.arc.core.model.vo;

import com.arc.core.enums.system.ProjectCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * 该类对controller返回值做了统一封装
 * 返回数据的数据具有一致的格式
 *
 * @param <T>
 * @author May
 */
@Getter
@Setter
@ToString
@Deprecated
public class ResponseVo<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 状态信息 code 用String或者数字类型（long/int？）。私以为：类型是数字类型 可能高效一些，
     */
    private int code;

    /**
     * 状态信息
     */
    private String msg;


    /**
     * 有效数据
     */
    private T data;

    //构造器
    public ResponseVo() {
    }

    public ResponseVo(T data) {
        this.data = data;
    }

    public ResponseVo(ProjectCodeEnum projectCode) {
        this.code = projectCode.getKey();
        this.msg = projectCode.getMessage();
        this.data = null;
    }

    public ResponseVo(int code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    //success方法
    public static <T> ResponseVo<T> success() {
        return new ResponseVo<T>(ProjectCodeEnum.SUCCESS.getKey(), ProjectCodeEnum.SUCCESS.getMessage(), null);
    }

    public static <T> ResponseVo<T> success(T data) {
        return new ResponseVo<T>(ProjectCodeEnum.SUCCESS.getKey(), ProjectCodeEnum.SUCCESS.getMessage(), data);
    }

    public static <T> ResponseVo<T> success(ProjectCodeEnum enumCode) {
        return new ResponseVo<T>(enumCode.getKey(), enumCode.getMessage(), null);
    }

    public static <T> ResponseVo<T> success(ProjectCodeEnum enumCode, T data) {
        return new ResponseVo<T>(enumCode.getKey(), enumCode.getMessage(), data);
    }

    //失败
    public static <T> ResponseVo<T> failure(ProjectCodeEnum enumCode) {
        return new ResponseVo<T>(enumCode.getKey(), enumCode.getMessage(), null);
    }

    public static <T> ResponseVo<T> failure(T data) {
        return new ResponseVo<T>(ProjectCodeEnum.FAILURE.getKey(), ProjectCodeEnum.FAILURE.getMessage(), data);
    }

    public static <T> ResponseVo<T> failure(ProjectCodeEnum enumCode, T data) {
        return new ResponseVo<T>(enumCode.getKey(), enumCode.getMessage(), data);
    }

    public static ResponseVo failure() {
        return new ResponseVo(ProjectCodeEnum.FAILURE);
    }

    public static ResponseVo failure(int code, String msg) {
        return new ResponseVo(code, msg, ProjectCodeEnum.FAILURE);
    }

}
