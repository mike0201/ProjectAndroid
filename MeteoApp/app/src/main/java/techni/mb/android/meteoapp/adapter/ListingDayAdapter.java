package techni.mb.android.meteoapp.adapter;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

import techni.mb.android.meteoapp.R;
import techni.mb.android.meteoapp.model.CurrentCondition;
import techni.mb.android.meteoapp.model.Weather;

/**
 * Created by student5310 on 16/03/16.
 */
public class ListingDayAdapter extends BaseAdapter{

    private ArrayList<Weather> allWeather;
    private CurrentCondition currentCondition;

    private LayoutInflater layoutInflater;
    private boolean succeed =false;

    public ListingDayAdapter(Context context) {
        layoutInflater = LayoutInflater.from(context);
        allWeather = new ArrayList<Weather>();
    }


    @Override
    public int getCount() {
        return allWeather.size();
    }


    @Override
    public Object getItem(int position) {

        if (position==0){
            return currentCondition;
        }else{

        return allWeather.get(position) ;
        }
    }


    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if(convertView==null){
            convertView=layoutInflater.inflate(R.layout.row_weather,null);
        }
        CurrentCondition condition = null;
        Weather currentWeather = null;
        Weather weather = null;

       if (succeed==true) {
           if (position == 0) {
               condition = this.currentCondition;
               currentWeather = allWeather.get(position);

// image ne fonctionne pas
               //((ImageView)convertView.findViewById(R.id.icon_weather_row)).setImageBitmap(getBitmapFromURL(condition.getWeatherIconUrl().get(0).getValue()));
               ((TextView) convertView.findViewById(R.id.temp_feel_value)).setText(condition.getFeelsLikeC());
               ((TextView) convertView.findViewById(R.id.temp_value)).setText(condition.getTemp_C());
               ((TextView) convertView.findViewById(R.id.condition_weather_value)).setText(condition.getWeatherDesc().get(0).getValue());
               ((TextView) convertView.findViewById(R.id.chance_100)).setText(currentWeather.getHourly().get(0).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_400)).setText(currentWeather.getHourly().get(1).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_700)).setText(currentWeather.getHourly().get(2).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_1000)).setText(currentWeather.getHourly().get(3).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_1300)).setText(currentWeather.getHourly().get(4).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_1600)).setText(currentWeather.getHourly().get(5).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_1900)).setText(currentWeather.getHourly().get(6).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_2200)).setText(currentWeather.getHourly().get(7).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.date_value)).setText(currentWeather.getDate());
               ((TextView) convertView.findViewById(R.id.moyenne_temp_value)).setText(currentWeather.getMoyenneTemp());


           } else {
               weather = allWeather.get(position);
//image ne fonctionne pas
               //((ImageView)convertView.findViewById(R.id.icon_weather_row)).setImageBitmap(getBitmapFromURL(weather.getHourly().get(0).getWeatherIconUrl().get(0).getValue()));

               ((TextView) convertView.findViewById(R.id.temp_feel_value)).setText(weather.getHourly().get(4).getFeelsLikeC());
               ((TextView) convertView.findViewById(R.id.temp_value)).setText(weather.getHourly().get(4).getTempC());
               ((TextView) convertView.findViewById(R.id.condition_weather_value)).setText(weather.getHourly().get(4).getWeatherDesc().get(0).getValue());
               ((TextView) convertView.findViewById(R.id.chance_100)).setText(weather.getHourly().get(0).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_400)).setText(weather.getHourly().get(1).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_700)).setText(weather.getHourly().get(2).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_1000)).setText(weather.getHourly().get(3).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_1300)).setText(weather.getHourly().get(4).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_1600)).setText(weather.getHourly().get(5).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_1900)).setText(weather.getHourly().get(6).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.chance_2200)).setText(weather.getHourly().get(7).getChanceofrain());
               ((TextView) convertView.findViewById(R.id.date_value)).setText(weather.getDate());
               ((TextView) convertView.findViewById(R.id.moyenne_temp_value)).setText(weather.getMoyenneTemp());
           }
       }



        return convertView;
    }
    // methode pour recuperer image mai marche pas

    /*public static Bitmap getBitmapFromURL(String src) {
        try {
            Log.e("src", src);
            URL url = new URL(src);
            HttpURLConnection connection = (HttpURLConnection) url.openConnection();
            connection.setDoInput(true);
            connection.connect();
            InputStream input = connection.getInputStream();
            Bitmap myBitmap = BitmapFactory.decodeStream(input);
            Log.e("Bitmap","returned");
            return myBitmap;
        } catch (IOException e) {
            e.printStackTrace();
            Log.e("Exception",e.getMessage());
            return null;
        }
    }*/

    public ArrayList<Weather> getAllWeather() {
        return allWeather;
    }

    public void setAllWeather(ArrayList<Weather> allWeather) {
        this.allWeather = allWeather;

    }

    public CurrentCondition getCurrentCondition() {
        return currentCondition;

    }

    public void setCurrentCondition(CurrentCondition currentCondition) {
        this.currentCondition = currentCondition;

    }
    public void change(){
        setSucceed(true);
        notifyDataSetChanged();
    }

    public void setSucceed(boolean succeed) {
        this.succeed = succeed;
    }
}
