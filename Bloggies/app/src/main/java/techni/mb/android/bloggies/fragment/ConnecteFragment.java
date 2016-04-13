package techni.mb.android.bloggies.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import techni.mb.android.bloggies.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ConnecteFragment extends Fragment {


    public static final String CONNEXION_TAG = "connecte";
    public static final String TWITTER = "twitter";
    public static final String FACEBOOK = "facebook";

    public void setTypeApp(String typeApp) {
        this.typeApp = typeApp;
    }

    private String typeApp="";

    public ConnecteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_connecte, container, false);

        ImageView logo = (ImageView) view.findViewById(R.id.logo_connecteFragment);
        TextView textView =(TextView) view.findViewById(R.id.TextView_ConnecteFragment);
        if (typeApp==TWITTER){
            logo.setImageResource(R.drawable.twitter);
        }
        else if (typeApp == FACEBOOK)
        {
            logo.setImageResource(R.drawable.facebook);
        }else
        {
            logo.setImageResource(R.drawable.bloggies);
            textView.setText(R.string.bienvenue+typeApp);
        }

        return view;
    }

    public static Fragment newInstance(String application) {
        ConnecteFragment fragment = new ConnecteFragment();

        Bundle arguments = new Bundle();
        fragment.setArguments(arguments);

        fragment.setTypeApp(application);

        return fragment;
    }
}
