package com.mrliu.www.enums;

public enum WeekOfDayEnum {

    /**
     * 星期日对应的数字
     */
    DAY_SUNDAY("星期日", 7),

    /**
     * 星期一对应的数字
     */
    DAY_MONDAY("星期一",1),
    /**
     * 星期二对应的数字
     */
    DAY_TUESDAY("星期二",2),
    /**
     * 星期三对应的数字
     */
    DAY_WEDNESDAY("星期三",3),
    /**
     * 星期四对应的数字
     */
    DAY_THURSDAY("星期四",4),
    /**
     * 星期五对应的数字
     */
    DAY_FRIDAY("星期五",5),
    /**
     * 星期六对应的数字
     */
    DAY_SATURDAY("星期六",6);


    /**
     * 星期几
     */
    private String weekDay;

    /**
     * 星期几对应的数字
     */
    private int number;

    WeekOfDayEnum(String weekDay, int number) {
        this.weekDay = weekDay;
        this.number = number;
    }


    public String weekDay() {
        return weekDay;
    }

    public int number() {
        return number;
    }



    public static WeekOfDayEnum valueOf(int number) {
        for(WeekOfDayEnum weekOfDayEnum : WeekOfDayEnum.values()) {
            if(weekOfDayEnum.number == number) {
                return weekOfDayEnum;
            }
        }
        return null;
    }
}
