package techni.mb.android.evaluation5.adapter;

import android.view.View;
import android.widget.TextView;

import techni.mb.android.evaluation5.ClickableViewHolder;
import techni.mb.android.evaluation5.R;
import techni.mb.android.evaluation5.model.News;

/**
 * Created by student5310 on 1/04/16.
 */
public class NewsHandler extends ClickableViewHolder {

    private News news;

    private TextView titleTV;

    public NewsHandler(View itemView) {
        super(itemView);


        titleTV =(TextView) itemView.findViewById(R.id.title_news_row);

        itemView.setOnClickListener(this);

    }
    public void setNews(News news){
        this.news = news;

        titleTV.setText(news.getTitle());

    }
}
