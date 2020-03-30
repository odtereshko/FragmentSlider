package com.example.nestedfragment.ui.home;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.viewpager.widget.ViewPager;

import com.example.nestedfragment.R;

public class HomeFragment extends Fragment {
    private HomeViewModel homeViewModel;
    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        return root;
    }
    // This event is triggered soon after onCreateView().
    // onViewCreated() is only called if the view returned from onCreateView() is non-null.
    // Any view setup should occur here.  E.g., view lookups and attaching view listeners.
    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {

        ViewPager mViewPager = (ViewPager) view.findViewById(R.id.viewpager);
        mViewPager.setAdapter(new MyAdapter(getChildFragmentManager()));
    }

public static class MyAdapter extends FragmentPagerAdapter {

    MyAdapter(@NonNull FragmentManager fm) {
        super(fm);
    }

    @Override
    public int getCount() { //возвращает количество страниц
        return 3;
    }

    @NonNull
    @Override
    public Fragment getItem(int position) { //по номеру страницы возворащается объект
        switch (position) {
            case 0:
                return new FragmentVP1();
            case 1:
                return new FragmentVP2();
            case 2:
                return new FragmentVP3();

            default:
                return new FragmentVP1();
        }
    }
}
}
