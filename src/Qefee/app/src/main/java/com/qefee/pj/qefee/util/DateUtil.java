package com.qefee.pj.qefee.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;

/**
 * DateUtil.
 * <ul>
 * <li>date: 16/9/27</li>
 * </ul>
 *
 * @author tongjin
 */

public class DateUtil {
    public static DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss", Locale.CHINA);

    public static String dateToString(Date date) {
        return dateFormat.format(date);
    }
}
