package techni.mb.android.evaluation5.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.NetworkImageView;

import techni.mb.android.evaluation5.R;
import techni.mb.android.evaluation5.model.News;
import techni.mb.android.evaluation5.network.NetworkingApplication;

/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends Fragment {


    private static final String NEWS = "news";
    private News news;
    private TextView titleTV;
    private TextView descriptionTV;
    private NetworkImageView imageView;

    public NewsFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootView = inflater.inflate(R.layout.fragment_news, container, false);

        titleTV = (TextView) rootView.findViewById(R.id.title_news_fragment);
        descriptionTV = (TextView) rootView.findViewById(R.id.description_news_fragment);
        imageView = (NetworkImageView) rootView.findViewById(R.id.imageView_news_fragment);

        News nws = getArguments().getParcelable(NEWS);
        titleTV.setText(nws.getTitle());
        descriptionTV.setText(nws.getText());
        imageView.setImageUrl(nws.getUrlImage(), NetworkingApplication.getSharedInstance().getVolleyImageLoader());


        return rootView;
    }

    public static NewsFragment newInstance(News news) {
        NewsFragment fragment = new NewsFragment();
        fragment.news = news;
        Bundle args = new Bundle();
        args.putParcelable(NEWS,news);
        fragment.setArguments(args);
        return fragment;



    }
}
