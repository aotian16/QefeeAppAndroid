package com.qefee.pj.qefee.activity.admin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.qefee.pj.qefee.R;
import com.qefee.pj.qefee.activity.base.BaseActivity;
import com.qefee.pj.qefee.bmob.bean.CatalogueBean;

import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.SaveListener;

public class AddCatalogueActivity extends BaseActivity {

    private EditText valueEditText;
    private EditText detailEditText;
    private Button submitButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_catalogue);
        setupActionBar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        valueEditText = (EditText) findViewById(R.id.valueEditText);
        detailEditText = (EditText) findViewById(R.id.detailEditText);
        submitButton = (Button) findViewById(R.id.submitButton);

        submitButton.setOnClickListener(v -> {
            String value = valueEditText.getText().toString();
            String detail = detailEditText.getText().toString();

            if (TextUtils.isEmpty(value)) {
                showToast("value can not be empty.");
                return;
            }

            if (TextUtils.isEmpty(detail)) {
                showToast("detail can not be empty.");
                return;
            }

            CatalogueBean bean = new CatalogueBean();
            bean.setValue(value);
            bean.setDetail(detail);
            bean.save(new SaveListener<String>() {
                @Override
                public void done(String s, BmobException e) {
                    if (e == null) {
                        i("add CatalogueBean success. objectId = " + s);
                        showToast("add success");
                    } else {
                        e("add CatalogueBean fail.", e);
                        showToast("add fail. error = " + e.getMessage());
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
