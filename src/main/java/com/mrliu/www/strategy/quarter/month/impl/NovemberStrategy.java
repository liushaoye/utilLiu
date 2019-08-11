package com.mrliu.www.strategy.quarter.month.impl;

import com.mrliu.www.strategy.quarter.month.QuarterStrategy;

public class NovemberStrategy implements QuarterStrategy {


    @Override
    public Integer getInitMonth(int month) {

        if (month >= 11 && month <= 12) {
            return  11;
        }

        return 0;
    }
}
