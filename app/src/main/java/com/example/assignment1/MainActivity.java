package com.example.assignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.cardview.widget.CardView;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

public class MainActivity extends AppCompatActivity {

   private SharedPreferences sharedPreferences1;
    private TextView textView_name, textView_ID, textView_email;
    private Button logOut_button;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME= "name";
    private static final String KEY_ID= "ID";
    private static final String KEY_EMAIL = "email";
    private Switch switcher;
    private boolean nightMODE;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;

    private CardView testCard, materialCard, profileCard;
    private ImageView logo;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }

        switcher = findViewById(R.id.DarkMode);

        sharedPreferences = getSharedPreferences( "MODE", Context.MODE_PRIVATE);
        nightMODE = sharedPreferences.getBoolean("night", false);

        if(nightMODE){
            switcher.setChecked(true);
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
        }

        switcher.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(nightMODE){
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", false);
                }else {
                    AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                    editor = sharedPreferences.edit();
                    editor.putBoolean("night", true);
                }
                editor.apply();
            }
        });

        //test card where we go to the test activity in the app
        testCard = findViewById(R.id.test_card);
        testCard.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Intent intent = new Intent(MainActivity.this, TestActivity.class);
            startActivity(intent);
        }
    });

        //starting the material activity
        materialCard = findViewById(R.id.study_material);
        materialCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MaterialActivity.class);
                startActivity(intent);
            }
        });

        //starting profile activity
        profileCard = findViewById(R.id.profile_card);
        profileCard.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        //logo
        logo = findViewById(R.id.StudySphere);
        logo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                recreate();
            }
        });

        tabLayout = findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                       recreate();
                        break;
                    case 1:
                        startActivity(new Intent(MainActivity.this, MaterialActivity.class));
                        break;
                    case 2:
                        startActivity(new Intent(MainActivity.this, TestActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MainActivity.this, ProfileActivity.class));
                        break;
                }
            }
            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        textView_name = findViewById(R.id.text_name);
        textView_ID = findViewById(R.id.text_ID);
        textView_email = findViewById(R.id.text_email);

        sharedPreferences1 = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sharedPreferences1.getString(KEY_NAME, null);
        String ID = sharedPreferences1.getString(KEY_ID, null);
        String email = sharedPreferences1.getString(KEY_EMAIL, null);

        if(name != null || ID != null || email != null){
            textView_name.setText("Full Name" + name);
            textView_ID.setText("ID" + ID);
            textView_email.setText("Email" + email);

        }

        logOut_button = findViewById(R.id.logout_button);
        logOut_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences1.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(MainActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

}








