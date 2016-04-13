package techni.mb.android.meteoapp.network;

import com.android.volley.Request;
import com.android.volley.VolleyError;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.type.SimpleType;
import com.spothero.volley.JacksonRequest;
import com.spothero.volley.JacksonRequestListener;


import techni.mb.android.meteoapp.model.ContainData;
import techni.mb.android.meteoapp.model.Data;


/**
 * Created by student5310 on 14/03/16.
 */
public class NetworkManager {


    public interface WeatherListener{
        public void onReceived(Data data);
        public void onFailed();
    }

    private static String urlBase = "http://api.worldweatheronline.com/premium/v1/weather.ashx?key=d457a0b60e2646b388a73821161603%20&num_of_days=5&tp=3&format=json&q=";

    public static void getWeather(final WeatherListener listener,String cityName){

        String url = urlBase+cityName;

        JacksonRequest<ContainData> request = new JacksonRequest<ContainData>(Request.Method.GET, url, new JacksonRequestListener<ContainData>() {
            @Override
            public void onResponse(ContainData response, int statusCode, VolleyError error) {
                if (error != null) {
                    if(listener!=null){
                        listener.onFailed();
                    }
                }
                else if (response != null){
                    if (listener!=null){
                        listener.onReceived(response.getData());
                    }
                }
            }

            @Override
            public JavaType getReturnType() {
                return SimpleType.construct(ContainData.class);
            }
        });

        NetworkingApplication.getSharedInstance().getVolleyRequestQueue().add(request);




    }




}
