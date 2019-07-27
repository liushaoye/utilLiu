package com.mrliu.www.strategy.week.impl;

import com.mrliu.www.enums.WeekOfDayEnum;
import com.mrliu.www.strategy.week.Strategy;

/**
 * @author liuyangos8888
 */
public class SaturdayStrategy implements Strategy {

    /**
     * 周六的返回数字
     *
     * @param dayOfWeek 星期几
     * @return 周六的返回数字
     */
    @Override
    public Integer getWeekNumber(String dayOfWeek) {
        if (dayOfWeek.equals(WeekOfDayEnum.DAY_SATURDAY.weekDay())) {
            return WeekOfDayEnum.DAY_SATURDAY.number();
        }

        return 0;
    }

    /**
     * 数字返回周六
     *
     * @param dayOfWeek 数字（1-7）
     * @return 数字返回周六
     */
    @Override
    public String getWeekChineseName(Integer dayOfWeek) {
        if (dayOfWeek.equals(WeekOfDayEnum.DAY_SATURDAY.number())) {
            return WeekOfDayEnum.DAY_SATURDAY.weekDay();
        }

        return "输入的不是1-7的数字，不在合法星期范围内";
    }
}
