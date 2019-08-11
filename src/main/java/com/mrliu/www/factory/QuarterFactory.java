package com.mrliu.www.factory;

import com.mrliu.www.strategy.quarter.month.QuarterStrategy;
import com.mrliu.www.strategy.quarter.month.impl.*;

import java.util.HashMap;
import java.util.Map;

/**
 * 季度工厂
 *
 * @author liuyangos8888
 */
public class QuarterFactory {


    /**
     * 创建工厂实体类
     */
    private static QuarterFactory quarterFactory = new QuarterFactory();


    private static Map<String, QuarterStrategy> stringStrategyMap = new HashMap<>();


    private QuarterFactory() {
    }


    static {
        stringStrategyMap.put("0", new ZeroStrategy());
        stringStrategyMap.put("1", new JanuaryStrategy());
        stringStrategyMap.put("2", new FebruaryStrategy());
        stringStrategyMap.put("3", new FebruaryStrategy());
        stringStrategyMap.put("4", new FebruaryStrategy());
        stringStrategyMap.put("5", new MayStrategy());
        stringStrategyMap.put("6", new MayStrategy());
        stringStrategyMap.put("7", new MayStrategy());
        stringStrategyMap.put("8", new AugustStrategy());
        stringStrategyMap.put("9", new AugustStrategy());
        stringStrategyMap.put("10", new AugustStrategy());
        stringStrategyMap.put("11", new NovemberStrategy());
        stringStrategyMap.put("12", new NovemberStrategy());

    }


    public QuarterStrategy creator(String month) {

        return stringStrategyMap.get(month);
    }

    public static QuarterFactory getInstance() {
        return quarterFactory;
    }


}
