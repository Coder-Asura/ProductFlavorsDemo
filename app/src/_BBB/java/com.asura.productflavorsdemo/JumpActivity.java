package com.asura.productflavorsdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class JumpActivity extends AppCompatActivity {
    int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jump);
    }

    public void jumpAgain(View view) {
        Intent intent = new Intent( this,Jump2Activity.class);
        startActivity(intent);
    }
}
