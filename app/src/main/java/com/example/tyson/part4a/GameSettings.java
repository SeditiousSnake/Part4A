package com.example.tyson.part4a;

import android.app.FragmentManager; import android.preference.PreferenceFragment; import android.app.FragmentTransaction; import android.support.v7.app.AppCompatActivity; import android.os.Bundle;

public class GameSettings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {         super.onCreate(savedInstanceState);


        setTitle("Game Settings");   // see page 7


        // Display the game settings PreferenceFragment
        FragmentManager fragmentMgr = getFragmentManager();
        FragmentTransaction fragmentTrnsctn = fragmentMgr.beginTransaction();

        PrefsFrag settingsPrefsFragment = new PrefsFrag();
        fragmentTrnsctn.replace(android.R.id.content, settingsPrefsFragment);
        fragmentTrnsctn.commit();

    }   	 	 // end of onCreate()


    //   	 	Preference Fragment 	 	 	 	 	 class
    public static class PrefsFrag extends PreferenceFragment {

        @Override
        public void onCreate(Bundle savedInstanceState) {             super.onCreate(savedInstanceState);

            // Load the preferences from an XML resource
            addPreferencesFromResource(R.xml.gamesettings);
        }
    }
}                               // End of GameSettings
