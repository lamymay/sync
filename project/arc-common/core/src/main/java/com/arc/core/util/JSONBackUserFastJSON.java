//package com.arc.core.util;
//
///**
// * 对于JSON封装一层
// *
// * @author may
// * @since 5.7.21 4:04 下午
// */
//@Deprecated
//public class JSONBackUserFastJSON {
//
//
//    public static String toJSONString(Object object) {
//        try {
//            if (object == null) return "null";
//            return com.alibaba.fastjson.JSON.toJSONString(object);
//        } catch (Exception exception) {
//            exception.printStackTrace();
//            return object.toString();
//        }
//    }
//
//    public static <T> T phaseObject(String jsonString, Class<T> valueType) {
//        return com.alibaba.fastjson.JSON.parseObject(jsonString, valueType);
//    }
//
//
//}
