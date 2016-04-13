package techni.mb.android.evaluation5.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.LayoutInflater;

import java.util.ArrayList;

import techni.mb.android.evaluation5.fragment.NewsFragment;

/**
 * Created by student5310 on 1/04/16.
 */
public class NewsPagerAdapter extends FragmentPagerAdapter {
    /**
     * Return the Fragment associated with a specified position.
     *
     * @param position
     */

    private ArrayList<NewsFragment> fragments;

    public NewsPagerAdapter(FragmentManager fm) {
        super(fm);
        this.fragments = new ArrayList<>();
    }

    public void refresh(ArrayList<NewsFragment> newsFragments){
        this.fragments.clear();
        this.fragments.addAll(newsFragments);
        this.notifyDataSetChanged();
    }


    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    /**
     * Return the number of views available.
     */
    @Override
    public int getCount() {
        return fragments.size();
    }
}
