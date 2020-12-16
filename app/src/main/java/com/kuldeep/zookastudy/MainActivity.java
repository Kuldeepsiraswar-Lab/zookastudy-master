package com.kuldeep.zookastudy;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kuldeep.zookastudy.Fragment.BANKING;
import com.kuldeep.zookastudy.Fragment.DEFENCE;
import com.kuldeep.zookastudy.Fragment.RAILWAY;
import com.kuldeep.zookastudy.Fragment.SSC;
import com.kuldeep.zookastudy.Fragment.TEACHING;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        viewPager = (NonSwipeableViewPager) findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);
        setupTabIcons();
    }
    private void setupTabIcons() {

        TextView tabOne = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabOne.setText("SSC");
        tabOne.setCompoundDrawablesWithIntrinsicBounds(0,  R.drawable.ic_ssc_selected, 0, 0);
        tabLayout.getTabAt(0).setCustomView(tabOne);

        TextView tabTwo = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabTwo.setText("BANKING");
        tabTwo.setCompoundDrawablesWithIntrinsicBounds(0,  R.drawable.ic_bank_selected, 0, 0);
        tabLayout.getTabAt(1).setCustomView(tabTwo);

        TextView tabThree = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabThree.setText("RAILWAY");
        tabThree.setCompoundDrawablesWithIntrinsicBounds(0,  R.drawable.ic_railway_selected, 0, 0);
        tabLayout.getTabAt(2).setCustomView(tabThree);

        TextView tabfour = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabfour.setText("TEACHING");
        tabfour.setCompoundDrawablesWithIntrinsicBounds(0,  R.drawable.ic_teaching_selected, 0, 0);
        tabLayout.getTabAt(3).setCustomView(tabfour);

        TextView tabfive = (TextView) LayoutInflater.from(this).inflate(R.layout.custom_tab, null);
        tabfive.setText("DEFENCE");
        tabfive.setCompoundDrawablesWithIntrinsicBounds(0,  R.drawable.ic_defence_selected, 0, 0);
        tabLayout.getTabAt(4).setCustomView(tabfive);
    }

    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getSupportFragmentManager());
        adapter.addFrag(new SSC(), "Study");
        adapter.addFrag(new BANKING(), "Result");
        adapter.addFrag(new RAILWAY(), "Tech");
        adapter.addFrag(new TEACHING(), "News");
        adapter.addFrag(new DEFENCE(), "Scheme");
        viewPager.setAdapter(adapter);
    }

    class ViewPagerAdapter extends FragmentPagerAdapter {
        private final List<Fragment> mFragmentList = new ArrayList<>();
        private final List<String> mFragmentTitleList = new ArrayList<>();

        public ViewPagerAdapter(FragmentManager manager) {
            super(manager);
        }

        @Override
        public Fragment getItem(int position) {
            return mFragmentList.get(position);
        }

        @Override
        public int getCount() {
            return mFragmentList.size();
        }

        public void addFrag(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }


}