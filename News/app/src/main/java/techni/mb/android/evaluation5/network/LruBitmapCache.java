package techni.mb.android.evaluation5.network;

import android.graphics.Bitmap;
import android.util.LruCache;

import com.android.volley.toolbox.ImageLoader;

/**
 * Created by student5310 on 8/03/16.
 */
public class LruBitmapCache extends LruCache<String, Bitmap> implements ImageLoader.ImageCache {
    public LruBitmapCache(int maxSize) {
        super(maxSize);
    }
    @Override
    protected int sizeOf(String key, Bitmap value) {
        return value.getRowBytes() * value.getHeight();
    }
    @Override
    public Bitmap getBitmap(String url) {
        return get(url);
    }
    @Override
    public void putBitmap(String url, Bitmap bitmap) {
        put(url, bitmap);
    }



}
