package com.qefee.pj.qefee.activity.base;

import android.content.Intent;

import com.qefee.pj.ebase.activity.EBaseActivity;

/**
 * BaseActivity.
 * <ul>
 * <li>date: 16/9/29</li>
 * </ul>
 *
 * @author tongjin
 */

public abstract class BaseActivity extends EBaseActivity {
    protected void startActivity(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
    }
}
