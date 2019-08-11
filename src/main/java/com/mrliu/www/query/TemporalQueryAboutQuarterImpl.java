package com.mrliu.www.query;

import com.mrliu.www.enums.Quarter;
import com.mrliu.www.factory.Context;

import java.time.LocalDate;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalQuery;


/**
 * 季度获取
 *
 * @author liuyangos8888
 */
public class TemporalQueryAboutQuarterImpl implements TemporalQuery<Quarter> {

    private static Context context = new Context();

    @Override
    public Quarter queryFrom(TemporalAccessor temporal) {

        LocalDate from = LocalDate.from(temporal);

        return context.getQuarterNumber(from);
    }
}
