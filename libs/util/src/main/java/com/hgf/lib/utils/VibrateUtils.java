package com.hgf.lib.utils;

import android.content.Context;
import android.os.Vibrator;
import android.support.annotation.RequiresPermission;

import com.hgf.lib.utils.constant.Constants;

import static android.Manifest.permission.VIBRATE;

/**
 * author   : HuangGuoFeng
 * package  : com.hgf.lib.utils
 * date     : 2019-12-18
 * desc     : 安卓震动器工具
 */
public final class VibrateUtils {

    private static Vibrator vibrator;

    private VibrateUtils() {
        throw new UnsupportedOperationException(Constants.INSTANCE_EXCEPTION);
    }

    /**
       *
       * @param  milliseconds 震动时间
       * Description: 设置震动的时间
       *
    */
    @RequiresPermission(VIBRATE)
    public static void vibrate(final long milliseconds) {
        Vibrator vibrator = getVibrator();
        if (vibrator == null) return;
        vibrator.vibrate(milliseconds);
    }

    /**
       *
       * @param pattern 震动模式 new int{arg1,arg2,arg3,arg4}
     *                arg1:打开振动器前的等待时间长 单位毫秒
     *                arg2:关闭之前保持震动器处于开启状态的时间长
     *                arg3,arg4:多长时间内交替
       * @param repeat 重复次数
     *               -1：震动一次
     *                0：一直震动
       * Description:
       *
    */
    @RequiresPermission(VIBRATE)
    public static void vibrate(final long[] pattern, final int repeat) {
        Vibrator vibrator = getVibrator();
        if (vibrator == null) return;
        vibrator.vibrate(pattern, repeat);
    }

    /**
       *
       * Description:关闭振动器
       *
    */
    @RequiresPermission(VIBRATE)
    public static void cancel() {
        Vibrator vibrator = getVibrator();
        if (vibrator == null) return;
        vibrator.cancel();
    }

    /**
       *
       * Description:获取振动器服务
       *
    */
    private static Vibrator getVibrator() {

        if (vibrator == null) {
            vibrator = (Vibrator) Utils.getApp().getSystemService(Context.VIBRATOR_SERVICE);
        }
        return vibrator.hasVibrator()?vibrator:null;
    }
}
