package com.mrliu.www.strategy.quarter.month.impl;

import com.mrliu.www.strategy.quarter.month.QuarterStrategy;

public class ZeroStrategy implements QuarterStrategy {


    @Override
    public Integer getInitMonth(int month) {

        if (month==0){

            return 0;
        }

        return 0;
    }
}
