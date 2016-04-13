package techni.mb.android.evaluation5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;

import techni.mb.android.evaluation5.ClickableRecyclerViewAdapter;
import techni.mb.android.evaluation5.R;
import techni.mb.android.evaluation5.model.News;

/**
 * Created by student5310 on 1/04/16.
 */
public class NewsAdapter extends ClickableRecyclerViewAdapter<NewsHandler> {

    private ArrayList<News> newses;
    private LayoutInflater layoutInflater;

    public NewsAdapter(Context context) {
        this.layoutInflater=LayoutInflater.from(context);
        this.newses = new ArrayList<>();
    }
    public void refresh(ArrayList<News> newses1){
        this.newses.clear();
        this.newses.addAll(newses1);
        this.notifyDataSetChanged();
    }

    @Override
    public void bindCurrentViewHolder(NewsHandler holder, int position) {
        News news = newses.get(position);
        holder.setNews(news);
    }

    @Override
    public NewsHandler instantiateViewHolder(ViewGroup parent, int viewType) {
        View rowView = layoutInflater.inflate(R.layout.news_row,null);

        NewsHandler newsHandler = new NewsHandler(rowView);
        newsHandler.setListener(this);
        return newsHandler;
    }

    /**
     * Returns the total number of items in the data set hold by the adapter.
     *
     * @return The total number of items in this adapter.
     */
    @Override
    public int getItemCount() {
        return newses.size();
    }
}
