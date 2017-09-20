package com.lsw.jsonparse;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Luosiwei on 2017/7/3.
 */

public class StampToDateUtils {
    /*
     * 将时间戳转换为时间
     */
    public static String stampToDateString(String s) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd HH:mm:ss");
        long lt = new Long(s);
        Date date = new Date(lt);
        res = simpleDateFormat.format(date);
        return res;
    }

    public static String stampToDateLong(Long time) {
        String res;
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date(time);
        res = simpleDateFormat.format(date);
//        StringBuilder stringBuilder = new StringBuilder();
//        stringBuilder.append(res);
//        stringBuilder.append("   " + TimeUtils.getChineseWeek(time));
        return res;
    }
}
