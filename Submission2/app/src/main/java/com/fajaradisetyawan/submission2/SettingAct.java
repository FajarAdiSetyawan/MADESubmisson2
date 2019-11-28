package com.fajaradisetyawan.submission2;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.provider.Settings;
import android.view.View;
import android.widget.LinearLayout;

import java.util.Locale;

public class SettingAct extends AppCompatActivity {

    LinearLayout btnChangeLang;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //loadLocale();
        setContentView(R.layout.activity_setting);

        btnChangeLang = findViewById(R.id.btn_changelanguage);
        btnChangeLang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                //show AlertDialog to setting language
                Intent mIntent = new Intent(Settings.ACTION_LOCALE_SETTINGS);
                startActivity(mIntent);
//                showChangeLanguageDialog();
            }
        });

    }

//    private void showChangeLanguageDialog() {
//        final String[] listItem = {"Bahasa Indonesia", "English"};
//        AlertDialog.Builder builder = new AlertDialog.Builder(SettingAct.this);
//        String chosse = String.format(getResources().getString(R.string.chosselang));
//        builder.setTitle(chosse);
//        builder.setSingleChoiceItems(listItem, -1, new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialogInterface, int i) {
//                if (i == 0){
//                    setLocale("id");
//                    recreate();
//                } else if (i == 1){
//                    setLocale("en");
//                    recreate();
//                }
//                dialogInterface.dismiss();
//            }
//        });
//        AlertDialog mDialog = builder.create();
//        mDialog.show();
//    }
//
//    private void setLocale(String lang) {
//        Locale locale = new Locale(lang);
//        Locale.setDefault(locale);
//        Configuration config = new Configuration();
//        config.locale = locale;
//        getBaseContext().getResources().updateConfiguration(config, getBaseContext().getResources().getDisplayMetrics());
//        //save data
//        SharedPreferences.Editor editor = getSharedPreferences("Setting", MODE_PRIVATE).edit();
//        editor.putString("My Language", lang);
//        editor.apply();
//
//    }
//
//    // load language
//    public void loadLocale(){
//        SharedPreferences preferences = getSharedPreferences("Setting", Activity.MODE_PRIVATE);
//        String language = preferences.getString("My Language","");
//        setLocale(language);
//    }

}
