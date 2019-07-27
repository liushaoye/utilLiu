package com.mrliu.www.utiliu;

import com.mrliu.www.enums.MonthEnum;
import com.mrliu.www.factory.Context;
import sun.jvm.hotspot.utilities.memo.MemoizedInt;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.TemporalAdjusters;
import java.util.Locale;
import java.util.Map;

/**
 * @author ： liuyangos8888
 * @date ：2019/06/10 09:42
 * @describe: <br/>
 * <br/>
 * JDK1.8  日期工具类
 */
public class DateLiuUtil {
    /**
     * 年-月-日 时:分:秒:毫秒 最全版
     */
    public final static String DEFAULT_PATTERN_DATETIME_FULL = "yyyy-MM-dd HH:mm:ss.SSS";

    /**
     * 年-月-日 时:分:秒:毫秒 中文版
     */
    public final static String DEFAULT_PATTERN_DATETIME_FULL_CHINESE = "yyyy年MM月dd日 HH:mm:ss.SSS";

    /**
     * 年-月-日 时:分:秒:毫秒 中文版全
     */
    public final static String DEFAULT_PATTERN_DATETIME_CHINESE_FULL = "yyyy年MM月dd日 HH时mm分ss秒SSS毫秒";

    /**
     * 年-月-日 时:分:秒 标准样式
     */
    public final static String DEFAULT_PATTERN_DATETIME = "yyyy-MM-dd HH:mm:ss";

    /**
     * 年-月-日 时:分:秒 中文版1
     */
    public final static String DEFAULT_PATTERN_DATETIME_CHINESE_ONE = "yyyy年MM月dd日 HH:mm:ss";

    /**
     * 年-月-日 时:分:秒 中文版2
     */
    public final static String DEFAULT_PATTERN_DATETIME_CHINESE_TWO = "yyyy年MM月dd日 HH时mm分ss秒";

    /**
     * 年-月-日
     */
    public final static String DEFAULT_PATTERN_DATE = "yyyy-MM-dd";

    /**
     * 年-月-日 中文版
     */
    public final static String DEFAULT_PATTERN_DATE_CHINESE = "yyyy年MM月dd日";

    /**
     * 年-月 中文版
     */
    public final static String DEFAULT_PATTERN_DATE_YEAR_MONTH_CHINESE = "yyyy年MM月";

    /**
     * 月-日
     */
    public final static String DEFAULT_PATTERN_MONTH = "MM-dd";

    /**
     * 日
     */
    public final static String DEFAULT_PATTERN_DAY = "dd";

    /**
     * 时:分:秒
     */
    public final static String DEFAULT_PATTERN_TIME = "HH:mm:ss";

    /**
     * 年月日时分秒毫秒  紧凑版
     */
    public final static String DEFAULT_PATTERN_DATETIME_SIMPLE_FULL = "yyyyMMddHHmmssSSS";

    /**
     * 年月日时分秒
     */
    public final static String DEFAULT_PATTERN_DATETIME_SIMPLE = "yyyyMMddHHmmss";

    /**
     * 年月日
     */
    public final static String DEFAULT_PATTERN_DATETIME_DATE = "yyyyMMdd";

    /**
     * 月日
     */
    public final static String DEFAULT_PATTERN_DATETIME_MONTH = "MMdd";

    /**
     * 时分秒毫秒
     */
    public final static String DEFAULT_PATTERN_DATETIME_TIME_FULL = "HHmmss";

    private static Context context = new Context();


    /**
     * 格式化年月日为字符串
     *
     * @param localDate 传入需要格式化的日期
     * @param pattern   需要格式化的格式
     * @return String 返回格式化的日期
     */
    public static String formatterLocalDateToString(LocalDate localDate, String pattern) {

        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(pattern);

        return getLocalDateFormat(localDate, dateTimeFormatter);

    }

    /**
     * 格式化年月日时分秒为字符串
     *
     * @param localDateTime 传入需要格式化的日期
     * @param pattern       需要格式化的格式
     * @return String 返回格式化的日期
     */
    public static String formatterLocalDateTimeToString(LocalDateTime localDateTime, String pattern) {

        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(pattern);

        return getLocalDateTimeFormat(localDateTime, dateTimeFormatter);

    }


    /**
     * 时区格式化年月日为字符串
     *
     * @param localDate 传入需要格式化的日期
     * @param pattern   需要格式化的格式
     * @param locale    国际时区   Locale.CHINA
     * @return String 返回格式化的日期
     */
    public static String formatterLocalDateToString(LocalDate localDate,
                                                    String pattern,
                                                    Locale locale
    ) {

        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(pattern, locale);

        return getLocalDateFormat(localDate, dateTimeFormatter);

    }

