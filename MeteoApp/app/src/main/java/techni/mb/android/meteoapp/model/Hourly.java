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

public class Hourly {

    private String time;
    private String chanceofrain;
    private String tempC;
    private ArrayList<WeatherIconUrl> weatherIconUrl;
    private ArrayList<WeatherDesc> weatherDesc;
    @JsonProperty("FeelsLikeC")
    private String feelsLikeC;

    public Hourly() {
    }



    public String getChanceofrain() {
        return chanceofrain+"%";
    }

    public void setChanceofrain(String chanceofrain) {
        this.chanceofrain = chanceofrain;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
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

    public String getFeelsLikeC() {
        return feelsLikeC+"°c";
    }

    public void setFeelsLikeC(String feelsLikeC) {
        this.feelsLikeC = feelsLikeC;
    }

    public String getTempC() {
        return tempC+"°c";
    }

    public void setTempC(String tempC) {
        this.tempC = tempC;
    }
}
