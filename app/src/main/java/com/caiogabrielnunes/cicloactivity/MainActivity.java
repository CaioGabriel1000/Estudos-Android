package com.caiogabrielnunes.cicloactivity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d("CicloVida","O evento OnCreate()");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d("CicloVida","O evento onStart()");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d("CicloVida","O evento onResume()");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d("CicloVida","O evento onPause()");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d("CicloVida","O evento onStop()");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("CicloVida","O evento onDestroy()");
    }
}