    /**
     * 时区格式化年月日时分秒为字符串
     *
     * @param localDateTime 传入需要格式化的日期
     * @param pattern       需要格式化的格式
     * @param locale        国际时区 Locale.CHINA
     * @return String 返回格式化的日期
     */
    public static String formatterLocalDateTimeToString(LocalDateTime localDateTime,
                                                        String pattern,
                                                        Locale locale
    ) {

        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(pattern, locale);

        return getLocalDateTimeFormat(localDateTime, dateTimeFormatter);

    }


    /**
     * LocalDate格式化日期为日期格式
     *
     * @param localDate 传入需要格式化的日期
     * @param pattern   需要格式化的格式
     * @return String 返回格式化的日期
     */
    public static LocalDate formatterStringToLocalDate(String localDate, String pattern) {

        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(pattern);

        return getLocalDateParse(localDate, dateTimeFormatter);

    }

    /**
     * localDateTime格式化日期为日期格式
     *
     * @param localDateTime 传入需要格式化的日期
     * @param pattern       需要格式化的格式
     * @return String 返回格式化的日期
     */
    public static LocalDateTime formatterStringToLocalDateTime(String localDateTime, String pattern) {

        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(pattern);

        return getLocalDateTimeParse(localDateTime, dateTimeFormatter);

    }


    /**
     * 日期格式化日期，转化为日期格式 localDate 转 LocalDate
     *
     * @param localDate 传入的日期
     * @param pattern   转化的格式
     * @return 返回结果 LocalDate
     */
    public static LocalDate formatterDateToLocalDateTime(LocalDate localDate,
                                                         String pattern) {

        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(pattern);

        String formatterDateTime = getLocalDateFormat(localDate, dateTimeFormatter);

        return getLocalDateParse(formatterDateTime);

    }

    /**
     * 日期格式化日期，转化为日期格式 localDateTime 转 localDateTime
     *
     * @param localDateTime 传入需要格式化的日期
     * @param pattern       需要格式化的格式
     * @return String 返回格式化的日期
     */
    public static LocalDateTime formatterDateTimeToLocalDateTime(LocalDateTime localDateTime,
                                                                 String pattern) {

        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(pattern);

        String formatterDateTime = getLocalDateTimeString(localDateTime, dateTimeFormatter);

        return getLocalDateTimeParse(formatterDateTime, dateTimeFormatter);

    }

    /**
     * 格式化日期格式 yyyy-MM-dd HH:mm:ss
     *
     * @param localDateTime 传入需要格式化的日期
     * @return 返回格式化后的日期字符串
     */
    public static String getAllFormatterLocalDateTime(LocalDateTime localDateTime) {
        DateTimeFormatter dateTimeFormatter = getDateTimeFormatter(DEFAULT_PATTERN_DATETIME);
        return getLocalDateTimeFormat(localDateTime, dateTimeFormatter);
    }


    /**
     * 获取LocalDate转化为字符串
     *
     * @param formatterDateTime 需要转化的数据
     * @return LocalDate
     */
    private static LocalDate getLocalDateParse(String formatterDateTime) {
        return LocalDate.parse(formatterDateTime);
    }

    /**
     * 获取LocalDate按要求转化为字符串
     *
     * @param formatterDateTime 需要转化的数据
     * @param dateTimeFormatter 格式化
     * @return LocalDate
     */
    private static LocalDate getLocalDateParse(String formatterDateTime, DateTimeFormatter dateTimeFormatter) {
        return LocalDate.parse(formatterDateTime, dateTimeFormatter);
    }

    /**
     * 获取LocalDate按照要求转化为字符串
     *
     * @param localDate         需要转化的数据
     * @param dateTimeFormatter 转化的格式
     * @return 转化后返回字符串
     */
    private static String getLocalDateFormat(LocalDate localDate, DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.format(localDate);
    }

    /**
     * 获取LocalDateTime按照要求转化为字符串
     *
     * @param localDateTime     需要转化的数据
     * @param dateTimeFormatter 转化的格式
     * @return 返回结果
     */
    private static String getLocalDateTimeFormat(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        return localDateTime.format(dateTimeFormatter);
    }

    /**
     * 获取数据按照国际标准转化的值
     *
     * @param pattern 需要转化的数据
     * @param locale  传入国际时间
     * @return 返回格式结果
     */
    private static DateTimeFormatter getDateTimeFormatter(String pattern, Locale locale) {
        return DateTimeFormatter.ofPattern(pattern, locale);
    }

    /**
     * 获取localDateTime按照国际标准转化的值
     *
     * @param localDateTime     需要转化的数据
     * @param dateTimeFormatter 格式化
     * @return 返回 LocalDateTime
     */
    private static LocalDateTime getLocalDateTimeParse(String localDateTime, DateTimeFormatter dateTimeFormatter) {
        return LocalDateTime.parse(localDateTime, dateTimeFormatter);
    }

