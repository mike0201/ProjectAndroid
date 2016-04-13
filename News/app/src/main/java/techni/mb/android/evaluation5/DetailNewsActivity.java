package techni.mb.android.evaluation5;

import android.os.Parcelable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import java.util.ArrayList;

import techni.mb.android.evaluation5.fragment.DetailFragment;
import techni.mb.android.evaluation5.model.News;

public class DetailNewsActivity extends AppCompatActivity {


    public static final String POSITION = "position";
    public static final String NEWES = "newes";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_news);

        int position = getIntent().getIntExtra(POSITION,0);
        ArrayList<News> newes = getIntent().getParcelableArrayListExtra(NEWES);


        DetailFragment detailFragment = DetailFragment.newInstance(newes,position);

        getSupportFragmentManager().beginTransaction().add(R.id.main_detail_news_activity_container,detailFragment).commit();


    }
}
