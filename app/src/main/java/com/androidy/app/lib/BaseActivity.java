package com.androidy.app.lib;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.androidy.app.lib.utils.LogUtil;

/**
 * BaseActivity.java
 * User: yuanchao(yuanchaocs@163.com)
 * Date: 2015-12-10
 * Time: 14:52
 * TODO:
 * FIXME:
 */
public abstract class BaseActivity extends AppCompatActivity {
    /**
     * 上个组件传入的数据
     */
    protected abstract void preComponentData(Bundle extra);

    // 生命周期日志管理------------------------------------------------
    private static final String TAG = "BaseActivity";

    @Override
    protected void onCreate(Bundle arg0) {
        super.onCreate(arg0);
        LogUtil.d(TAG, getClass().getSimpleName() + " onCreate");
        preComponentData(getIntent().getExtras());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtil.d(TAG, getClass().getSimpleName() + " onDestroy");
        System.gc();
    }

    public void openActivity(Class<?> cls, Bundle extras) {
        Intent intent = new Intent(this, cls);
        intent.putExtras(extras);
        startActivity(intent);
    }

    public void openActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }

    public void openSingleActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        startActivity(intent);
    }

    public void openSingleActivity(Class<?> cls, Bundle extras) {
        Intent intent = new Intent(this, cls);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK);
        intent.putExtras(extras);
        startActivity(intent);
    }
}