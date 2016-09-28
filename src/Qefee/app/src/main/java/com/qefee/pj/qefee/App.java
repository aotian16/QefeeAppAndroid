package com.qefee.pj.qefee;

import android.app.Application;

import com.qefee.pj.elog.ELog;
import com.qefee.pj.elog.ELogStrategy;
import com.qefee.pj.qefee.util.BmobUtil;

/**
 * App.
 * <ul>
 * <li>date: 16/9/27</li>
 * </ul>
 *
 * @author tongjin
 */

public class App extends Application {

    /**
     * log tag for App
     */
    private static final String TAG = "App";

    /**
     * Called when the application is starting, before any activity, service,
     * or receiver objects (excluding content providers) have been created.
     * Implementations should be as quick as possible (for example using
     * lazy initialization of state) since the time spent in this function
     * directly impacts the performance of starting the first activity,
     * service, or receiver in a process.
     * If you override this method, be sure to call super.onCreate().
     */
    @Override
    public void onCreate() {
        super.onCreate();
        BmobUtil.init(this);
        BmobUtil.initServerTime();

        ELog.setStrategy(ELogStrategy.ALL);
    }
}
