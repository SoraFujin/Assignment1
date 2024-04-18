package com.example.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    private SharedPreferences sharedPreferences;
    private TextView textView_name, textView_ID, textView_email;
    private Button logOut_button;
    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME= "name";
    private static final String KEY_ID= "ID";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.profile_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        textView_name = findViewById(R.id.text_name);
        textView_ID = findViewById(R.id.text_ID);
        textView_email = findViewById(R.id.text_email);

        sharedPreferences = getSharedPreferences(SHARED_PREF_NAME, MODE_PRIVATE);
        String name = sharedPreferences.getString(KEY_NAME, null);
        String ID = sharedPreferences.getString(KEY_ID, null);
        String email = sharedPreferences.getString(KEY_EMAIL, null);

        if(name != null || ID != null || email != null){
            textView_name.setText("Full Name " + name);
            textView_ID.setText("ID " + ID);
            textView_email.setText("Email " + email);

        }

        logOut_button = findViewById(R.id.logout_button);
        logOut_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.clear();
                editor.commit();
                finish();
                Toast.makeText(ProfileActivity.this, "Logged out", Toast.LENGTH_SHORT).show();
                finish();
            }
        });

    }
}
