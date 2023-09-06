package com.arc.core.model.vo;

import com.arc.core.enums.system.ProjectCodeEnum;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.HashMap;

/**
 * 该类对controller返回值做了统一封装
 * 返回数据的数据具有一致的格式
 *
 * @param <T>
 * @author May
 */
@Deprecated
@Getter
@Setter
@ToString
public class ResponseVo2<T> extends ResponseEntity implements Serializable {

    private static final long serialVersionUID = 1L;
    private static final Logger log = LoggerFactory.getLogger(ResponseVo2.class);

    /**
     * 状态信息 status 用String或者数字类型（long/int？）。私以为：类型是数字类型 可能高效一些，
     */
    private int status;

    /**
     * 状态信息
     */
    private String message;

    /**
     * 有效数据
     */
    private T data;
    private LocalDateTime timestamp;
    private String error;
    private String path;

    //    ""timestamp: "2020-01-25T07:41:43.903+0000",
    //    "status": 404,
    //    "error": "Not Found",
    //    "message": "No handler found for GET /zero/sys/resource/scan/auto",
    //    "path": "/zero/sys/resource/scan/auto"


    //构造器
    public ResponseVo2() {
        super(HttpStatus.OK);
    }

    public ResponseVo2(T data) {
        super(HttpStatus.OK);
        this.data = data;
    }

    public ResponseVo2(ProjectCodeEnum projectCode) {
        super(HttpStatus.OK);
        this.status = projectCode.getKey();
        this.message = projectCode.getMessage();
        this.data = null;
    }

    public ResponseVo2(int status, String message, T data) {
        super(HttpStatus.OK);
        this.status = status;
        this.message = message;
        this.data = data;
    }

    //success方法
    public static <T> ResponseVo2<T> success() {
        return new ResponseVo2<T>(ProjectCodeEnum.SUCCESS.getKey(), ProjectCodeEnum.SUCCESS.getMessage(), null);
    }

    public static <T> ResponseVo2<T> success(T data) {
        return new ResponseVo2<T>(ProjectCodeEnum.SUCCESS.getKey(), ProjectCodeEnum.SUCCESS.getMessage(), data);
    }

    public static <T> ResponseVo2<T> success(ProjectCodeEnum enumCode) {
        return new ResponseVo2<T>(enumCode.getKey(), enumCode.getMessage(), null);
    }

    public static <T> ResponseVo2<T> success(ProjectCodeEnum enumCode, T data) {
        return new ResponseVo2<T>(enumCode.getKey(), enumCode.getMessage(), data);
    }

    //失败
    public static <T> ResponseVo2<T> failure(ProjectCodeEnum enumCode) {
        return new ResponseVo2<T>(enumCode.getKey(), enumCode.getMessage(), null);
    }

    public static <T> ResponseVo2<T> failure(T data) {
        return new ResponseVo2<T>(ProjectCodeEnum.FAILURE.getKey(), ProjectCodeEnum.FAILURE.getMessage(), data);
    }

    public static <T> ResponseVo2<T> failure(ProjectCodeEnum enumCode, T data) {
        return new ResponseVo2<T>(enumCode.getKey(), enumCode.getMessage(), data);
    }

    public static ResponseVo2 failure() {
        return new ResponseVo2(ProjectCodeEnum.FAILURE);
    }

    public static ResponseVo2 failure(int status, String message) {
        return new ResponseVo2(status, message, ProjectCodeEnum.FAILURE);
    }

    public static <T> ResponseEntity<ResponseVo2<T>> ok(int i, T data) {
        ResponseVo2 responseVo = new ResponseVo2<>(ProjectCodeEnum.SUCCESS.getKey(), ProjectCodeEnum.SUCCESS.getMessage(), data);
        return ResponseEntity.ok(responseVo);
    }

    public static <T> ResponseEntity okMap(T data) {
        HashMap<String, Object> map = new HashMap<>(16);
        map.put("data", data);
        return ResponseEntity.ok(map);
    }

    /**
     * 系统定义 2XX 都是成功
     * SUCCESS = 200
     *
     * @return true=成功/false=失败
     */
    public boolean isSuccess() {

        return this.status >= 200 && this.status < 500;
    }


}
