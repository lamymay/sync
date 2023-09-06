package com.arc.core.util;

import com.arc.core.model.domain.app.contact.Contact;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.core.JsonFactory;
import com.fasterxml.jackson.core.JsonGenerator;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.*;

/**
 * 对于JSON封装一层
 *
 * @author may
 * @since 5.7.21 4:04 下午
 */
public class JSON {

    public static final ObjectMapper defaultObjectMapper = new ObjectMapper();

    public static final ObjectMapper objectMapperV2 = new ObjectMapper();
    private static final Logger log = LoggerFactory.getLogger(JSON.class);

    static {

        // 对象的所有字段全部列入，还是其他的选项，可以忽略null等
        objectMapperV2.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        // 忽略空Bean转json的错误
        objectMapperV2.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 忽略未知属性，防止json字符串中存在，java对象中不存在对应属性的情况出现错误
        objectMapperV2.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        // 忽略空Bean转json的错误
        defaultObjectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        // 忽略未知属性，防止json字符串中存在，java对象中不存在对应属性的情况出现错误
        defaultObjectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);


        objectMapperV2.setSerializationInclusion(JsonInclude.Include.NON_NULL);
//        objectMapperV2.setDateFormat(new SimpleDateFormat("yyyy-MM-dd HH:mm:ss"));
//        objectMapperV2.configure(SerializationConfig.Feature.INDENT_OUTPUT, true);
//        objectMapperV2.configure(SerializationConfig.Feature.FAIL_ON_EMPTY_BEANS, false);
//        objectMapperV2.configure(DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
//        objectMapperV2.configure(DeserializationConfig.Feature.FAIL_ON_NULL_FOR_PRIMITIVES, false);
//        objectMapperV2.configure(DeserializationConfig.Feature.FAIL_ON_NUMBERS_FOR_ENUMS, false);
//        objectMapperV2.configure(DeserializationConfig.Feature.ACCEPT_SINGLE_VALUE_AS_ARRAY, true);
//        objectMapperV2.configure(DeserializationConfig.Feature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT, true);
//        objectMapperV2.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
    }

    /**
     * 对象转JSON字符串
     *
     * @param object object
     * @return JSONString
     */
    public static String toJSONString(Object object) {
        try {
            return defaultObjectMapper.writeValueAsString(object);
        } catch (JsonProcessingException e) {
            log.error("defaultObjectMapper.writeValueAsString{}", object, e);
            return null;
        }
    }


    /**
     * 对象转JSON字符串，序列化时候忽略键值对是null的
     *
     * @param object          object
     * @param ignoreNullValue 对象转JSONString时候是否忽略value是null的键值对
     * @return JSONString
     */
    public static String toJSONString(Object object, boolean ignoreNullValue) {
        try {
            if (ignoreNullValue) {
                return objectMapperV2.writeValueAsString(object);
            } else {
                return defaultObjectMapper.writeValueAsString(object);
            }
        } catch (JsonProcessingException e) {
            log.error("defaultObjectMapper.writeValueAsString{}", object, e);
            return null;
        }
    }

    public static <T> T parseObject(String jsonString, TypeReference<T> valueType) {
        if (jsonString == null || "".equals(jsonString.trim())) {
            return null;
        }
        try {
            return defaultObjectMapper.readValue(jsonString, valueType);
        } catch (Exception ex) {
            log.error("JSONString({}) 转到对象异常", jsonString, ex);
            return null;
        }
    }

    public static <T> T parseObject(String jsonString, Class<T> valueType) {
        if (jsonString == null || "".equals(jsonString.trim())) {
            return null;
        }
        try {
            return defaultObjectMapper.readValue(jsonString, valueType);
        } catch (Exception ex) {
            log.error("JSONString({}) 转到对象({})异常", jsonString, valueType, ex);
            return null;
        }
    }


