package com.example.macroeconomicfoodsecurity;

import android.os.Bundle;
import android.util.Log;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.macroeconomicfoodsecurity.databinding.ActivityMainBinding;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private  DBHandler dbHandler;
    private ReaderController readerController;
    private  WriterController writerController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());
        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(this.getApplicationContext());
        dbHandler.createTable();
        readerController = new ReaderController(dbHandler);
// dbHandler.addNewGDPPercent("1995", "34", "35", "33");
        try {
            WriterController.seedData(this.getApplicationContext(), dbHandler);
        } catch (IOException e) {
            e.printStackTrace();
        }
        List<Result> courseModalArrayList = readerController.getFertlizerConsump("usa");

        Log.e("cvcvcv", String.valueOf( courseModalArrayList.size()));
        for (Result m: courseModalArrayList
             ) {
            Log.e("cvcvcv", m.percent);
        }

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);
    }

}