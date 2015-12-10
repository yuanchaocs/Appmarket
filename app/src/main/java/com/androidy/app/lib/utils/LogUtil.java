package com.androidy.app.lib.utils;

import android.util.Log;

/**
 * 日志工具
 *
 * @author yuanc
 * @todo 项目内所有debug日志输出都用此类来操作[方便后期日志开关的管理]
 */
public class LogUtil {

    /**
     * DEBUG日志信息开关
     */
    private static boolean isDebug = true;
    /**
     * ERRO日志信息开关
     */
    private static boolean isErro = true;

    public static void d(String tag, String msg) {
        if (isDebug) {
            Log.d(tag, msg);
        }
    }

    public static void e(String tag, String msg, Throwable tr) {
        if (isErro) {
            Log.e(tag, msg, tr);
        }
    }
}
