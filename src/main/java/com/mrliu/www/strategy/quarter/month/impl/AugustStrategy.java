package com.mrliu.www.strategy.quarter.month.impl;

import com.mrliu.www.strategy.quarter.month.QuarterStrategy;


/**
 * @author liuyangos8888
 */
public class AugustStrategy implements QuarterStrategy {


    /**
     * 获取月份
     *
     * @param month 月份
     * @return 月份
     */
    @Override
    public Integer getInitMonth(int month) {

        if (month >= 8 && month <= 10) {
            return 8;
        }
        return 0;

    }
}
