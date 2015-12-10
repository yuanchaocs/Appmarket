package com.androidy.app.lib.utils;

import android.content.Context;
import android.widget.Toast;

public class ToastUtil {
    private static Toast toast;

    public static void show(Context context, String text, int duration) {
        if (toast == null) {
            toast = Toast.makeText(context, "", 0);
        }
        toast.setText(text);
        toast.setDuration(duration);
        toast.show();
    }
}
