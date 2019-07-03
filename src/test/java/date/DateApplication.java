package date;

import com.mrliu.www.utiliu.DateLiuUtil;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Locale;

/**
 *
 */
public class DateApplication {

    /**
     * LocalDate 当前时间
     */
    private static final LocalDate localDate =LocalDate.now();

    /**
     * LocalDateTime 当前时间
     */
    private static final LocalDateTime localDateTime =LocalDateTime.now();

    /**
     * yyyy-MM-dd 格式
     */
    private static final String localDateString =DateLiuUtil.formatterLocalDateToString(localDate,DateLiuUtil.DEFAULT_PATTERN_DATE);

    /**
     * yyyy-MM-dd HH:mm:ss 格式
     */
    private static final String localDateTimeString =DateLiuUtil.formatterLocalDateTimeToString(localDateTime,DateLiuUtil.DEFAULT_PATTERN_DATETIME);



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
        System.out.println(DateLiuUtil.formatterDateToLocalDateTime(LocalDate.of(2019,10,1),DateLiuUtil.DEFAULT_PATTERN_DATE));

        // 6、  localDateTimeString 格式化日期为日期格式
        System.out.println(DateLiuUtil.formatterStringToLocalDateTime(localDateTimeString,DateLiuUtil.DEFAULT_PATTERN_DATETIME));

        // 7、  localDateString  格式化日期为日期格式
        System.out.println(DateLiuUtil.formatterStringToLocalDate(localDateString,DateLiuUtil.DEFAULT_PATTERN_DATE));

        // 8、  localDateTime 转 localDateTime
        System.out.println(DateLiuUtil.formatterDateTimeToLocalDateTime(LocalDateTime.of(2020,12,25,9,58,16),DateLiuUtil.DEFAULT_PATTERN_DATETIME));

        // 9、  日期转化为固定格式yyyy-MM-dd HH:mm:ss
        System.out.println(DateLiuUtil.getAllFormatterLocalDateTime(LocalDateTime.of(2020,12,25,9,58,16)));





    }
}
