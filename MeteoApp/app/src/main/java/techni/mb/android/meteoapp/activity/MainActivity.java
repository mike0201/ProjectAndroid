package techni.mb.android.meteoapp.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import techni.mb.android.meteoapp.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button searchButton;
    private EditText cityNameEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cityNameEditText = (EditText) findViewById(R.id.cityName_editText_mainActivity);
        searchButton = (Button) findViewById(R.id.search_button_mainActivity);

        searchButton.setOnClickListener(this);

    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.search_button_mainActivity:

                String cityName = cityNameEditText.getText().toString().replaceAll(" ","+");
                Intent intent = new Intent(MainActivity.this,ResultActivity.class);
                intent.putExtra(ResultActivity.CITY_NAME,cityName);

                startActivity(intent);

        }
    }
}
