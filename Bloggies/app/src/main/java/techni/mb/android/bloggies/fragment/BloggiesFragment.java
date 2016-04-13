package techni.mb.android.bloggies.fragment;


import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import techni.mb.android.bloggies.R;



/**
 * A simple {@link Fragment} subclass.
 */
public class BloggiesFragment extends Fragment implements View.OnClickListener {


    public static final String CONNEXION_TAG = "bloogies";
    private EditText login;
    private EditText password;
    private EditText confpassword;
    private EditText email;
    private Button inscription;


    public BloggiesFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view= inflater.inflate(R.layout.fragment_bloggies, container, false);


        login = (EditText) view.findViewById(R.id.login_bloggies);
        password =(EditText) view.findViewById(R.id.pass_bloggies);
        confpassword = (EditText) view.findViewById(R.id.conf_pass_bloggies);
        email = (EditText) view.findViewById(R.id.email_bloggies);

        inscription =(Button) view.findViewById(R.id.button_inscription_boogies);

        inscription.setOnClickListener(this);

        return view;


    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {

        String log =login.getText().toString();
        String em = email.getText().toString();
        String pas1 = password.getText().toString();
        String pas2 = confpassword.getText().toString();
        if(!log.equals("") && !pas1.equals("") && !pas2.equals("") && !em.equals("")){
            // methode de check email en propre si j'ai le temps

            if ( pas1.equals(pas2)) {
                if (em.contains("@")) {
                    FragmentManager fragmentManager = getFragmentManager();
                    Fragment fragment = fragmentManager.findFragmentByTag(ConnecteFragment.CONNEXION_TAG);
                    fragmentManager.beginTransaction()
                            .add(R.id.container, ConnecteFragment.newInstance(log), ConnecteFragment.CONNEXION_TAG)
                            .addToBackStack(null)
                            .commit();
                }else
                {
                    new AlertDialog.Builder(this.getContext())
                            .setTitle(R.string.mail_invalide)
                            .setMessage(R.string.text_mail_invalide)
                            .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.cancel();
                                }
                            })

                            .setIcon(android.R.drawable.ic_dialog_alert)
                            .show();
                }
            }
            else{
                new AlertDialog.Builder(this.getContext())
                        .setTitle(R.string.password_invalide)
                        .setMessage(R.string.text_password_invalide)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }
        }else{
                new AlertDialog.Builder(this.getContext())
                        .setTitle(R.string.champ_vide)
                        .setMessage(R.string.text_champ_vide)
                        .setPositiveButton(android.R.string.ok, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {
                                dialog.cancel();
                            }
                        })

                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();
            }




    }

    public static Fragment newInstance() {
        BloggiesFragment fragment = new BloggiesFragment();

        Bundle arguments = new Bundle();
        fragment.setArguments(arguments);


        return fragment;
    }
}
