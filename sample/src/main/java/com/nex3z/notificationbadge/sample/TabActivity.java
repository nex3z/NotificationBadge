package com.nex3z.notificationbadge.sample;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.nex3z.notificationbadge.NotificationBadge;

public class TabActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab);
        initView();
    }

    private void initView() {
        ViewPager pager = findViewById(R.id.view_pager);
        TabLayout tableLayout = findViewById(R.id.tab_layout);
        pager.setAdapter(new SectionPagerAdapter(getSupportFragmentManager()));
        tableLayout.setupWithViewPager(pager);

        for (int i = 0; i < tableLayout.getTabCount(); i++) {
            TabLayout.Tab tab = tableLayout.getTabAt(i);
            if (tab != null) {
                tab.setCustomView(buildCustomTabButton("Tab " + String.valueOf(i)));
            }
        }
    }

    private View buildCustomTabButton(String name) {
        View view = LayoutInflater.from(this).inflate(R.layout.view_tab_button, null);
        TextView title = view.findViewById(R.id.tab_title);
        title.setText(name);
        NotificationBadge badge = view.findViewById(R.id.badge);
        badge.setNumber(1);
        return view;
    }

    private class SectionPagerAdapter extends FragmentPagerAdapter {
        private static final int PAGE_COUNT = 3;

        SectionPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override @NonNull
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                case 1:
                case 2:
                default:
                    return TabContentFragment.newInstance();
            }
        }

        @Override
        public int getCount() {
            return PAGE_COUNT;
        }
    }
}
