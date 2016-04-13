package techni.mb.android.bloggies.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import techni.mb.android.bloggies.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class TwitterFragment extends Fragment implements View.OnClickListener {


    public static final String CONNEXION_TAG = "connexion_twitter";
    private EditText login;
    private EditText password;

    public TwitterFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_twitter, container, false);

         login = (EditText) view.findViewById(R.id.editText_login_twitter);
         password = (EditText) view.findViewById(R.id.editText_password_twitter);
        Button connexion = (Button) view.findViewById(R.id.connexion_fragment_twitter);

        connexion.setOnClickListener(this);

        return view;

    }


    public static Fragment newInstance() {
        TwitterFragment fragment = new TwitterFragment();

        Bundle arguments = new Bundle();
        fragment.setArguments(arguments);


        return fragment;
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        String log = login.getText().toString();
        String pass=password.getText().toString();

        if (!log.equals("") && !pass.equals("")){

            FragmentManager fragmentManager = getFragmentManager();
            Fragment fragment = fragmentManager.findFragmentByTag(ConnecteFragment.CONNEXION_TAG);
            fragmentManager.beginTransaction()
                    .add(R.id.container, ConnecteFragment.newInstance(ConnecteFragment.TWITTER), ConnecteFragment.CONNEXION_TAG)
                    .addToBackStack(null)
                    .commit();

        }
        else
        {
            new AlertDialog.Builder(this.getContext())
                    .setTitle(R.string.element_manquant)
                    .setMessage(R.string.text_element_manquant)
                    .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int which) {
                            dialog.cancel();
                        }
                    })

                    .setIcon(android.R.drawable.ic_dialog_alert)
                    .show();
        }
    }
}
