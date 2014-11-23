package com.beak.music.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;

import com.bmusic.beak.bemusic.R;


public class HelloActivity extends Activity {

    private ImageView mHelloIv = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hello);

        mHelloIv = (ImageView)this.findViewById(R.id.hello_icon);
        mHelloIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent();
                it.setClass(HelloActivity.this, MainActivity.class);
                startActivity(it);
                finish();
            }
        });
    }

}
