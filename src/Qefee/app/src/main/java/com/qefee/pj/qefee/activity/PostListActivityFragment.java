package com.qefee.pj.qefee.activity;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.qefee.pj.qefee.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class PostListActivityFragment extends Fragment {

    public PostListActivityFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_post_list, container, false);
    }
}
