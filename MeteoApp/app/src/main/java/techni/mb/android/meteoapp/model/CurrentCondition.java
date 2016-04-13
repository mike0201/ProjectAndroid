package techni.mb.android.meteoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by student5310 on 16/03/16.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class CurrentCondition {

    private String temp_C;
    private ArrayList<WeatherIconUrl> weatherIconUrl;
    private ArrayList<WeatherDesc> weatherDesc;
    @JsonProperty("FeelsLikeC")
    private String feelsLikeC;

    public CurrentCondition() {
    }



    public String getFeelsLikeC() {
        return feelsLikeC;
    }

    public void setFeelsLikeC(String feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }

    public String getTemp_C() {
        return temp_C;
    }

    public void setTemp_C(String temp_C) {
        this.temp_C = temp_C;
    }

    public ArrayList<WeatherDesc> getWeatherDesc() {
        return weatherDesc;
    }

    public void setWeatherDesc(ArrayList<WeatherDesc> weatherDesc) {
        this.weatherDesc = weatherDesc;
    }

    public ArrayList<WeatherIconUrl> getWeatherIconUrl() {
        return weatherIconUrl;
    }

    public void setWeatherIconUrl(ArrayList<WeatherIconUrl> weatherIconUrl) {
        this.weatherIconUrl = weatherIconUrl;
    }
}
