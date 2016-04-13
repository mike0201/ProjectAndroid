package techni.mb.android.meteoapp.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 * Created by student5310 on 16/03/16.
 */
@JsonIgnoreProperties(ignoreUnknown=true)

public class ContainData {
    private Data data;

    public Data getData() {
        return data;
    }

    public void setData(Data data) {
        this.data = data;
    }
}
