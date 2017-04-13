package com.example.tyson.part4a;

import android.content.SharedPreferences; import android.preference.PreferenceManager; import android.support.v7.app.AppCompatActivity; import android.os.Bundle; import android.widget.TextView;
import android.widget.Toast;

public class StartGame extends AppCompatActivity {

    private     TextView      usrName,      gameLvl,     autoLogin, paidUser;

    private    String     usrNameStr,     gameLvlStr,     autoLoginStr = "No", paidUserStr = "No";



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_game);

        usrName    = (TextView)findViewById(R.id.usrNameTxtVw);


        gameLvl                             = (TextView)findViewById(R.id.gameLvlTxtVw);


        autoLogin                               = (TextView)findViewById(R.id.autoLoginTxtVw);

        SharedPreferences     myGameSettings;

        paidUser = (TextView)findViewById(R.id.paidUserTxtVw);



        // Load the SharedPreferences Object containing My Game's settings
        myGameSettings = PreferenceManager.getDefaultSharedPreferences(this);

        // Display User Name
        usrNameStr = myGameSettings.getString("usrNamePref", "");
        usrName.setText("User Name: " + usrNameStr);

        // Display Game Level
        gameLvlStr = myGameSettings.getString("gameLvlPref", "");

        gameLvl.setText("Game Level: " + gameLvlStr);

        // Display Auto Login Info
        Boolean autoLgn = myGameSettings.getBoolean("autoLoginPref", false);
        if (autoLgn == true) autoLoginStr = "Yes";

        autoLogin.setText                 ("Remember Login: " + autoLoginStr);

        Boolean paidBool = myGameSettings.getBoolean("paidUserPref", false);
        if (paidBool == true) paidUserStr = "Yes";

        paidUser.setText("Paid User: " + paidUserStr);

    }    // End of onCreate()

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Goodbye "+usrNameStr,
                Toast.LENGTH_LONG).show();
    }
}    // End of StartGame
