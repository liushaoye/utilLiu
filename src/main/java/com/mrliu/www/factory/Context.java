package com.mrliu.www.factory;

import com.mrliu.www.strategy.week.Strategy;

/**
 * @author liuyangos8888
 */
public class Context {

    /**
     * 注入策略模式类
     */
    private Strategy strategy;


    public Integer getWeekNumber(String dayOfWeek) {

        strategy = StrategyFactory.getInstance().creator(dayOfWeek);

        return strategy.getWeekNumber(dayOfWeek);
    }


    public String getWeekChineseName(int dayOfWeek) {
        strategy = ChineseWeekFactory.getInstance().creator(dayOfWeek);
        return strategy.getWeekChineseName(dayOfWeek);
    }


    public Strategy getStrategy() {
        return strategy;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }
}
