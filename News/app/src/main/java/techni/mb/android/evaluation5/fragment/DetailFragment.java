package techni.mb.android.evaluation5.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import techni.mb.android.evaluation5.R;
import techni.mb.android.evaluation5.adapter.NewsPagerAdapter;
import techni.mb.android.evaluation5.model.News;

/**
 * A simple {@link Fragment} subclass.
 */
public class DetailFragment extends Fragment {


    private static final String POSITION = "position";
    private static final String NEWES = "newes";
    private ArrayList<News> newes;
    private int position;

    public DetailFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview= inflater.inflate(R.layout.fragment_detail, container, false);

        ArrayList<NewsFragment> newsFragments = new ArrayList<>();

        ArrayList<News>nws = getArguments().getParcelableArrayList(NEWES);

        NewsPagerAdapter adapter = new NewsPagerAdapter(getFragmentManager());
        for (int i =0; i<nws.size();i++){
            newsFragments.add(NewsFragment.newInstance(nws.get(i)));
        }

        adapter.refresh(newsFragments);

        ViewPager viewPager = (ViewPager) rootview.findViewById(R.id.main_view_pager);
        viewPager.setAdapter(adapter);
        viewPager.setCurrentItem(getArguments().getInt(POSITION));



        return rootview;
    }

    public static DetailFragment newInstance(ArrayList<News> newes, int position) {
        DetailFragment fragment = new DetailFragment();
        fragment.newes = newes;
        fragment.position = position;

        Bundle args = new Bundle();
        args.putInt(POSITION,position);
        args.putParcelableArrayList(NEWES,newes);
        fragment.setArguments(args);
        return fragment;

    }



}
