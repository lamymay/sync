package com.arc.core.model.vo;

import com.arc.core.enums.system.ProjectCodeEnum;
import com.arc.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;

@Slf4j
public class ResponseVo3 extends ResponseVo2 {


    private static <T> T copyProperties(ResponseVo2<?> response, Class<T> target) {

        try {
            Object targetBean = Class.forName(target.getName()).getDeclaredConstructor().newInstance();
            BeanUtils.copyProperties(response.getData(), targetBean);
            log.info("instance={}", targetBean);
            return (T) targetBean;
        } catch (Exception exception) {
            log.error("error when object copyProperties");
            return null;
        }
    }


    /**
     * 处理微服务的返回结果（类型转换）
     *
     * @param response response
     * @param target   target Class
     * @param <T>
     * @return ResponseVo2
     */
    public static <T> ResponseVo2<T> convertResponse(ResponseVo2<?> response, Class<T> target) {
        if (response == null || target == null) throw new BizException(ProjectCodeEnum.NULL_RESPONSE);

        return response.isSuccess() ? ResponseVo2.success(copyProperties(response, target)) : ResponseVo2.failure(response.getStatus(), response.getMessage());
    }


    // 列表类型转换
//    public static <T> ResponseVo2<List<T>> convertListResponse(ResponseVo2<? extends List> response, Class<T> target) {
//        if (response == null || target == null) throw new BizException(ProjectCodeEnum.NULL_RESPONSE);
//        return response.isSuccess() ? ResponseVo2.success(copyList(response.getData(), target)) : ResponseVo2.failure(response.getStatus(), response.getMessage());
//    }
//

    // 分页类型转换
//    public static <T> ResponseVo<PageResponse<T>> convertPageResponse(MicroServiceResponse<? extends PageResponse> response, Class<T> target) {
//        if (response == null || target == null) {
//            throw new BusinessRuntimeException(ProjectCodeEnum.NULL_RESPONSE);
//        }
//        if (response.getData() == null) {
//            throw new BusinessRuntimeException(ProjectCodeEnum.PAGE_NULL_RESPONSE);
//        }
//        List<T> list = BeanCopierUtil.copyList(response.getData().getData(), target);
//        PageResponse<T> instance = new PageResponse<>();
//        instance.setData(list);
//        instance.setTotalPages(response.getData().getTotalPages());
//        instance.setTotalElements(response.getData().getTotalElements());
//        return StringUtils.equals(response.getCode(), ProjectCodeEnum.SUCCESS.getCode()) ? ResponseVo.success(instance) : ResponseVo.failure(ProjectCodeEnum.buildFailure(response.getCode(), response.getMsg()));
//    }

//    含参数名映射列表类型转换
//    public static <T> ResponseVo<List<T>> convertListResponse(MicroServiceResponse<? extends List> response, Class<T> target, Map<String, String> relation) {
//        if (response == null || target == null) {
//            throw new BusinessRuntimeException(ProjectCodeEnum.NULL_RESPONSE);
//        }
//        List<T> instance = BeanCopierUtil.copyList(response.getData(), target, relation);
//        return StringUtils.equals(response.getCode(), ProjectCodeEnum.SUCCESS.getCode()) ? ResponseVo.success(instance) : ResponseVo.failure(ProjectCodeEnum.buildFailure(response.getCode(), response.getMsg()));
//    }

}
