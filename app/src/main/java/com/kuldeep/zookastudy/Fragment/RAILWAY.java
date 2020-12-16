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
import com.kuldeep.zookastudy.SubjectsTab.Biology;
import com.kuldeep.zookastudy.SubjectsTab.Chemistry;
import com.kuldeep.zookastudy.SubjectsTab.ComputerAwareness;
import com.kuldeep.zookastudy.SubjectsTab.CurrentAffair;
import com.kuldeep.zookastudy.SubjectsTab.DailyVocab;
import com.kuldeep.zookastudy.SubjectsTab.Economy;
import com.kuldeep.zookastudy.SubjectsTab.GeneralAwareness;
import com.kuldeep.zookastudy.SubjectsTab.GeneralScience;
import com.kuldeep.zookastudy.SubjectsTab.Geography;
import com.kuldeep.zookastudy.SubjectsTab.History;
import com.kuldeep.zookastudy.SubjectsTab.Home;
import com.kuldeep.zookastudy.SubjectsTab.Physics;
import com.kuldeep.zookastudy.SubjectsTab.Polity;
import com.kuldeep.zookastudy.SubjectsTab.Railway_Article;
import com.kuldeep.zookastudy.SubjectsTab.Railway_Home;
import com.kuldeep.zookastudy.SubjectsTab.Scc_Home;
import com.kuldeep.zookastudy.SubjectsTab.Static_GK;

import java.util.ArrayList;
import java.util.List;

public class RAILWAY extends Fragment {
    private TabLayout tabLayout;
    private ViewPager viewPager;
    private FragmentActivity myContext;
    public RAILWAY() {
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
        View v= inflater.inflate(R.layout.railway, container, false);
        viewPager = (ViewPager)v.findViewById(R.id.viewpager);
        setupViewPager(viewPager);

        tabLayout = (TabLayout)v.findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(viewPager);


        return v;
    }
    private void setupViewPager(ViewPager viewPager) {
        ViewPagerAdapter adapter = new ViewPagerAdapter(getChildFragmentManager());
        adapter.addFragment(new Railway_Home(), "Latest-Update");
        adapter.addFragment(new Railway_Article(), "Articles");
        adapter.addFragment(new CurrentAffair(), "CurrentAffair");
        adapter.addFragment(new DailyVocab(), "DailyVocab");
        adapter.addFragment(new Static_GK(), "Static GK");
        adapter.addFragment(new ComputerAwareness(), "Computer");
        adapter.addFragment(new GeneralAwareness(), "General-Awareness");
        adapter.addFragment(new GeneralScience(), "GeneralScience");
        adapter.addFragment(new Economy(), "Economy");
        adapter.addFragment(new History(), "History");
        adapter.addFragment(new Geography(), "Geography");
        adapter.addFragment(new Polity(), "Polity");
        adapter.addFragment(new Physics(), "Physics");
        adapter.addFragment(new Biology(), "Biology");
        adapter.addFragment(new Chemistry(), "Chemistry");
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