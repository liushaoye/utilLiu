package com.mrliu.www.strategy;

import java.time.Instant;

/**
 * @author liuyangos8888
 */
public interface Strategy {

    /***
     * 输入星期几返回对应数字
     * @param dayOfWeek 星期几
     * @return 对应的数字
     */
    Integer getWeekNumber(String dayOfWeek);

    /**
     * 输入数字返回对应的汉字星期几
     *
     * @param dayOfWeek 数字（1-7）
     * @return 对应的汉字星期几
     */
    String getWeekChineseName(Integer dayOfWeek);
}
