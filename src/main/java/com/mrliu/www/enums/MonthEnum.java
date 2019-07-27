package com.mrliu.www.enums;

/**
 * @author liuyangos8888
 */

public enum MonthEnum {


    /**
     * 一月
     */
    January("一月", 1),

    /**
     * 二月
     */
    February("二月", 2),

    /**
     * 三月
     */
    March("三月", 3),

    /**
     * 四月
     */
    April("四月", 4),

    /**
     * 五月
     */
    May("五月", 5),

    /**
     * 六月
     */
    June("六月", 6),

    /**
     * 七月
     */
    July("七月", 7),

    /**
     * 八月
     */
    August("八月", 8),

    /**
     * 九月
     */
    September("九月", 9),

    /**
     * 十月
     */
    October("十月", 10),

    /**
     * 十一月
     */
    November("十一月", 11),

    /**
     * 十二月
     */
    December("十二月", 12);

    /**
     * 月份名称
     */
    private String monthName;

    /**
     * 月份数字
     */
    private int number;

    MonthEnum(String monthName, int number) {
        this.monthName = monthName;
        this.number = number;
    }


    public String monthName() {
        return monthName;
    }

    public int number() {
        return number;
    }


    public static MonthEnum valueOf(int number) {
        for (MonthEnum numberEnum : MonthEnum.values()) {
            if (numberEnum.number == number) {
                return numberEnum;
            }
        }
        return null;
    }

}
