package com.qefee.pj.qefee.activity.admin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.qefee.pj.qefee.R;
import com.qefee.pj.qefee.activity.base.BaseActivity;
import com.qefee.pj.qefee.bmob.bean.VisibilityBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.UpdateListener;

public class VisibilityDetailActivity extends BaseActivity {
    private Button submitButton;
    private TextView valueTextView;
    private TextView detailTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visibility_detail);
        setupActionBar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        VisibilityBean bean = (VisibilityBean)getIntent().getSerializableExtra("bean");
        submitButton = (Button) findViewById(R.id.submitButton);
        valueTextView = (TextView) findViewById(R.id.valueTextView);
        detailTextView = (TextView) findViewById(R.id.detailTextView);

        valueTextView.setText(bean.getValue());
        detailTextView.setText(bean.getDetail());

        submitButton.setOnClickListener(v -> {
            bean.delete(new UpdateListener() {
                @Override
                public void done(BmobException e) {
                    if (e == null) {
                        i("delete VisibilityBean success.");
                        showToast("delete success");
                    } else {
                        e("delete VisibilityBean fail.", e);
                        showToast("delete fail. error = " + e.getMessage());
                    }
                }
            });
        });
    }

    private void setupActionBar() {
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar ab = getSupportActionBar();

        // Enable the Up button
        if (ab != null) {
            ab.setDisplayHomeAsUpEnabled(true);
        }
    }

}
