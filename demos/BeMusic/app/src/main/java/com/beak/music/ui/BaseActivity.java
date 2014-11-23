package com.beak.music.ui;

import android.os.Build;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;

import com.bmusic.beak.bemusic.R;

/**
 * Created by 比克 on 2014/11/19.
 */
public class BaseActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (Build.VERSION.SDK_INT >= 21) {
            this.getWindow().setNavigationBarColor(getResources().getColor(R.color.colorPrimaryDark));
            this.getWindow().setStatusBarColor(getResources().getColor(R.color.navigationBarColor));
        }
    }
}
