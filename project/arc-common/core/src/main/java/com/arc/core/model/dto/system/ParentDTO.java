package com.arc.core.model.dto.system;

import lombok.Data;

import java.util.Set;

@Data
public class ParentDTO {

    /**
     * 父级id
     * userGroupId
     */
    private Long id;

    /**
     * 子级id
     */
    Set<Long> ids;


    public static void main(String[] args) {
        System.out.println("******* 预期 true *******");

        System.out.println("".contains(""));
        System.out.println(osVersionGreaterThanOrEqualsTwoBit("12.2.3", "12.2"));
        System.out.println(osVersionGreaterThanOrEqualsTwoBit("12.2", "12.2"));
        System.out.println(osVersionGreaterThanOrEqualsTwoBit("16.2", "12 . 2"));
        System.out.println(osVersionGreaterThanOrEqualsTwoBit("16.2", "12"));
        System.out.println(osVersionGreaterThanOrEqualsTwoBit("17", "12"));
        System.out.println(osVersionGreaterThanOrEqualsTwoBit("16", "12. 2"));
        System.out.println(osVersionGreaterThanOrEqualsTwoBit("16", "12.2 .1"));

        System.out.println("******* 预期 false *******");
        System.out.println(osVersionGreaterThanOrEqualsTwoBit(null, null));
        System.out.println(osVersionGreaterThanOrEqualsTwoBit("", ""));
        System.out.println(osVersionGreaterThanOrEqualsTwoBit(null, ""));
        System.out.println(osVersionGreaterThanOrEqualsTwoBit("16", null));

        System.out.println(osVersionGreaterThanOrEqualsTwoBit(null, "12.2"));
        System.out.println(osVersionGreaterThanOrEqualsTwoBit("16.2", null));

    }

    public static boolean osVersionGreaterThanOrEqualsTwoBit(String osVersion, String targetVersion) {
        if (osVersion == null || "".equals(osVersion.trim())) return false;
        if (targetVersion == null || "".equals(targetVersion.trim())) return false;


        String[] versions = osVersion.split("\\.");
        if (versions.length < 1) return false;

        String[] targetVersions = targetVersion.split("\\.");
        if (targetVersions.length < 1) return false;

        return compareVar(getVersionNumberWithTry(versions), getVersionNumberWithTry(targetVersions), 0);

    }

    public static int[] getVersionNumberWithTry(String[] version) {
        if (version != null && version.length > 0) {
            int[] intVarArray = new int[version.length];

            for (int i = 0; i < version.length; i++) {
                intVarArray[i] = getVersionNumberWithTry(version[i]);
            }

            return intVarArray;
        }
        return null;

    }

    public static Integer getVersionNumberWithTry(String version) {
        try {
            return Integer.parseInt(version.trim());
        } catch (Throwable throwable) {
            // 数字转换异常 不需要
            return null;
        }
    }


    public static boolean compareVar(int[] value1, int[] value2, int index) {
        if (value1 == null || value2 == null) return false;
        int var1 = value1[index];
        int var2 = value2[index];
        if (var1 >= var2) {
            compareVar(value1, value2, index - 1);
        }
        return var1 >= var2;
    }


}

