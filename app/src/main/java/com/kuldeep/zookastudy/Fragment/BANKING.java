package com.kuldeep.zookastudy.Fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.viewpager.widget.ViewPager;

import com.google.android.material.tabs.TabLayout;
import com.kuldeep.zookastudy.R;
import com.kuldeep.zookastudy.SubjectsTab.Article;
import com.kuldeep.zookastudy.SubjectsTab.Bank_Article;
import com.kuldeep.zookastudy.SubjectsTab.Bank_Home;
import com.kuldeep.zookastudy.SubjectsTab.BankingAwareness;
import com.kuldeep.zookastudy.SubjectsTab.Biology;
import com.kuldeep.zookastudy.SubjectsTab.Chemistry;
import com.kuldeep.zookastudy.SubjectsTab.ComputerAwareness;
import com.kuldeep.zookastudy.SubjectsTab.CurrentAffair;
import com.kuldeep.zookastudy.SubjectsTab.DailyVocab;
import com.kuldeep.zookastudy.SubjectsTab.GeneralAwareness;
import com.kuldeep.zookastudy.SubjectsTab.GeneralScience;
import com.kuldeep.zookastudy.SubjectsTab.Geography;
import com.kuldeep.zookastudy.SubjectsTab.Home;
import com.kuldeep.zookastudy.SubjectsTab.Interview_Bank;
import com.kuldeep.zookastudy.SubjectsTab.Physics;
import com.kuldeep.zookastudy.SubjectsTab.Static_GK;

import java.util.ArrayList;
import java.util.List;

public class BANKING extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentActivity myContext;
    public BANKING() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View v= inflater.inflate(R.layout.banking, container, false);
       viewPager = (ViewPager)v.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        return v;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Bank_Home(), "Latest-Update");
        adapter.addFragment(new Bank_Article(), "Articles");
        adapter.addFragment(new CurrentAffair(), "CurrentAffair");
        adapter.addFragment(new DailyVocab(), "DailyVocab");
        adapter.addFragment(new BankingAwareness(), "Banking-Awareness");
        adapter.addFragment(new ComputerAwareness(), "Computer");
        adapter.addFragment(new GeneralAwareness(),"General-Awareness");
        adapter.addFragment(new Static_GK(), "Static GK");
        adapter.addFragment(new Interview_Bank(), "Interview Quiz");

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

        public void addFragment(Fragment fragment, String title) {
            mFragmentList.add(fragment);
            mFragmentTitleList.add(title);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return mFragmentTitleList.get(position);
        }
    }

}