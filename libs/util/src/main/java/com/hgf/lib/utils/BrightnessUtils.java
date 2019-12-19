package com.hgf.lib.utils;

import com.hgf.lib.utils.constant.Constants;

import android.content.ContentResolver;
import android.provider.Settings;
import android.support.annotation.IntRange;
import android.support.annotation.NonNull;
import android.view.Window;
import android.view.WindowManager;

/**
 * author   : HuangGuoFeng
 * package  : com.hgf.lib.utils
 * date     : 2019-12-18
 * desc     : 亮度工具类
 */
public final class BrightnessUtils {
    private static final String TAG="BrightnessUtils";

    private BrightnessUtils() {
        throw new UnsupportedOperationException(Constants.INSTANCE_EXCEPTION);
    }

    /**
       *
       * Description: 是否开启自动亮度调节
       *
    */
    public static boolean isAutoBrightnessEnabled() {
        try {
            int mode = Settings.System.getInt(
                    Utils.getApp().getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS_MODE
            );
            return mode == Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC;
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return false;
        }
    }

    /**
       *
       * @param enabled 自动亮度开关
       * Description: 设置自动亮度调节开关
       *
    */
    public static boolean setAutoBrightnessEnabled(final boolean enabled) {
        return Settings.System.putInt(
                Utils.getApp().getContentResolver(),
                Settings.System.SCREEN_BRIGHTNESS_MODE,
                enabled ? Settings.System.SCREEN_BRIGHTNESS_MODE_AUTOMATIC
                        : Settings.System.SCREEN_BRIGHTNESS_MODE_MANUAL
        );
    }

    /**
       *
       * Description: 获取屏幕亮度 范围0~255,需要权限：<uses-permission android:name="android.permission.WRITE_SETTINGS" />
       *
    */
    public static int getBrightness() {
        try {
            return Settings.System.getInt(
                    Utils.getApp().getContentResolver(),
                    Settings.System.SCREEN_BRIGHTNESS
            );
        } catch (Settings.SettingNotFoundException e) {
            e.printStackTrace();
            return 0;
        }
    }

    /**
     *
     * @param brightness 亮度值
     * Description:设置屏幕亮度
     *       需添加权限 <uses-permission android:name="android.permission.WRITE_SETTINGS" /> 并得到授权
     */
    public static boolean setBrightness(@IntRange(from = 0, to = 255) final int brightness) {
        ContentResolver resolver = Utils.getApp().getContentResolver();
        boolean b = Settings.System.putInt(resolver, Settings.System.SCREEN_BRIGHTNESS, brightness);
        resolver.notifyChange(Settings.System.getUriFor("screen_brightness"), null);
        return b;
    }

    /**
     *
     * @param window     窗口
     * @param brightness 亮度值
     * Description:设置窗口亮度
     */
    public static void setWindowBrightness(@NonNull final Window window,
                                           @IntRange(from = 0, to = 255) final int brightness) {
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.screenBrightness = brightness / 255f;
        window.setAttributes(lp);
    }

    /**
     * 获取窗口亮度
     *
     * @param window 窗口
     * @return 屏幕亮度 0-255
     * Description:获取窗口亮度
     */
    public static int getWindowBrightness(final Window window) {
        WindowManager.LayoutParams lp = window.getAttributes();
        float brightness = lp.screenBrightness;
        if (brightness < 0) return getBrightness();
        return (int) (brightness * 255);
    }
}
