package com.qefee.pj.qefee.activity.admin;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import com.qefee.pj.qefee.R;
import com.qefee.pj.qefee.activity.base.BaseActivity;
import com.qefee.pj.qefee.bmob.bean.base.ContentTypeBean;

import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class ContentTypeListActivity extends BaseActivity {

    List<ContentTypeBean> contentTypeBeanList;
    ArrayAdapter<ContentTypeBean> contentTypeBeanArrayAdapter;
    private ListView contentTypeList;
    private Button addButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content_type_list);
        setupActionBar();

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        addButton = (Button) findViewById(R.id.addButton);
        contentTypeList = (ListView) findViewById(R.id.contentTypeList);

        addButton.setOnClickListener(v -> {

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

    @Override
    protected void onResume() {
        super.onResume();

        BmobQuery<ContentTypeBean> query = new BmobQuery<>();
        query.findObjects(new FindListener<ContentTypeBean>() {
            @Override
            public void done(List<ContentTypeBean> list, BmobException e) {
                if (e == null) {
                    i("query success. size = " + list.size());

                    contentTypeBeanList = list;

                    int resID = R.layout.item_content_type;
                    contentTypeBeanArrayAdapter = new ArrayAdapter<>(ContentTypeListActivity.this, resID, list);

                    contentTypeList.setAdapter(contentTypeBeanArrayAdapter);
                } else {
                    e("query fail.", e);
                }
            }
        });
    }
}
