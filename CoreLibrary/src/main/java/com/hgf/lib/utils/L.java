package com.hgf.lib.utils;

import android.text.TextUtils;
import android.util.Log;

import com.hgf.lib.Constants;

/**
 * <pre>
 *     author   : HuangGuoFeng
 *     package  : com.hgf.lib.utils
 *     date     : 2019-12-17
 *     desc     :
 * </pre>
 */
public class L {
    private static boolean DEBUG=false;
    private static boolean SET=false;
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

    public static void v(String tag,String s){
        p(V,tag,s);
    }
    public static void d(String tag,String s){
        p(D,tag,s);
    }
    public static void i(String tag,String s){
        p(I,tag,s);
    }
    public static void w(String tag,String s){
        p(W,tag,s);
    }
    public static void e(String tag,String s){
        p(E,tag,s);
    }

    private static void p(int type,String tag,String s){
        if(!DEBUG){
            return;
        }
        String t=null;
        if(TextUtils.isEmpty(tag)){
            t=Constants.LOG_TAG;
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
}
