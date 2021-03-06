package oops.com.report_a_potty;

import android.content.pm.ActivityInfo;
import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.View;
import android.widget.Button;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    // Set default button code to GPS
    public static char buttonCode = 'G';

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LOCKED);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // make the button classes
        Button buttonGPS = (Button) findViewById(R.id.buttonGPS);
        Button buttonEnterAddress = (Button) findViewById(R.id.buttonEnterAddress);

        // now if the GPS button was clicked go straight  to the map activity and use GPS location
        // this  uses the last known location API to geolocate the phone
        buttonGPS.setOnClickListener(new Button.OnClickListener() {
                public void onClick(View v) {
                    // Perform action on click
                    buttonCode = 'G';
                    Intent activityChangeIntent = new Intent(MainActivity.this, locationActivity.class);
                    startActivity(activityChangeIntent);
                }
            }
        );

        // If the enter address button was clicked, then go to a secondary UI first that prompts user
        // to enter an address in a edit text view. This uses geocoding to translate address to LatLng
        buttonEnterAddress.setOnClickListener(new View.OnClickListener() {
                public void onClick(View v) {
                    buttonCode = 'A';
                    Intent activityChangeIntent = new Intent(MainActivity.this, enterAddressActivity.class);
                    startActivity(activityChangeIntent);
                }
            }
        );
    }
}