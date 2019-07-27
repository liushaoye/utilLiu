package com.mrliu.www.strategy.impl;

import com.mrliu.www.enums.WeekOfDayEnum;
import com.mrliu.www.strategy.Strategy;

/**
 * @author liuyangos8888
 */
public class WednesdayStrategy implements Strategy {

    /**
     * 返回周三对应的数字
     *
     * @param dayOfWeek 星期几
     * @return 对应的数字
     */
    @Override
    public Integer getWeekNumber(String dayOfWeek) {
        if (dayOfWeek.equals(WeekOfDayEnum.DAY_WEDNESDAY.weekDay())) {
            return WeekOfDayEnum.DAY_WEDNESDAY.number();
        }

        return 0;
    }

    /**
     * 数字返回周三
     *
     * @param dayOfWeek 数字（1-7）
     * @return 数字返回周三
     */
    @Override
    public String getWeekChineseName(Integer dayOfWeek) {
        if (dayOfWeek.equals(WeekOfDayEnum.DAY_WEDNESDAY.number())) {
            return WeekOfDayEnum.DAY_WEDNESDAY.weekDay();
        }

        return "输入的不是1-7的数字，不在合法星期范围内";
    }
}
