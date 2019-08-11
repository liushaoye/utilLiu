package com.mrliu.www.strategy.quarter.number;


import com.mrliu.www.enums.Quarter;

import java.time.LocalDate;

/**
 * @author liuyangos8888
 */
public interface QuarterNumberStrategy {


    /**
     * 获取月份初始值
     *
     * @param localDate 传入时间
     * @return 月份数
     */
    Quarter getQuarterNumber(LocalDate localDate);

}
