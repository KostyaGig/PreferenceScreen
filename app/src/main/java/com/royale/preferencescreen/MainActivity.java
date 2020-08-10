package com.royale.preferencescreen;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private SharedPreferences sp;
    private String font_size;
    private TextView tv;
    private boolean key_1;
    private boolean key_2;
    private boolean key_3;
    private boolean key_4;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        tv = findViewById(R.id.tv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.seting:
                final Intent intent_setting = new Intent(MainActivity.this,SettingActivity.class);
                startActivity(intent_setting);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onPostResume() {
        super.onPostResume();
        sp = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        font_size = sp.getString("setting_font","Средний");
        key_1 = sp.getBoolean("color_red",false);
        key_2 = sp.getBoolean("color_green",false);
        key_3 = sp.getBoolean("color_purple",false);
        key_4 = sp.getBoolean("color_blue",true);
        if(font_size !=null){
            switch (font_size){
                case "Большой":
                    tv.setTextSize(50);
                    break;
                case "Средний":
                    tv.setTextSize(30);
                    break;
                case "Маленький":
                    tv.setTextSize(15);
                    break;
            }
        }
        if(key_1 == true){
            tv.setTextColor(getResources().getColor(R.color.red));
        }
        else if(key_2 == true){
            tv.setTextColor(getResources().getColor(R.color.green));
        }
        else if(key_3 == true){
            tv.setTextColor(getResources().getColor(R.color.purple));
        }
        else if(key_4 == true){
            tv.setTextColor(getResources().getColor(R.color.blue));
        }
    }
}
