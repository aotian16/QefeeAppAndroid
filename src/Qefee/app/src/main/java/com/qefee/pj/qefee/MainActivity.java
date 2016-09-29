package com.qefee.pj.qefee;

import android.os.Bundle;
import android.support.v7.widget.Toolbar;

import com.qefee.pj.qefee.activity.BaseActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar myToolbar = (Toolbar) findViewById(R.id.my_toolbar);
        setSupportActionBar(myToolbar);

        System.out.println("tongjin");
    }
}
