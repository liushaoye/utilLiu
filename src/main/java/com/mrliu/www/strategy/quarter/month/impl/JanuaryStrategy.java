package com.mrliu.www.strategy.quarter.month.impl;

import com.mrliu.www.strategy.quarter.month.QuarterStrategy;

public class JanuaryStrategy implements QuarterStrategy {

    @Override
    public Integer getInitMonth(int month) {

        if (month == 1){
            return 11;
        }
        return 0;
    }
}
