package com.qefee.pj.qefee.activity.admin;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;

import com.qefee.pj.qefee.R;
import com.qefee.pj.qefee.activity.base.BaseActivity;

public class AdminMenuActivity extends BaseActivity {

    private Button contentTypeListActivityButton;
    private Button tagListActivityButton;
    private Button visibilityListActivityButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_admin_menu);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        contentTypeListActivityButton = (Button) findViewById(R.id.contentTypeListActivityButton);
        tagListActivityButton = (Button) findViewById(R.id.tagListActivityButton);
        visibilityListActivityButton = (Button) findViewById(R.id.visibilityListActivityButton);

        contentTypeListActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(AdminMenuActivity.this, ContentTypeListActivity.class);
            startActivity(intent);
        });

        tagListActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(AdminMenuActivity.this, TagListActivity.class);
            startActivity(intent);
        });

        visibilityListActivityButton.setOnClickListener(v -> {
            Intent intent = new Intent(AdminMenuActivity.this, VisibilityListActivity.class);
            startActivity(intent);
        });
    }

}
