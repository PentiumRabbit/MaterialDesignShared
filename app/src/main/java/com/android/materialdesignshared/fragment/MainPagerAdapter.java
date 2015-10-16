package com.android.materialdesignshared.fragment;

import android.content.Context;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.android.materialdesignshared.fragment.ListFragment;

public class MainPagerAdapter extends FragmentPagerAdapter {

    public static final int NUM_ITEMS = 3;
    public static final int ALL_POS = 0;
    public static final int SHARED_POS = 1;
    public static final int FAVORITES_POS = 2;

    private Context context;

    public MainPagerAdapter(Context context, FragmentManager fm) {
        super(fm);
        this.context = context;
    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case ALL_POS:
                return ListFragment.newInstance("fragment", "第1个");
            case SHARED_POS:
                return ListFragment.newInstance("fragment", "第2个");
            case FAVORITES_POS:
                return ListFragment.newInstance("fragment", "第3个");
            default:
                return null;
        }
    }

    @Override
    public CharSequence getPageTitle(int position) {
        switch (position) {
            case ALL_POS:
                return "第1个";
            case SHARED_POS:
                return "第2个";
            case FAVORITES_POS:
                return "第3个";
            default:
                return "";
        }
    }

    @Override
    public int getCount() {
        return NUM_ITEMS;
    }
}
