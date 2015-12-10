package com.androidy.app.lib.utils;

import java.sql.Date;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;

import android.content.Context;
import android.view.WindowManager;

public class PublicUtils {
    private static WindowManager wm;

    public static int screenWidth(Context context) {
        if (wm == null) {
            wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        }
        return wm.getDefaultDisplay().getWidth();
    }

    public static int screenHeight(Context context) {
        if (wm == null) {
            wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        }
        return wm.getDefaultDisplay().getHeight();
    }

    private static DecimalFormat df;
    private static StringBuilder mstrbuf;
    private static final String STR_EMPTY = "";

    /**
     * 获取指定文件大小的字符串单位B? KB? MB? GB?
     *
     * @param filesize 文件大小(byte)
     * @return 文件大小的字符串单位B? KB? MB? GB?
     */
    public static String formatSize(long filesize) {
        if (filesize < 0) {
            return "0 B";
        }
        if (df == null) {
            df = new DecimalFormat("#.00");
        }
        if (mstrbuf == null) {
            mstrbuf = new StringBuilder();
        }
        mstrbuf.replace(0, mstrbuf.length(), STR_EMPTY);
        if (filesize < 1024) {
            mstrbuf.append(filesize);
            mstrbuf.append(" B");
        } else if (filesize < 1048576) {
            mstrbuf.append(df.format((double) filesize / 1024));
            mstrbuf.append(" K");
        } else if (filesize < 1073741824) {
            mstrbuf.append(df.format((double) filesize / 1048576));
            mstrbuf.append(" M");
        } else {
            mstrbuf.append(df.format((double) filesize / 1073741824));
            mstrbuf.append(" G");
        }
        return mstrbuf.toString();
    }

    private static Date date;
    private static SimpleDateFormat format;

    public static String formatDate(long time) {
        if (format == null) {
            format = new SimpleDateFormat("yyyy-MM-dd");
        }
        if (date == null) {
            date = new Date(0);
        }
        date.setTime(time);
        return format.format(date);
    }
}
