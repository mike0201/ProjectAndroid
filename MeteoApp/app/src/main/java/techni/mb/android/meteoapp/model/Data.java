package techni.mb.android.meteoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by student5310 on 16/03/16.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Data {

    private ArrayList<CurrentCondition> current_condition;
    private ArrayList<Weather> weather;

    public Data() {
    }



    public ArrayList<CurrentCondition> getCurrent_condition() {
        return current_condition;
    }

    public void setCurrent_condition(ArrayList<CurrentCondition> current_condition) {
        this.current_condition = current_condition;
    }

    public ArrayList<Weather> getWeather() {
        return weather;
    }

    public void setWeather(ArrayList<Weather> weather) {
        this.weather = weather;
    }
}
