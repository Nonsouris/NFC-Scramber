package com.example.nfc.mynfcreader;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class main extends Activity {
    private EditText editTextInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);

    }
    public void gotooptions (View view){
        Intent intent = new Intent (this, Options.class);
        startActivity(intent);
    }
    public void gotoemitter (View v){
        Intent emitter = new Intent (this, Emitter.class);
        startActivity(emitter);
    }

}
