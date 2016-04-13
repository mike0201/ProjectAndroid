package techni.mb.android.meteoapp.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import techni.mb.android.meteoapp.R;
import techni.mb.android.meteoapp.adapter.ListingDayAdapter;
import techni.mb.android.meteoapp.model.Data;
import techni.mb.android.meteoapp.network.NetworkManager;

public class ResultActivity extends AppCompatActivity {

    public static String CITY_NAME ="city_name";
    private ListingDayAdapter adpater;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        String cityname = getIntent().getStringExtra(CITY_NAME);

        adpater = new ListingDayAdapter(getApplicationContext());


        NetworkManager.getWeather(new NetworkManager.WeatherListener() {
            @Override
            public void onReceived(Data data) {
                adpater.setCurrentCondition(data.getCurrent_condition().get(0));
                adpater.setAllWeather(data.getWeather());
                adpater.change();

            }

            @Override
            public void onFailed() {

            }
        },cityname);

        ((ListView)findViewById(R.id.list_weather_listview)).setAdapter(adpater);



    }
}
