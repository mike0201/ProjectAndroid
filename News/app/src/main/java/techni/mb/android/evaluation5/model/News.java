package techni.mb.android.evaluation5.model;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by Yvan Moté on 31/03/2016.
 */
public class News implements Parcelable {

    private String title;
    private String text;
    private String urlImage;

    public News(String title, String text, String urlImage) {
        this.title = title;
        this.text = text;
        this.urlImage = urlImage;
    }

    protected News(Parcel in) {
        title = in.readString();
        text = in.readString();
        urlImage = in.readString();
    }

    public static final Creator<News> CREATOR = new Creator<News>() {
        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };

    public String getTitle() {
        return title;
    }

    public String getText() {
        return text;
    }

    public String getUrlImage() {
        return urlImage;
    }

    /**
     * Describe the kinds of special objects contained in this Parcelable's
     * marshalled representation.
     *
     * @return a bitmask indicating the set of special object types marshalled
     * by the Parcelable.
     */
    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * Flatten this object in to a Parcel.
     *
     * @param dest  The Parcel in which the object should be written.
     * @param flags Additional flags about how the object should be written.
     *              May be 0 or {@link #PARCELABLE_WRITE_RETURN_VALUE}.
     */
    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(text);
        dest.writeString(urlImage);
    }
}
