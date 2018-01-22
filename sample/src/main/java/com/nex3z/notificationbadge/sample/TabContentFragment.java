package com.nex3z.notificationbadge.sample;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class TabContentFragment extends Fragment {

    public TabContentFragment() {}

    public static TabContentFragment newInstance() {
        return new TabContentFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_tab_content, container, false);
    }

}

