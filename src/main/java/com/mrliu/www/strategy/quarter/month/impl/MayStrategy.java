package com.mrliu.www.strategy.quarter.month.impl;

import com.mrliu.www.strategy.quarter.month.QuarterStrategy;

public class MayStrategy implements QuarterStrategy {


    @Override
    public Integer getInitMonth(int month) {

        if (month >= 5 && month <= 7) {
            return  5;
        }
        return 0;
    }
}
