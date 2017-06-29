package com.asura.productflavorsdemo;

import android.content.Intent;
import android.net.Uri;
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
        String url = flag == 0 ? "http://www.jianshu.com/u/f22d6bddfd1c" : "https://github.com/qq709238339";
        flag = flag == 0 ? 1 : 0;
        Uri uri = Uri.parse(url);
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        startActivity(intent);
    }
}
