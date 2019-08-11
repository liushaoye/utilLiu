package com.mrliu.www.strategy.quarter.month;


/**
 * @author liuyangos8888
 */
public interface QuarterStrategy {


    /**
     * 获取月份初始值
     *
     * @param month 月份
     * @return 月份数
     */
    Integer getInitMonth(int month);

}
