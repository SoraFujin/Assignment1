package com.example.assignment1;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class ProfileActivity extends AppCompatActivity {

    private EditText editText_name, editText_ID, editText_email;
    private Button submit_button;
    private SharedPreferences sharedPreferences;


    private static final String SHARED_PREF_NAME = "mypref";
    private static final String KEY_NAME= "name";
    private static final String KEY_ID= "ID";
    private static final String KEY_EMAIL = "email";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.profile_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.profile), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sharedPreferences = getSharedPreferences("", MODE_PRIVATE);
        editText_name = findViewById(R.id.edit_text_name);
        editText_ID = findViewById(R.id.edit_text_ID);
        editText_email = findViewById(R.id.edit_text_email);
        submit_button = findViewById(R.id.submit_button);

        String name = sharedPreferences.getString(KEY_NAME, null);
        if(name != null){
            Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
           startActivity(intent);
        }


        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString(KEY_NAME, editText_name.getText().toString());
                editor.putString(KEY_ID, editText_ID.getText().toString());
                editor.putString(KEY_EMAIL, editText_email.getText().toString());
                editor.apply();
                Intent intent = new Intent(ProfileActivity.this, MainActivity.class);
                startActivity(intent);
                Toast.makeText(ProfileActivity.this, "Info Saved", Toast.LENGTH_SHORT).show();
            }
        });


    }
}
