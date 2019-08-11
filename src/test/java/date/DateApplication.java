package date;

import com.mrliu.www.utiliu.DateLiuUtil;

import java.time.*;
import java.util.Locale;

/**
 *
 */
public class DateApplication {

    /**
     * LocalDate 当前时间
     */
    private static final LocalDate localDate = LocalDate.now();

    /**
     * LocalDateTime 当前时间
     */
    private static final LocalDateTime localDateTime = LocalDateTime.now();

    /**
     * yyyy-MM-dd 格式
     */
    private static final String localDateString = DateLiuUtil.formatterLocalDateToString(localDate, DateLiuUtil.DEFAULT_PATTERN_DATE);

    /**
     * yyyy-MM-dd HH:mm:ss 格式
     */
    private static final String localDateTimeString = DateLiuUtil.formatterLocalDateTimeToString(localDateTime, DateLiuUtil.DEFAULT_PATTERN_DATETIME);


    public static void main(String[] args) {

        // 1、  localDate格式化年月日为字符串
        System.out.println(DateLiuUtil.formatterLocalDateToString(localDate, DateLiuUtil.DEFAULT_PATTERN_DATE));

        // 2、  localDateTime格式化年月日时分秒为字符串
        System.out.println(DateLiuUtil.formatterLocalDateTimeToString(localDateTime, DateLiuUtil.DEFAULT_PATTERN_DATETIME_FULL));

        // 3、  localDate时区格式化年月日为字符串
        System.out.println(DateLiuUtil.formatterLocalDateToString(localDate, DateLiuUtil.DEFAULT_PATTERN_DATE, Locale.CHINA));

        // 4、  localDateTime时区格式化年月日为字符串
        System.out.println(DateLiuUtil.formatterLocalDateTimeToString(localDateTime, DateLiuUtil.DEFAULT_PATTERN_DATETIME, Locale.CHINA));

        // 5、  localDate 转 LocalDate
        System.out.println(DateLiuUtil.formatterDateToLocalDateTime(LocalDate.of(2019, 10, 1), DateLiuUtil.DEFAULT_PATTERN_DATE));

        // 6、  localDateTimeString 格式化日期为日期格式
        System.out.println(DateLiuUtil.formatterStringToLocalDateTime(localDateTimeString, DateLiuUtil.DEFAULT_PATTERN_DATETIME));

        // 7、  localDateString  格式化日期为日期格式
        System.out.println(DateLiuUtil.formatterStringToLocalDate(localDateString, DateLiuUtil.DEFAULT_PATTERN_DATE));

        // 8、  localDateTime 转 localDateTime
        System.out.println(DateLiuUtil.formatterDateTimeToLocalDateTime(LocalDateTime.of(2020, 12, 25, 9, 58, 16), DateLiuUtil.DEFAULT_PATTERN_DATETIME));

        // 9、  日期转化为固定格式yyyy-MM-dd HH:mm:ss
        System.out.println(DateLiuUtil.getAllFormatterLocalDateTime(LocalDateTime.of(2020, 12, 25, 9, 58, 16)));


        // 10、 获取当前日期是星期几
        System.out.println(DateLiuUtil.getWeekFromInstant(Instant.now()));

        // 11、 获取任意时间是星期几
        System.out.println(DateLiuUtil.getWeekFromInstant(Instant.parse("2019-07-26T10:37:30.00Z")));

        // 12、获取当前日期是星期几
        System.out.println(DateLiuUtil.getWeekFromInstant(Instant.from(ZonedDateTime.now())));

        // 13、获取任意时间是星期几
        System.out.println(DateLiuUtil.getWeekFromInstant(Instant.from(ZonedDateTime.of(2019, 10, 22, 10, 54, 32, 50000, ZoneId.systemDefault()))));

        // 14、获取星期几对应的数字
        System.out.println(DateLiuUtil.getWeekAboutNumber(Instant.now()));

        // 15、获取今天的最早时间
        System.out.println(DateLiuUtil.getTodayStartTime(0));

        // 16、获取本月的最早时间
        System.out.println(DateLiuUtil.getMonthStartTime(0));

        // 17、获取今年的最早时间
        System.out.println(DateLiuUtil.getYearStartTime(0));

        // 18、获取今天的最晚时间
        System.out.println(DateLiuUtil.getTodayEndTime());

        // 19、获取本月的最晚时间
        System.out.println(DateLiuUtil.getMonthEndTime(0));

        // 20、获取今年的最晚时间
        System.out.println(DateLiuUtil.getYearEndTime(0));

        // 21、获取今天中午的时间
        System.out.println(DateLiuUtil.getTodayNoonTime());

        // 22、获取某季度的开始日期
        System.out.println(DateLiuUtil.getQuarterStartTime(-2));

        // 23、在日期上增加数个整天
        System.out.println(DateLiuUtil.addDay(Instant.now(),5));

        // 24、在日期上减少数个整天
        System.out.println(DateLiuUtil.addDay(Instant.now(),-5));

        // 25、在日期上增加数个小时
        System.out.println(DateLiuUtil.addDateHour(Instant.now(),15));

        // 26、在日期上减少数个小时
        System.out.println(DateLiuUtil.addDateHour(Instant.now(),-15));

        // 27、在日期上增加数个分钟
        System.out.println(DateLiuUtil.addDateMinutes(Instant.now(),15));

        // 28、在日期上减少数个分钟
        System.out.println(DateLiuUtil.addDateMinutes(Instant.now(),-15));

        // 29、得到两个日期时间的差额(毫秒)
        System.out.println(DateLiuUtil.differenceDateMillis(LocalDateTime.now(),LocalDateTime.of(1991,4,12,20,0,0)));

        // 30、得到两个日期时间的差额(分)
        System.out.println(DateLiuUtil.differenceDateMinutes(LocalDateTime.now(),LocalDateTime.of(1991,4,12,20,0,0)));

        // 31、得到两个日期时间的差额(小时)
        System.out.println(DateLiuUtil.differenceDateHours(LocalDateTime.now(),LocalDateTime.of(1991,4,12,20,0,0)));

        //32、得到两个日期时间的差额(天)
        System.out.println(DateLiuUtil.differenceDateDays(LocalDateTime.now(),LocalDateTime.of(1991,4,12,20,0,0)));





    }
}
