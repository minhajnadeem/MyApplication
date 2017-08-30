package com.example.minhaj.myapplication;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private Button appBarBtnOne,appBarBtnTwo;
    private TextView appBarText;

    private FragmentManager fragmentManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        initViews();
        btnListeners();
        replaceFragment(new FragmentOne());
    }

    private void initViews(){
        appBarBtnOne = (Button) findViewById(R.id.appBarBtnOne);
        appBarBtnTwo = (Button) findViewById(R.id.appBarButtonTwo);
        appBarText = (TextView) findViewById(R.id.appBarText);
    }

    private void btnListeners() {
        appBarBtnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new FragmentOne());
            }
        });

        appBarBtnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                replaceFragment(new FragmentTwo());
            }
        });
    }

    private void replaceFragment(Fragment fragment){
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragmentContainer,fragment );
        fragmentTransaction.commit();
    }

    public void changeToolbarText(String text){
        appBarText.setText(text);
    }
}