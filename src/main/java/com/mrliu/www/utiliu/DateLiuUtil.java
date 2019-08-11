package com.mrliu.www.utiliu;


import com.mrliu.www.enums.Quarter;
import com.mrliu.www.factory.Context;
import com.mrliu.www.query.TemporalQueryAboutQuarterImpl;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalAdjuster;
import java.time.temporal.TemporalAdjusters;
import java.time.temporal.TemporalQuery;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

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
        LocalDateTime localDateTime = getLocalDateAboutInstant(instant);
        return localDateTime.getDayOfWeek();
    }

    /**
     * 获取instant 转化的日期格式
     *
     * @param instant DK8 代替Date使用的类
     * @return 时间格式
     */
    private static LocalDateTime getLocalDateAboutInstant(Instant instant) {
        return instantToLocalDateTime(instant);
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
     * 获取本周开始时间
     *
     * @param localDateTime 输入日期
     * @return 返回本周开始时间
     */
    public static LocalDateTime getTodayFirstOfWeek(LocalDateTime localDateTime) {

        TemporalAdjuster temporalAdjuster = getFirstTemporalAdjuster();

        return localDateTime.with(temporalAdjuster);

    }

    /**
     * 获取本周结束时间
     *
     * @param localDateTime 输入日期
     * @return 本周结束时间
     */
    public static LocalDateTime getTodayLastOfWeek(LocalDateTime localDateTime) {

        TemporalAdjuster temporalAdjuster = getLastTemporalAdjuster();

        return localDateTime.with(temporalAdjuster);

    }

    /**
     * 本周开始时间
     *
     * @return 返回本周开始时间
     */
    private static TemporalAdjuster getFirstTemporalAdjuster() {
        return TemporalAdjusters.ofDateAdjuster(
                localDate -> localDate.minusDays(localDate.getDayOfWeek().getValue() - DayOfWeek.MONDAY.getValue()));
    }

    /**
     * 本周结束时间
     *
     * @return 返回本周结束时间
     */
    private static TemporalAdjuster getLastTemporalAdjuster() {
        return TemporalAdjusters.ofDateAdjuster(
                localDate -> localDate.plusDays(DayOfWeek.SUNDAY.getValue() - localDate.getDayOfWeek().getValue()));
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

        LocalDate localDate = LocalDate.now().plusMonths(season * 3);
        //当月
        int month = getMonth(localDate.getMonth());

        Integer initMonth = context.getInitMonth(month);

        return localDate.plusMonths(initMonth).with(TemporalAdjusters.firstDayOfMonth());
    }


    /**
     * 获取某季度的结束日期
     *
     * @param season 0本季度，1下个季度，-1上个季度，依次类推
     * @return 日期结果
     */
    public static LocalDate getQuarterEndTime(int season) {

        LocalDate localDate = LocalDate.now().plusMonths(season * 3);
        //当月
        int month = getMonth(localDate.getMonth());

        Integer initMonth = context.getInitMonth(month);

        return localDate.plusMonths(initMonth).with(TemporalAdjusters.lastDayOfMonth());
    }


    /**
     * 获取某季度的名称和数字
     *
     * @param localDate 输入日期
     * @return 季度的名称和数字
     */
    public static Quarter getQuarterNumber(LocalDate localDate) {

        TemporalQuery<Quarter> quarterOfYearQuery = new TemporalQueryAboutQuarterImpl();

        return localDate.query(quarterOfYearQuery);
    }

    /**
     * 获取月份
     *
     * @param month 月份
     * @return 数值
     */
    private static int getMonth(Month month) {
        return month.getValue();
    }


    /**
     * 在日期上增加数个整天
     *
     * @param instant 输入日期
     * @param day     增加或减少的天数
     * @return 增加或减少后的日期
     */
    public static LocalDateTime addDay(Instant instant,
                                       int day
    ) {
        LocalDateTime localDateAboutInstant = getLocalDateAboutInstant(instant);

        return localDateAboutInstant.plusDays(day);
    }

    /**
     * 在日期上增加/减少（负数）数个小时
     *
     * @param instant 输入时间
     * @param hour    增加/减少的小时数
     * @return 增加/减少小时后的日期
     */
    public static LocalDateTime addDateHour(Instant instant,
                                            int hour
    ) {

        LocalDateTime localDateAboutInstant = getLocalDateAboutInstant(instant);

        return localDateAboutInstant.plusHours(hour);
    }


    /**
     * 在日期上增加/减少数个分钟
     *
     * @param instant 输入时间
     * @param minutes 增加/减少的分钟数
     * @return 增加/减少分钟后的日期
     */
    public static LocalDateTime addDateMinutes(Instant instant,
                                               int minutes
    ) {

        LocalDateTime localDateAboutInstant = getLocalDateAboutInstant(instant);

        return localDateAboutInstant.plusMinutes(minutes);
    }

    /**
     * 得到两个日期时间的差额(毫秒)
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 两个时间相差多少秒
     */
    public static long differenceDateMillis(LocalDateTime startTime,
                                            LocalDateTime endTime
    ) {

        Duration between = Duration.between(startTime, endTime);

        return between.toMillis();
    }

    /**
     * 得到两个日期时间的差额(分)
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 两个时间相差多少分
     */
    public static long differenceDateMinutes(LocalDateTime startTime,
                                             LocalDateTime endTime
    ) {

        Duration between = Duration.between(startTime, endTime);

        return between.toMinutes();
    }

    /**
     * 得到两个日期时间的差额(小时)
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 两个时间相差多少小时
     */
    public static long differenceDateHours(LocalDateTime startTime,
                                           LocalDateTime endTime
    ) {

        Duration between = Duration.between(startTime, endTime);

        return between.toHours();
    }

    /**
     * 得到两个日期时间的差额(天)
     *
     * @param startTime 开始时间
     * @param endTime   结束时间
     * @return 两个时间相差多少天
     */
    public static long differenceDateDays(LocalDateTime startTime,
                                          LocalDateTime endTime
    ) {

        Duration between = Duration.between(startTime, endTime);

        return between.toDays();
    }

    /**
     * 获取指定日期的月份
     *
     * @param localDateTime 输入日期
     * @return 返回指定日期的月份
     */
    public static int getMonthAboutLocalTime(LocalDateTime localDateTime) {

        Month month = localDateTime.getMonth();

        return getMonth(month);
    }

    /**
     * 获取指定日期的年份
     *
     * @param localDateTime 输入日期
     * @return 返回指定日期的年份
     */
    public static int getYearAboutLocalTime(LocalDateTime localDateTime) {

        return localDateTime.getYear();
    }

    /**
     * 获取指定日期的天数
     *
     * @param localDateTime 输入日期
     * @return 返回指定日期的天数
     */
    public static int getDayAboutLocalTime(LocalDateTime localDateTime) {

        return localDateTime.getDayOfMonth();
    }

    /**
     * 获取指定日期的星期
     *
     * @param localDateTime 输入日期
     * @return 返回指定日期的星期
     */
    public static int getWeekDayAboutLocalTime(LocalDateTime localDateTime) {

        return localDateTime.getDayOfWeek().getValue();
    }

    /**
     * 获取指定日期的时间
     *
     * @param localDateTime 输入日期
     * @return 返回指定日期的时间
     */
    public static int getHouryAboutLocalTime(LocalDateTime localDateTime) {

        return localDateTime.getHour();
    }


    /**
     * 获取指定日期的所在月的最后一天
     *
     * @param localDateTime 输入日期
     * @return 返回指定日期的时间
     */
    public static int getLateDayFromMonth(LocalDateTime localDateTime) {

        return localDateTime.with(TemporalAdjusters.lastDayOfMonth()).getDayOfMonth();
    }


    /**
     * 获取指定日期的所在月的第一天
     *
     * @param localDateTime 输入日期
     * @return 返回指定日期的时间
     */
    public static LocalDateTime getFirstDayFromMonth(LocalDateTime localDateTime) {

        return localDateTime.with(TemporalAdjusters.firstDayOfMonth());
    }


    public static LocalDateTime getDayOfWeek(Instant instant, int week) {


        LocalDateTime localDateTime = instantToLocalDateTime(instant);

        DayOfWeek plus = localDateTime.getDayOfWeek().plus(week);

        return addDay(localDateTime.atZone(ZoneId.systemDefault()).toInstant(), plus.getValue() - week);

    }

    /**
     * 获取到指定日期一个月有几天
     *
     * @param instant 输入日期
     * @return 天数
     */
    public static int getDayCountOfMonth(Instant instant) {
        LocalDateTime localDateTime = instantToLocalDateTime(instant);

        LocalDateTime startTime = localDateTime.with(TemporalAdjusters.firstDayOfMonth());
        LocalDateTime endTime = localDateTime.with(TemporalAdjusters.lastDayOfMonth());

        Duration between = Duration.between(startTime, endTime);

        return (int) between.toDays() + 1;
    }


    /**
     * 当前时间10位毫秒数
     *
     * @return 10位秒
     */
    public static long getNowOfSecond() {

        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTimeToInstant(localDateTime).plusMillis(TimeUnit.HOURS.toMillis(8)).getEpochSecond();
    }

    /**
     * 当前时间13位毫秒数
     *
     * @return 13位毫秒数
     */
    public static long getNowOfMillion() {

        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTimeToInstant(localDateTime).toEpochMilli();
    }

    /**
     * 当前时间13位毫秒数
     *
     * @return 13位毫秒数
     */
    public static long getNowOfMillions() {

        LocalDateTime localDateTime = LocalDateTime.now();

        return localDateTimeToInstant(localDateTime).plusMillis(TimeUnit.HOURS.toMillis(8)).toEpochMilli();
    }


    /**
     * LocalDateTime 转化为 Instant
     *
     * @param localDateTime 输入的时间
     * @return Instant的日期类型
     */
    public static Instant localDateTimeToInstant(LocalDateTime localDateTime) {

        return localDateTime.atZone(ZoneId.systemDefault()).toInstant();
    }

    /**
     * LocalDateTime 转化为 LocalDate
     *
     * @param localDateTime 输入的时间
     * @return LocalDate的日期类型
     */
    public static LocalDate localDateTimeTolocalDate(LocalDateTime localDateTime) {

        return localDateTime.toLocalDate();
    }


    /**
     * LocalDate 转化为 LocalDateTime
     *
     * @param localDate 输入的时间
     * @return LocalDateTime的日期类型
     */
    public static LocalDateTime localDateTimeTolocalDate(LocalDate localDate) {

        return localDate.atStartOfDay(ZoneOffset.ofHours(8)).toLocalDateTime();
    }

    /**
     * instant  转化为 LocalDateTime
     *
     * @param instant 输入的时间
     * @return LocalDateTime的日期类型
     */
    public static LocalDateTime instantToLocalDateTime(Instant instant) {
        return LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
    }

    /**
     * instant  转化为 LocalDate
     *
     * @param instant 输入的时间
     * @return LocalDate的日期类型
     */
    public static LocalDate instantToLocalDate(Instant instant) {
        return instant.atZone(ZoneOffset.ofHours(8)).toLocalDate();
    }


    /**
     * 获取本周的周一日期
     *
     * @return 获取本周的周一日期
     */
    public static LocalDateTime getMondayThisWeek() {

        LocalDateTime todayFirstOfWeek = getTodayFirstOfWeek(getTodayStartTime(0));

        return todayFirstOfWeek.with(getFirstTemporalAdjuster());

    }


    /**
     * 获取本周的周日日期
     *
     * @return 获取本周的周日日期
     */
    public static LocalDateTime getSundayThisWeek() {

        LocalDateTime todayFirstOfWeek = getTodayLastOfWeek(getTodayStartTime(0));

        return todayFirstOfWeek.with(getFirstTemporalAdjuster());

    }

    /**
     * 获取上周周一的日期
     *
     * @return 获取上周周一的日期
     */
    public static LocalDateTime getMondayPreviousWeek() {

        return getMondayThisWeek().minusDays(7);

    }

    /**
     * 获取上周周日的日期
     *
     * @return 获取上周周日的日期
     */
    public static LocalDateTime getSundayPreviousWeek() {

        return getSundayThisWeek().minusDays(8);

    }


    /**
     * LocalDate转时间戳
     *
     * @param localDate 时间输入
     * @return 时间戳
     */
    public static Long getLocalDateToMillis(LocalDate localDate) {

        return localDate.atStartOfDay(ZoneOffset.ofHours(8)).toInstant().toEpochMilli();

    }

    /**
     * LocalDateTime转时间戳
     *
     * @param localDateTime 时间输入
     * @return 时间戳
     */
    public static Long getLocalDateTimeToMillis(LocalDateTime localDateTime) {

        return localDateTime.toInstant(ZoneOffset.ofHours(8)).toEpochMilli();

    }

    /**
     * 毫秒值转LocalDate
     *
     * @param timeStamp 时间戳毫秒值
     * @return LocalDate
     */
    public static LocalDate getMillisToLocalDate(long timeStamp) {

        return Instant.ofEpochMilli(timeStamp).atZone(ZoneOffset.ofHours(8)).toLocalDate();

    }

    /**
     * 毫秒值转LocalDateTime
     *
     * @param timeStamp 时间戳毫秒值
     * @return LocalDateTime
     */
    public static LocalDateTime getMillisToLocalDateTime(long timeStamp) {

        return Instant.ofEpochMilli(timeStamp).atZone(ZoneOffset.ofHours(8)).toLocalDateTime();

    }


    /**
     * 毫秒值加一年后的毫秒值
     *
     * @param original 毫秒值
     * @return 毫秒值
     */
    public static long getNextYear(long original) {

        LocalDateTime millisToLocalDateTime = getMillisToLocalDateTime(original);

        return millisToLocalDateTime.minus(1, ChronoUnit.YEARS).toInstant(ZoneOffset.ofHours(8)).toEpochMilli();
    }

}
