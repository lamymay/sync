package com.arc.utils;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author may
 * @since 2021.10.19 11:00 上午
 */
public class StringUtil {

    private static final Logger log = LoggerFactory.getLogger(StringUtil.class);

    /**
     * 判断字符串是不是以数字开头
     *
     * @param str 字符串
     * @return true=是数字开头
     */
    public static boolean isStartWithNumber(String str) {
        Pattern pattern = Pattern.compile("[0-9]*");
        Matcher isNum = pattern.matcher(str.charAt(0) + "");
        return isNum.matches();
    }

    /**
     * 截短超长字符串，防止insert报错
     *
     * @param content 字符串
     * @return 最大长度为255的字符串
     */
    public static String substringMax255(String content) {
        if (content == null) return "";
        int length = content.length();
        if (length > 255) {
            log.info("字符串将会被截短到255，截取前的长度超为{},content={}", length, content);
            content = content.substring(0, 255);
        }
        return content;
    }

    public static String substringMax(String content, int maxLength) {
        if (content == null) return "";
        int length = content.length();
        if (length > maxLength) {
            log.info("字符串将会被截短到255，截取前的长度超为{},content={}", length, content);
            content = content.substring(0, 255);
        }
        return content;
    }

    public static String getTimeString(long timeMillis) {
        if (timeMillis < 1000) {
            return timeMillis + "ms";
        }

        DecimalFormat df = new DecimalFormat("#.00");

        // 1s 1min
        if (timeMillis < 60000) {
            return df.format(timeMillis / 1000d) + "s";
        } else {
            return df.format(timeMillis / 60000d) + "min";
        }
    }

    public static String getTimeStringSoFar(long timeMillis) {
        return getTimeString(System.currentTimeMillis() - timeMillis);
    }

    public static void showTimeStringSoFar(long timeMillis) {
        System.out.println("耗时=" + StringUtil.getTimeStringSoFar(timeMillis));
    }

    /**
     * int 9999  转为BigDecimal 99.99
     * 不够优雅,如果有好方式欢迎替换
     *
     * @param lockRate 4位整数，例如  9999=99.99  null 0 1= 0.01 10000=100.00
     * @return BigDecimal
     */
    public static BigDecimal covertIntToBigDecimal(Integer lockRate) {
        if (lockRate == null || lockRate == 0) {
            return new BigDecimal("0");
        }
        String rate = String.valueOf(lockRate).replace("-", "");
        int length = rate.length();
        BigDecimal bigDecimal = null;

        // 9999=99.99  null 0 1= 0.01 10000=100.00
        if (lockRate > 0) {
            if (length == 1) {
                bigDecimal = new BigDecimal("0.0" + rate);
            } else if (length == 2) {
                bigDecimal = new BigDecimal("0." + rate);
            } else if (length > 2) {
                rate = rate.substring(0, length - 2) + "." + rate.substring(length - 2, length);
                bigDecimal = new BigDecimal("" + rate);
            }
        } else {
            //负数
            if (length == 1) {
                bigDecimal = new BigDecimal("-0.0" + rate);
            } else if (length == 2) {
                bigDecimal = new BigDecimal("-0." + rate);
            } else if (length > 2) {
                rate = rate.substring(0, length - 2) + "." + rate.substring(length - 2, length);
                bigDecimal = new BigDecimal("-" + rate);
            }
        }
        return bigDecimal;
    }

    public static String stringMap(String origin, Map<String, List<Object>> map) {
        StringBuilder rs = new StringBuilder();
        Random random = new Random();
        for (int i = 0; i < origin.length(); ) {
            int character = origin.codePointAt(i);
            String info = String.valueOf(Character.toChars(character));
            rs.append(Optional.ofNullable(map).map(a -> a.get(info)).filter(tmp -> tmp.size() > 0).map(
                    tmp -> tmp.get(random.nextInt() % tmp.size())
            ).orElse(info));
            if (Character.isSupplementaryCodePoint(character)) {
                i += 2;
            } else {
                i++;
            }
        }
        return rs.toString();
    }

