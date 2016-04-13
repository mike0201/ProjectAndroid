package techni.mb.android.meteoapp.model;

import org.json.JSONObject;

/**
 * Created by student5310 on 16/03/16.
 */
public class WeatherIconUrl {

    private String value;

    public WeatherIconUrl() {
    }

    public WeatherIconUrl(JSONObject json) {
        this.value = json.optString("value");
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
