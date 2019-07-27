package com.mrliu.www.enums;

/**
 * @author liuyangos8888
 */

public enum SeasonEnum {

    /**
     * 第一季度
     */
    FirstQuarter(1, "第一季度"),

    /**
     * 第二季度
     */
    SecondQuarter(2, "第二季度"),

    /**
     * 第三季度
     */
    ThirdQuarter(3, "第三季度"),

    /**
     * 第四季度
     */
    FourthQuarter(4, "第四季度");


    /**
     * 季度名称
     */
    private String sessionName;

    /**
     * 季度数字
     */
    private int number;

    SeasonEnum(int number, String sessionName) {
        this.number = number;
        this.sessionName = sessionName;
    }


    public String sessionName() {
        return sessionName;
    }

    public int number() {
        return number;
    }


    public static SeasonEnum valueOf(int number) {
        for (SeasonEnum numberEnum : SeasonEnum.values()) {
            if (numberEnum.number == number) {
                return numberEnum;
            }
        }
        return null;
    }
}
