package com.skype.skypeclone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.fragment.app.Fragment;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class HomeActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        if(savedInstanceState == null){
            getSupportFragmentManager().beginTransaction().replace(R.id.FragementCointenerID, new UsersFragement()).commit();
        }


        toolbar = findViewById(R.id.HomeToolbarID);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.menu_icon);

        bottomNavigationView = findViewById(R.id.BottomNavagationID);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {

                Fragment fragment = null;

                switch (menuItem.getItemId()){
                    case R.id.UsersID:
                        fragment  = new UsersFragement();
                        break;

                    case R.id.ChatID:
                        fragment = new ChatFragement();
                        break;

                    case R.id.ProfileID:
                        fragment = new ProfileFragement();
                        break;
                }

                getSupportFragmentManager().beginTransaction().replace(R.id.FragementCointenerID, fragment).commit();
                return true;
            }
        });
    }
}
