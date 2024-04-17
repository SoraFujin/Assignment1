package com.example.assignment1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Switch;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.tabs.TabLayout;

import java.util.List;

public class MaterialActivity extends AppCompatActivity {
    private String subjects[] = {"Sorting Algorithms", "Daynamic Algorithms", "Analysis of Algorithm", "Divide and Conquer"};
    private int subjectImage[] = {R.mipmap.ic_launcher_sort, R.mipmap.ic_launcher_dynamicc, R.mipmap.ic_launcher_analysis, R.mipmap.ic_launcher_divid_conquer};
    private ListView listView;

    private ArrayAdapter<String> arrayAdapter;

    private SearchView searchView;
    private Switch switcher;
    private boolean nightMODE;
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private TabLayout tabLayout;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.material_activity);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.material), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

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

        tabLayout = findViewById(R.id.tabs);
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                int position = tab.getPosition();
                switch (position) {
                    case 0:
                        startActivity(new Intent(MaterialActivity.this, MainActivity.class));
                        break;
                    case 1:
                        recreate();
                        break;
                    case 2:
                        startActivity(new Intent(MaterialActivity.this, TestActivity.class));
                        break;
                    case 3:
                        startActivity(new Intent(MaterialActivity.this, ProfileActivity.class));
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
        //TODO life cycle methods OnStart-OnPause-OnCreate ... etc:

        listView = (ListView) findViewById(R.id.subjects);
        CustomBaseAdapter customBaseAdapter = new CustomBaseAdapter(getApplicationContext(), subjects, subjectImage);
        listView.setAdapter(customBaseAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 0){
                    startActivity(new Intent(MaterialActivity.this, SortingAlgo.class));
                }else if(position == 1){
                    startActivity(new Intent(MaterialActivity.this, DynamicAlgo.class));
                } else if (position == 2){
                    startActivity(new Intent(MaterialActivity.this, AnalysisAlgo.class));
                }else if (position == 3){
                    startActivity(new Intent(MaterialActivity.this, DivideAlgo.class));
                }
            }
        });


        arrayAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1);
        //listView.setAdapter(arrayAdapter);
        searchView = findViewById(R.id.search);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                MaterialActivity.this.arrayAdapter.getFilter().filter(query);
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                MaterialActivity.this.arrayAdapter.getFilter().filter(newText);
                return false;
            }
        });
    }
}
