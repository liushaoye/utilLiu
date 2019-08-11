package com.mrliu.www.strategy.quarter.month.impl;

import com.mrliu.www.strategy.quarter.month.QuarterStrategy;

/**
 * @author liuyangos8888
 */
public class FebruaryStrategy implements QuarterStrategy {

    @Override
    public Integer getInitMonth(int month) {

        if (month >= 2 && month <= 4){

            return 2;
        }

        return 0;
    }
}
