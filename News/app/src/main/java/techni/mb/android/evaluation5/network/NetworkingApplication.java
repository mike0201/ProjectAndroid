package techni.mb.android.evaluation5.network;

import android.app.Application;

import com.android.volley.RequestQueue;
import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.Volley;

/**
 * Created by student5310 on 1/04/16.
 */
public class NetworkingApplication extends Application {


    private static NetworkingApplication sharedInstance;

    private RequestQueue volleyRequestQueue;
    private ImageLoader volleyImageLoader;


    @Override
    public void onCreate() {
        super.onCreate();

        NetworkingApplication.sharedInstance=this;
        volleyRequestQueue = Volley.newRequestQueue(this);
        volleyImageLoader = new ImageLoader(volleyRequestQueue,new LruBitmapCache(1024));
        volleyRequestQueue.start();
    }

    public static NetworkingApplication getSharedInstance() {
        return sharedInstance;
    }

    public static void setSharedInstance(NetworkingApplication sharedInstance) {
        NetworkingApplication.sharedInstance = sharedInstance;
    }

    public ImageLoader getVolleyImageLoader() {
        return volleyImageLoader;
    }

    public void setVolleyImageLoader(ImageLoader volleyImageLoader) {
        this.volleyImageLoader = volleyImageLoader;
    }

    public RequestQueue getVolleyRequestQueue() {
        return volleyRequestQueue;
    }

    public void setVolleyRequestQueue(RequestQueue volleyRequestQueue) {
        this.volleyRequestQueue = volleyRequestQueue;
    }
}
