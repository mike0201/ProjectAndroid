package techni.mb.android.bloggies;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import techni.mb.android.bloggies.fragment.BloggiesFragment;
import techni.mb.android.bloggies.fragment.FacebookFragment;
import techni.mb.android.bloggies.fragment.TwitterFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button buttonFacebook;
    private Button buttonTwitter;
    private Button buttonBloggies;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonTwitter = (Button) findViewById(R.id.button_twitter_main);
        buttonFacebook = (Button) findViewById(R.id.button_facebook_main);
        buttonBloggies = (Button) findViewById(R.id.button_creation_compte_main);

        buttonTwitter.setOnClickListener(this);
        buttonFacebook.setOnClickListener(this);
        buttonBloggies.setOnClickListener(this);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        Fragment fragment;
        switch (v.getId()){
            case R.id.button_facebook_main:


                fragment = fragmentManager.findFragmentByTag(FacebookFragment.CONNEXION_TAG);
                if (fragment != null) {
                    break;
                }
                fragmentManager.beginTransaction()
                        .add(R.id.container, FacebookFragment.newInstance(), FacebookFragment.CONNEXION_TAG)
                        .addToBackStack(null)
                        .commit();
                break;
            case R.id.button_twitter_main:



                fragment = fragmentManager.findFragmentByTag(TwitterFragment.CONNEXION_TAG);
                if (fragment != null) {
                    break;
                }
                fragmentManager.beginTransaction()
                        .add(R.id.container, TwitterFragment.newInstance(), TwitterFragment.CONNEXION_TAG)
                        .addToBackStack(null)
                        .commit();



                break;
            case  R.id.button_creation_compte_main:

                fragment = fragmentManager.findFragmentByTag(BloggiesFragment.CONNEXION_TAG);
                if (fragment != null) {
                    break;
                }
                fragmentManager.beginTransaction()
                        .add(R.id.container, BloggiesFragment.newInstance(), BloggiesFragment.CONNEXION_TAG)
                        .addToBackStack(null)
                        .commit();

                break;
            default:
                break;
        }
    }
}