//    /**
//     * 格式化Json字符串
//     *
//     * @param jsonStr jsonStr
//     * @return String
//     */
//    public static String formatJSON(String jsonStr) {
//        if (null == jsonStr || "".equals(jsonStr)) return "";
//
//        StringBuilder sb = new StringBuilder();
//
//        char last;
//        char current = '\0';
//        int indent = 0;
//        for (int i = 0; i < jsonStr.length(); i++) {
//            last = current;
//            current = jsonStr.charAt(i);
//            switch (current) {
//                case '{':
//                case '[':
//                    sb.append(current);
//                    sb.append('\n');
//                    indent++;
//                    addIndentBlank(sb, indent);
//                    break;
//                case '}':
//                case ']':
//                    sb.append('\n');
//                    indent--;
//                    addIndentBlank(sb, indent);
//                    sb.append(current);
//                    break;
//                case ',':
//                    sb.append(current);
//                    if (last != '\\') {
//                        sb.append('\n');
//                        addIndentBlank(sb, indent);
//                    }
//                    break;
//                default:
//                    sb.append(current);
//            }
//        }
//        return sb.toString();
//    }

    public static String formatJSON(String content) {
        String formattedJson = null;
        try {

            // 创建 ObjectMapper 对象

            // 将 JSON 字符串转换为 Java 对象
            Object jsonObject = defaultObjectMapper.readValue(content, Object.class);

            // 创建 JsonGenerator 对象
            JsonFactory jsonFactory = new JsonFactory();
            StringWriter stringWriter = new StringWriter();
            JsonGenerator jsonGenerator = jsonFactory.createGenerator(stringWriter);

            // 设置缩进格式
            jsonGenerator.useDefaultPrettyPrinter();

            // 将 Java 对象格式化输出到 StringWriter
            defaultObjectMapper.writeValue(jsonGenerator, jsonObject);

            // 获取格式化后的 JSON 字符串
            formattedJson = stringWriter.toString();

            // 关闭 JsonGenerator
            jsonGenerator.close();

        } catch (Exception exception) {
            log.error("", exception);
        }
        return formattedJson;

    }

    private static void addIndentBlank(StringBuilder sb, int indent) {
        for (int i = 0; i < indent; i++) {
            sb.append('\t');
        }
    }

    public static void main(String[] args) throws  Exception {

//        Map<String, String> map = new HashMap<>();
//        Map<String, Object> kid = new HashMap<>();
//        map.put("displayName", "MAY");
//        kid.put("enableDebug", true);
//        kid.put("enablePrint", true);
//        System.out.println(toJSONString(map));
//        System.out.println(formatJSON(toJSONString(map)));


//        Contact contact = new Contact();
//        contact.setName("zhang");
//        contact.setEmails("2320@qq.com");
//        String jsonString = JSON.toJSONString(contact);
//
//        Contact contact1 = JSON.parseObject(jsonString, Contact.class);
//        System.out.println(contact1);
//
//
//        writeObj();
//        readObj();
        Contact contact = new Contact();
        contact.setName("zhang");
        contact.setEmails("2320@qq.com");

        System.out.println(contact.clone());
        System.out.println(contact.clone());
        System.out.println(contact.clone());
        System.out.println(contact.clone());
        System.out.println(contact.clone());


//        final ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
//        String jsonString = objectMapper.writeValueAsString(map);
//        System.out.println("jsonString=\n" + jsonString);
//        Class<?> collectionClass = TreeMap.class;
//        Class<?> parametersFor = String.class;
//        Class<?> elementClasses = String.class;
//        JavaType javaType = objectMapper.getTypeFactory().constructParametrizedType(collectionClass, parametersFor, elementClasses);
//        System.out.println("javaType=\n" + javaType);


    }

    public static void writeObj() {
        Contact contact = new Contact();
        contact.setName("zhang");
        contact.setEmails("2320@qq.com");

        try {
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("./contact.txt"));
            objectOutputStream.writeObject(contact);
            objectOutputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * 将类从文本中提取并赋值给内存中的类
     */
    public static void readObj() {
        try {
            ObjectInputStream objectInputStream = new ObjectInputStream(new FileInputStream("./contact.txt"));
            try {
                Object object = objectInputStream.readObject();
                Contact contact = (Contact) object;
                System.out.println(contact);
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
