package techni.mb.android.meteoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by student5310 on 16/03/16.
 */
@JsonIgnoreProperties(ignoreUnknown=true)
public class Weather {

    private String date;
    private String maxtempC;
    private String mintempC;
    private ArrayList<Hourly> hourly;
    private String moyenneTemp;

    public String getMoyenneTemp() {

        int min = Integer.valueOf(mintempC);
        int max = Integer.valueOf(maxtempC);

        int moy = (max+min)/2;
        return String.valueOf(moy)+"°c";
    }

    public void setMoyenneTemp(String moyenneTemp) {
        this.moyenneTemp = moyenneTemp;
    }

    public Weather() {
    }



    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public ArrayList<Hourly> getHourly() {
        return hourly;
    }

    public void setHourly(ArrayList<Hourly> hourly) {
        this.hourly = hourly;
    }

    public String getMaxtempC() {
        return maxtempC;
    }

    public void setMaxtempC(String maxtempC) {
        this.maxtempC = maxtempC;
    }

    public String getMintempC() {
        return mintempC;
    }

    public void setMintempC(String mintempC) {
        this.mintempC = mintempC;
    }
}
