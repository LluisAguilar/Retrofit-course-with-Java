package com.luis.curso.retrofit.ockham.cursoretrofit.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.luis.curso.retrofit.ockham.cursoretrofit.fragments.AnimeFragment;
import com.luis.curso.retrofit.ockham.cursoretrofit.fragments.MangaFragment;

import java.util.List;

public class FragmentViewPagerAdapter extends FragmentStateAdapter {

    private List<Fragment> mFragmentList;

    public FragmentViewPagerAdapter(@NonNull List<Fragment> mFragmentList, @NonNull FragmentActivity fragmentActivity) {
        super(fragmentActivity);
        this.mFragmentList = mFragmentList;
    }

    @NonNull
    @Override
    public Fragment createFragment(int position) {
        Fragment frag = AnimeFragment.getInstance();

        switch (position) {

            case 0: {
                frag = AnimeFragment.getInstance();
                break;
            }

            case 1: {
                frag = MangaFragment.getInstance();
                break;
            }
        }

        return frag;
    }

    @Override
    public int getItemCount() {
        return mFragmentList.size();
    }
}
