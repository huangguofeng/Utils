package com.hgf.lib.utils;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;

import com.hgf.lib.utils.constant.Constants;

/**
 * <pre>
 *     author   : HuangGuoFeng
 *     package  : com.hgf.lib.utils
 *     date     : 2019-12-17
 *     desc     : 日志工具类
 * </pre>
 */
public class L {
    private static boolean DEBUG=false;// 日志开关
    private static boolean ERROR_COLLECT=false;// 错误信息收集开关
    private static boolean SET=false;// 日志开关只允许设置一次
    private static final int V=0;
    private static final int D=1;
    private static final int I=2;
    private static final int W=3;
    private static final int E=4;

    /**
       *
       * @param debug tun or off
       * @Description set debug
       *
    */
    public void debug(boolean debug){
        if(SET){
            return;
        }
        DEBUG=debug;
        SET=true;
    }

    public static void v(String s){
        v(null,s,false);
    }
    public static void v(String s,boolean flag){
        v(null,s,flag);
    }
    public static void v(String tag,String s){
        v(tag,s,false);
    }
    public static void v(String tag,String s,boolean flag){
        p(V,tag,s,flag);
    }
    public static void d(String s){
        d(null,s,false);
    }
    public static void d(String s,boolean flag){
        d(null,s,flag);
    }
    public static void d(String tag,String s){
        d(tag,s,false);
    }
    public static void d(String tag,String s,boolean flag){
        p(D,tag,s,flag);
    }
    public static void i(String s){
        i(null,s,false);
    }
    public static void i(String s,boolean flag){
        i(null,s,flag);
    }
    public static void i(String tag,String s){
        i(tag,s,false);
    }
    public static void i(String tag,String s,boolean flag){
        p(I,tag,s,flag);
    }
    public static void w(String s){
        w(null,s,false);
    }
    public static void w(String s,boolean flag){
        w(null,s,flag);
    }
    public static void w(String tag,String s){
        w(tag,s,false);
    }
    public static void w(String tag,String s,boolean flag){
        p(W,tag,s,flag);
    }
    public static void e(String s){
        e(null,s,false);
    }
    public static void e(String s,boolean flag){
        e(null,s,flag);
    }
    public static void e(String tag,String s){
        e(tag,s,false);
    }
    public static void e(String tag,String s,boolean flag){
        p(E,tag,s,flag);
    }
    /**
       *
       * @param type 日志级别
       * @param tag  日志tag
       * @param s    日志打印字符串
       * @param flag 日志强制打印无视日志开关
       * Description:日志打印操作
       *
    */
    private static void p(int type,String tag,String s,boolean flag){
        if(!flag){
            if(!DEBUG){
                return;
            }
        }

        String t=null;
        if(TextUtils.isEmpty(tag)){
            t= Constants.DEFAULT_LOG_TAG;
        }
        switch (type){
            case V:
                Log.v(t,s+"");
                break;
            case D:
                Log.d(t,s+"");
                break;
            case I:
                Log.i(t,s+"");
                break;
            case W:
                Log.w(t,s+"");
                break;
            case E:
                Log.e(t,s+"");
                break;
                default: break;
        }
    }
    /**
       *
       * @param msg 错误信息
       * Description: 收集错误信息
       *
    */
    public void collectErrorInfo(Context context,String msg){
        if (ERROR_COLLECT) {

        }
    }
}