    /**
     * 获取格式化的结果
     *
     * @param pattern 传入的格式
     * @return 返回格式化结果
     */
    private static DateTimeFormatter getDateTimeFormatter(String pattern) {
        return DateTimeFormatter.ofPattern(pattern);
    }

    /**
     * 获取格式化LocalDateTime结果
     *
     * @param localDateTime     传入的数据
     * @param dateTimeFormatter 格式化的结果
     * @return 返回字符串
     */
    private static String getLocalDateTimeString(LocalDateTime localDateTime, DateTimeFormatter dateTimeFormatter) {
        return dateTimeFormatter.format(localDateTime);
    }


    /**
     * 获取今天星期几
     *
     * @param instant JDK8中代替Date使用的类
     * @return 当前的星期天数
     */
    public static String getWeekFromInstant(Instant instant) {

        DayOfWeek dayOfWeek = getDayOfWeek(instant);

        return context.getWeekChineseName(dayOfWeek.getValue());
    }

    /**
     * 获取今天星期几
     *
     * @param instant JDK8 代替Date使用的类
     * @return 当前的星期
     */
    private static DayOfWeek getDayOfWeek(Instant instant) {

        // ZoneId.systemDefault() 设置当前时区为系统默认时区
        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        return localDateTime.getDayOfWeek();
    }

    /**
     * 输入日期返回日期对应的星期（采用策略设计模式，去除了if else的繁琐判断）
     *
     * @param instant 输入当前日期
     * @return 返回日期对应的星期几
     */
    public static Integer getWeekAboutNumber(Instant instant) {

        return context.getWeekNumber(getWeekFromInstant(instant));
    }


    /**
     * 获取天的开始时间
     *
     * @param day 0 今天  1 明天 -1 昨天
     * @return 开始时间
     */
    public static LocalDateTime getTodayStartTime(int day) {

        return LocalDate.now().plusDays(day).atStartOfDay();

    }

    /**
     * 获取某月的开始时间
     *
     * @param month 0 本月  1 下月 -1 上月
     * @return 月开始的时间
     */
    public static LocalDate getMonthStartTime(int month) {

        return LocalDate.now().plusMonths(month).with(TemporalAdjusters.firstDayOfMonth());
    }


    /**
     * 获取某年的开始时间
     *
     * @param year 0 今年  1 明年 -1 前年
     * @return 年的开始时间
     */
    public static LocalDate getYearStartTime(int year) {

        return LocalDate.now().plusYears(year).with(TemporalAdjusters.firstDayOfYear());
    }


    /**
     * 获取某天的结束时间
     *
     * @return 天的结束时间  ZoneId.systemDefault()系统默认时区，如果需要改变时区使用ZoneId.of("时区")
     */
    public static LocalDateTime getTodayEndTime() {

        return LocalDateTime.of(LocalDate.now(ZoneId.systemDefault()), LocalTime.MIDNIGHT);

    }

    /**
     * 获取某月的结束时间
     *
     * @param day 0 本月  1 下月 -1 上月
     * @return 月的结束时间
     */
    public static LocalDate getMonthEndTime(int day) {

        return LocalDate.now().plusDays(day).with(TemporalAdjusters.lastDayOfMonth());

    }

    /**
     * 获取某年的结束时间
     *
     * @param year 0 今年  1 明年 -1 前年
     * @return 年的结束时间
     */
    public static LocalDate getYearEndTime(int year) {

        return LocalDate.now().plusYears(year).with(TemporalAdjusters.lastDayOfYear());
    }

    /**
     * 获取今天中午的时间
     *
     * @return 今天中午的时间
     */
    public static LocalDateTime getTodayNoonTime() {

        return LocalDateTime.of(LocalDate.now(ZoneId.systemDefault()), LocalTime.NOON);

    }


    /**
     * 获取某季度的开始日期
     *
     * @param season 0本季度，1下个季度，-1上个季度，依次类推
     * @return 日期结果
     */
    public static LocalDate getQuarterStartTime(int season) {

        final LocalDate localDate = LocalDate.now().plusMonths(season * 3);
        //当月
        int month = localDate.getMonth().getValue();

        int start = 0;

        if (month >= MonthEnum.February.number() && month <= MonthEnum.April.number()) {
            //第一季度
            start = 2;
        } else if (month >= MonthEnum.May.number() && month <= MonthEnum.July.number()) {
            //第二季度
            start = 5;
        } else if (month >= MonthEnum.August.number() && month <= MonthEnum.October.number()) {
            //第三季度
            start = 8;
        } else if ((month >= MonthEnum.November.number() && month <= MonthEnum.December.number())) {
            //第四季度
            start = 11;
        } else if (month == MonthEnum.January.number()) {
            //第四季度
            start = 11;
            month = 13;
        }

        return localDate.plusMonths(start - month).with(TemporalAdjusters.firstDayOfMonth());
    }


}
