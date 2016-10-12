package com.qefee.pj.qefee.activity.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.ActionBar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.qefee.pj.qefee.R;
import com.qefee.pj.qefee.activity.base.BaseActivity;
import com.qefee.pj.qefee.bmob.bean.VisibilityBean;
import com.victor.loading.rotate.RotateLoading;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;

public class VisibilityListActivity extends BaseActivity {

    private static final String BEAN_VALUE_KEY = "BEAN_VALUE_KEY";
    private static final String BEAN_DETAIL_KEY = "BEAN_DETAIL_KEY";

    List<VisibilityBean> visibilityBeanList;
    SimpleAdapter visibilityBeanArrayAdapter;
    private ListView visibilityList;
    private Button addButton;
    RotateLoading rotateLoadingView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_visibility_list);
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
        visibilityList = (ListView) findViewById(R.id.visibilityList);
        rotateLoadingView = (RotateLoading) findViewById(R.id.rotateLoadingView);

        addButton.setOnClickListener(v -> {
            Intent intent = new Intent(VisibilityListActivity.this, AddVisibilityActivity.class);
            startActivity(intent);
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

        requestVisibilityBeanList();
    }

    private void requestVisibilityBeanList() {
        rotateLoadingView.start();
        BmobQuery<VisibilityBean> query = new BmobQuery<>();
        query.findObjects(new FindListener<VisibilityBean>() {
            @Override
            public void done(List<VisibilityBean> list, BmobException e) {
                rotateLoadingView.stop();
                if (e == null) {
                    i("query success. size = " + list.size());

                    visibilityBeanList = list;

                    ArrayList<HashMap<String, Object>> listItem = new ArrayList<>();
                    for (VisibilityBean b : list) {
                        HashMap<String, Object> map = new HashMap<>();
                        map.put(BEAN_VALUE_KEY, b.getValue());
                        map.put(BEAN_DETAIL_KEY, b.getDetail());
                        listItem.add(map);
                    }


                    int resID = R.layout.item_visibility;
                    String[] from = {
                            BEAN_VALUE_KEY,
                            BEAN_DETAIL_KEY
                    };
                    int[] to = {
                            R.id.valueTextView,
                            R.id.detailTextView
                    };
                    visibilityBeanArrayAdapter = new SimpleAdapter(
                            VisibilityListActivity.this,
                            listItem,
                            resID,
                            from,
                            to
                    );

                    visibilityList.setAdapter(visibilityBeanArrayAdapter);
                    visibilityList.setOnItemClickListener((parent, view, position, id) -> {
                        VisibilityBean itemBean = list.get(position);
                        Intent intent = new Intent(VisibilityListActivity.this, ContentTypeDetailActivity.class);
                        intent.putExtra("bean", itemBean);
                        startActivity(intent);
                    });
                } else {
                    e("query fail.", e);
                }
            }
        });
    }

}