    /**
     * 删除字符最后几个字符，支持中文
     *
     * @param origin 要操作的字符串
     * @param num    删除最后几个字符串
     * @return 删除后的结果
     */
    public static String stringRemoveEndChar(String origin, int num) {
        StringBuilder rs = new StringBuilder();
        List<String> charList = new ArrayList<>();
        for (int i = 0; i < origin.length(); ) {
            int character = origin.codePointAt(i);
            String info = String.valueOf(Character.toChars(character));
            charList.add(info);
            if (Character.isSupplementaryCodePoint(character)) {
                i += 2;
            } else {
                i++;
            }
        }
        if (charList.size() <= num) {
            return "";
        } else {
            List<String> sub = charList.subList(0, charList.size() - num);
            for (String s : sub) {
                rs.append(s);
            }
            return rs.toString();
        }
    }


    private static void write(String context) {

        String fileWriteDir = "";
        File textFile = new File(fileWriteDir + File.separator + "/Users/may/Desktop/ray/say.txt");

        if (!textFile.exists()) {
            try {
                boolean newFile = textFile.createNewFile();
                log.info("newFile={}", newFile);

            } catch (IOException e) {
                log.error("close exception when createNewFile" + textFile.getAbsolutePath(), e);
            }
        }
        FileWriter fileWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileWriter = new FileWriter(textFile, true);
            //使用缓冲区比不使用缓冲区效果更好，因为每趟磁盘操作都比内存操作要花费更多时间。
            //通过BufferedWriter和FileWriter的连接，BufferedWriter可以暂存一堆数据，然后到满时再实际写入磁盘
            //这样就可以减少对磁盘操作的次数。如果想要强制把缓冲区立即写入,只要调用writer.flush();这个方法就可以要求缓冲区马上把内容写下去
            bufferedWriter = new BufferedWriter(fileWriter);
//            bufferedWriter.write("1 this is text content!\n2 Chinese 第二行中文测试 \n3 #！@¥¥@¥ END!");
            bufferedWriter.write(context + "\n");
            bufferedWriter.flush();

        } catch (IOException exception) {
            log.error("写文件异常", exception);
        } finally {
            if (fileWriter != null) {
                try {
                    fileWriter.flush();
                } catch (IOException e) {
                    log.error("close exception", e);
                }
            }
            if (bufferedWriter != null) {
                try {
                    bufferedWriter.close();
                } catch (IOException e) {
                    log.error("close exception", e);

                }
            }
        }
    }


    public static boolean isNull(String value) {
        return value != null && !"".equals(value.trim());
    }


    /**
     * 解析字符串中存在的数字
     *
     * @param content 字符串
     * @return 数字
     */
    public static int getNumbers(String content) {
        Pattern pattern = Pattern.compile("\\d+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return Integer.parseInt(matcher.group(0));
        }
        return 0;
    }

    // 仅unicode编码的字符串转换为普通字符串
    public static String decodeUnicode(String dataStr) {
        int start = 0;
        int end = 0;
        final StringBuffer buffer = new StringBuffer();
        while (start > -1) {
            end = dataStr.indexOf("\\u", start + 2);
            String charStr = "";
            if (end == -1) {
                charStr = dataStr.substring(start + 2);
            } else {
                charStr = dataStr.substring(start + 2, end);
            }
            char letter = (char) Integer.parseInt(charStr, 16); // 16进制parse整形字符串。
            buffer.append(new Character(letter));
            start = end;
        }
        return buffer.toString();
    }

    private static String ascii2native(String asciicode) {
        String[] asciis = asciicode.split("\\\\u");
        String nativeValue = asciis[0];
        try {
            for (int i = 1; i < asciis.length; i++) {
                String code = asciis[i];
                nativeValue += (char) Integer.parseInt(code.substring(0, 4), 16);
                if (code.length() > 4) {
                    nativeValue += code.substring(4);
                }
            }
        } catch (NumberFormatException e) {
            return asciicode;
        }
        return nativeValue;
    }

    public static String getOrderIdByUUId() {
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return String.format("%011d", hashCodeV);
    }

    public static String getGuidByClaim() {
        int hashCodeV = UUID.randomUUID().toString().hashCode();
        if (hashCodeV < 0) {//有可能是负数
            hashCodeV = -hashCodeV;
        }
        // 0 代表前面补充0
        // 4 代表长度为4
        // d 代表参数为正数型
        return String.format("%6d", hashCodeV);
    }

    /**
     * 验证是否保留两位小数
     *
     * @param str
     * @return
     */
    public static boolean verifyTwoDecimal(String str) {
        String regexa = "^-?\\d+(\\.{1}\\d{2}){1}?$";
        Pattern p = Pattern.compile(regexa);
        Matcher m = p.matcher(str.trim());
        boolean dateFlag = m.matches();
        return dateFlag;
    }

    /**
     * 验证是否保留5位小数
     *
     * @param str
     * @return
     */
    public static boolean verifyFiveDecimal(String str) {
        String regexa = "^-?\\d+(\\.{1}\\d{5}){1}?$";
        Pattern p = Pattern.compile(regexa);
        Matcher m = p.matcher(str.trim());
        boolean dateFlag = m.matches();
        return dateFlag;
    }

    /**
     * 验证是否正整数小数
     *
     * @param str
     * @return
     */
    public static boolean verifyPositiveInteger(String str) {
        String regexa = "^[1-9]\\d*|0$";
        Pattern p = Pattern.compile(regexa);
        Matcher m = p.matcher(str.trim());
        boolean dateFlag = m.matches();
        return dateFlag;
    }

    //根据value值获取到对应的一个key值
    public static String getKey(HashMap<String, String> map, String value) {
        String key = null;
        //Map,HashMap并没有实现Iteratable接口.不能用于增强for循环.
        for (String getKey : map.keySet()) {
            if (map.get(getKey).equals(value)) {
                key = getKey;
            }
        }
        return key;
        //这个key肯定是最后一个满足该条件的key.
    }

    //根据value值获取到对应的所有的key值
    public static List<String> getKeyList(HashMap<String, String> map, String value) {
        List<String> keyList = new ArrayList();
        for (String getKey : map.keySet()) {
            if (map.get(getKey).equals(value)) {
                keyList.add(getKey);
            }
        }
        return keyList;
    }

    public static Character getCharByString(String s) {
        Character character;
        char[] chars = s.toCharArray();
        if (chars.length > 1) {
            return chars[0];
        } else {
            character = new Character(chars[0]);
        }
        return character;
    }

    public static double formatDouble(double d) {
        // 旧方法，已经不再推荐使用
        // BigDecimal bg = new BigDecimal(d).setScale(2, BigDecimal.ROUND_HALF_UP);
        // 新方法，如果不需要四舍五入，可以使用RoundingMode.DOWN
        BigDecimal bg = new BigDecimal(d).setScale(2, RoundingMode.UP);
        return bg.doubleValue();
    }

    //兩個double類型相減
    public static Double sub(Double v1, Double v2) {
        DecimalFormat df = new DecimalFormat("######0.00");
        v1 = Double.parseDouble(df.format(v1));
        v2 = Double.parseDouble(df.format(v2));
        BigDecimal bigDecimal = new BigDecimal(v1.toString());
        BigDecimal bigDecima2 = new BigDecimal(v2.toString());
        return bigDecimal.subtract(bigDecima2).doubleValue();
    }

    public static boolean isBlank(String str) {
        if (null != str) {
            return "".equals(str.trim());
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println(isBlank(""));//true
        System.out.println(isBlank("      "));//true
        System.out.println(isBlank(" s     "));//false、

        testStringNumber();
    }

    private static void testStringNumber() {
        System.out.println(getNumbers("A1"));
        System.out.println(getNumbers("123F"));
        System.out.println(getNumbers("负123"));
        System.out.println(getNumbers("12A"));
        System.out.println(getNumbers("   123 "));
        System.out.println(getNumbers("-1"));

    }

    public static void fun1() {
        double d1 = formatDouble(222222.90);
        boolean b2 = verifyPositiveInteger("23456");
        boolean b3 = verifyPositiveInteger("2222");
        boolean b4 = verifyPositiveInteger("0.00005");

        System.out.println(d1);
        System.out.println(b2);
        System.out.println(b3);
        System.out.println(b4);
    }

    public static void getIds(String[] args) {
        List<Integer> ids = new ArrayList<>();
        Integer i = 0;
        while (i < 10) {
            i++;
            System.out.println(i);
            ids.add(i);

        }
        System.out.println(ids.size());
        System.out.println(ids.get(ids.size() - 1));


    }

    /**
     * 截取非数字
     *
     * @param content 字符串
     * @return 去除数字的字符串
     */
    public String splitNotNumber(String content) {
        Pattern pattern = Pattern.compile("\\D+");
        Matcher matcher = pattern.matcher(content);
        while (matcher.find()) {
            return matcher.group(0);
        }
        return "";
    }

    /**
     * 判断一个字符串是否都为数字
     *
     * @param content 字符串
     * @return boolean
     */
    public boolean isDigit(String content) {
        return content.matches("[0-9]{1,}");
    }


}
