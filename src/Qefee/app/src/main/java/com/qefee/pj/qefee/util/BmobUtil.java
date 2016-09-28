package com.qefee.pj.qefee.util;

import android.content.Context;

import com.qefee.pj.elog.ELog;
import com.qefee.pj.qefee.secret.BmobSecret;

import java.util.Date;

import cn.bmob.v3.Bmob;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.QueryListener;

/**
 * BmobUtil.
 * <ul>
 * <li>date: 16/9/27</li>
 * </ul>
 *
 * @author tongjin
 */

public class BmobUtil {

    private static long serverTime = -1;

    /**
     * init bmob.
     * @param context context
     */
    public static void init(Context context) {
        //提供以下两种方式进行初始化操作：

        //第一：默认初始化
        Bmob.initialize(context, BmobSecret.APP_KEY);

        //第二：自v3.4.7版本开始,设置BmobConfig,允许设置请求超时时间、文件分片上传时每片的大小、文件的过期时间(单位为秒)，
        //BmobConfig config =new BmobConfig.Builder(this)
        ////设置appkey
        //.setApplicationId("Your Application ID")
        ////请求超时时间（单位为秒）：默认15s
        //.setConnectTimeout(30)
        ////文件分片上传时每片的大小（单位字节），默认512*1024
        //.setUploadBlockSize(1024*1024)
        ////文件的过期时间(单位为秒)：默认1800s
        //.setFileExpiration(2500)
        //.build();
        //Bmob.initialize(config);
    }

    public static long getServerTime() {
        return serverTime;
    }

    public static void initServerTime() {
        Bmob.getServerTime(new QueryListener<Long>() {
            @Override
            public void done(Long aLong, BmobException e) {
                if(e==null){

                    serverTime = aLong;

                    String times = DateUtil.dateToString(new Date(aLong * 1000L));
                    ELog.i("bmob","当前服务器时间为:" + times);
                }else{
                    ELog.i("bmob","获取服务器时间失败:" + e.getMessage());
                }
            }
        });
    }
}
