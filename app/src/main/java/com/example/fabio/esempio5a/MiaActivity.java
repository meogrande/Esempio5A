package com.example.fabio.esempio5a;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MiaActivity extends AppCompatActivity {
    int x=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //System.out.println("onCreate");
        // recupero lo l valore nelle shared preferences
        SharedPreferences prefs = getSharedPreferences("prova", MODE_PRIVATE);
        x = prefs.getInt("numero", 0);

        Log.e("logging", "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mia);
        final TextView textRef = (TextView) findViewById(R.id.testoRiferimento);
        Button mioBtn = (Button) findViewById(R.id.mioBottone);

        mioBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                x++;
                textRef.setText(""+x);
            }
        }
        );
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        System.out.println("onRestart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        System.out.println("onResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        System.out.println("onPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        System.out.println("onStop");
        // Salvo il numero nelle shared properties
        SharedPreferences.Editor editor = getSharedPreferences("prova",MODE_PRIVATE).edit();
        editor.putInt("numero", x);
        editor.apply();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        System.out.println("onDestroy");
    }

}
