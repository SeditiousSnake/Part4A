package com.example.tyson.part4a;

import android.content.Intent; import android.content.SharedPreferences; import android.preference.PreferenceManager; import android.support.v7.app.AppCompatActivity; import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }     // end of onCreate(…)

    // method called when user clicks on the SETTINGS button (see page 2)

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId())       {

            case R.id.menu_game_settings_id:

                startActivity(new Intent(this, GameSettings.class));
                break;

            case R.id.menu_reset_id:

                resetMyGameSettings();
        }
        return true;
    }



    public   void     	 	 	 	showMyGameSettingsScreen(View vw) {

        Intent  myIntent = new Intent(getBaseContext(), GameSettings.class);         startActivity(myIntent) ;

    }   // End of method for SETTINGS button

// Let us jump to the SETTINGS layout file (gamesettings.xml) on page 6
    // method called when user clicks on the   RESET    button (see page 2)
    public    void     resetMyGameSettings(View vw) {

        SharedPreferences              myGameSettings;

        // Load the SharedPreferences Object
        myGameSettings = PreferenceManager.getDefaultSharedPreferences(this);

        // Use preferences editor to reset the user's preferences
        SharedPreferences.Editor      prefsEditor = myGameSettings.edit();



        prefsEditor.clear();     // This resets the settings


        // Save the preferences

        prefsEditor.commit();
        Toast.makeText(getApplicationContext(), "Settings Have Been Reset",
                Toast.LENGTH_LONG).show();
    }
    public    void     resetMyGameSettings() {

        SharedPreferences              myGameSettings;

        // Load the SharedPreferences Object
        myGameSettings = PreferenceManager.getDefaultSharedPreferences(this);

        // Use preferences editor to reset the user's preferences
        SharedPreferences.Editor      prefsEditor = myGameSettings.edit();



        prefsEditor.clear();     // This resets the settings


        // Save the preferences

        prefsEditor.commit();
        Toast.makeText(getApplicationContext(), "Settings Have Been Reset",
                Toast.LENGTH_LONG).show();
    }                  // End of resetMyGameSettings()

    public void startGame(View vw){
        Intent  myIntent = new Intent(getBaseContext(), StartGame.class);
        startActivity(myIntent);
    }

    public void endGame(View vw){
        SharedPreferences myGameSettings;

        myGameSettings=PreferenceManager.getDefaultSharedPreferences(this);

        Boolean rememberSettings = myGameSettings.getBoolean("autoLoginPref", false);
        if(!rememberSettings){
            resetMyGameSettings();
        }

        this.finish();
    }

// method called when user clicks on the START GAME button should go here
// Let us jump to the START GAME activity’s files - page 14


}                                                                      // End of MainActivity

