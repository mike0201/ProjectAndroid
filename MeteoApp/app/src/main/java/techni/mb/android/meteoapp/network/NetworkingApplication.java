package techni.mb.android.meteoapp.network;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

/**
 * Created by student5310 on 14/03/16.
 */
public class NetworkingApplication extends Application {

    private static NetworkingApplication sharedInstance;

    private RequestQueue volleyRequestQueue;


    @Override
    public void onCreate() {
        super.onCreate();


        NetworkingApplication.sharedInstance=this;

        volleyRequestQueue = Volley.newRequestQueue(this);

        volleyRequestQueue.start();



    }

    public static NetworkingApplication getSharedInstance() {
        return sharedInstance;
    }

    public RequestQueue getVolleyRequestQueue() {
        return volleyRequestQueue;
    }
}
