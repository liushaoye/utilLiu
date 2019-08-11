package com.mrliu.www.enums;

/**
 * 季度枚举
 *
 * @author liuyangos8888
 */

public enum Quarter {

    /**
     * 第一季度
     */
    FIRST(1, "第一季度"),


    /**
     * 第二季度
     */
    SECOND(2, "第二季度"),

    /**
     * 第三季度
     */
    THIRD(3, "第三季度"),

    /**
     * 第四季度
     */
    FOURTH(4, "第四季度");


    Quarter(int quarterCode, String quarterName) {
        this.quarterCode = quarterCode;
        this.quarterName = quarterName;
    }

    /**
     * 季度数
     */
    private int quarterCode;

    /**
     * 季度名称
     */
    private String quarterName;


    public int getQuarterCode() {
        return quarterCode;
    }

    public void setQuarterCode(int quarterCode) {
        this.quarterCode = quarterCode;
    }

    public String getQuarterName() {
        return quarterName;
    }

    public void setQuarterName(String quarterName) {
        this.quarterName = quarterName;
    }
}
