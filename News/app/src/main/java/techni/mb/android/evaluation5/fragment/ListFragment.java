package techni.mb.android.evaluation5.fragment;


import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import techni.mb.android.evaluation5.ClickableRecyclerViewAdapter;
import techni.mb.android.evaluation5.DetailNewsActivity;
import techni.mb.android.evaluation5.R;
import techni.mb.android.evaluation5.adapter.NewsAdapter;
import techni.mb.android.evaluation5.model.ModelGenerator;
import techni.mb.android.evaluation5.model.News;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListFragment extends Fragment implements ClickableRecyclerViewAdapter.ClickableRecyclerViewAdapterListener {

    public static final String A_LA_UNE = "a_la_une";
    public static final String LIFESTYLE = "lifestyle";
    private static final String TYPE_LIST = "type_list";
    private String type;
    private NewsAdapter adapter;
    private ArrayList<News> newes;



    public static ListFragment newInstance(String constante){
        ListFragment fragment = new ListFragment();
        fragment.type = constante;

        Bundle args = new Bundle();
        args.putString(TYPE_LIST, constante);
        fragment.setArguments(args);
        return fragment;
    }

    public ListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootview = inflater.inflate(R.layout.fragment_list, container, false);

        // LinearLayoutManager
        LinearLayoutManager linearLayoutManager =
                new LinearLayoutManager(getContext());
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);


        RecyclerView mainRecycleView = (RecyclerView) rootview.findViewById(R.id.main_recycle_view);

        mainRecycleView.setLayoutManager(linearLayoutManager);

        adapter = new NewsAdapter(getContext());

        ModelGenerator modelGenerator = new ModelGenerator();
        String type =getArguments().getString(TYPE_LIST);

        switch (type){
            case A_LA_UNE:
                ModelGenerator.retrieveTopNews(new ModelGenerator.NewsListener() {
                    @Override
                    public void onReceiveNews(List<News> newsList) {
                        newes = new ArrayList<News>(newsList);
                    }
                });
                break;
            case LIFESTYLE:
                ModelGenerator.retrieveLifeStyleNews(new ModelGenerator.NewsListener() {
                    @Override
                    public void onReceiveNews(List<News> newsList) {
                        newes = new ArrayList<News>(newsList);
                    }
                });
                break;
            default:
                break;
        }
        adapter.refresh(newes);
        adapter.setListener(this);
        mainRecycleView.setAdapter(adapter);



        return rootview;
    }

    @Override
    public void onClick(int position) {


        Intent intent = new Intent(getActivity(), DetailNewsActivity.class);
        intent.putExtra(DetailNewsActivity.POSITION,position);
        intent.putExtra(DetailNewsActivity.NEWES,newes);
        startActivity(intent);

    }
}
