package com.beak.music.ui;

import android.animation.ObjectAnimator;
import android.animation.TimeInterpolator;
import android.app.Activity;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewTreeObserver;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.ListView;

import com.beak.music.fragment.MainFragment;
import com.beak.music.models.AudioAdapter;
import com.bmusic.beak.bemusic.R;

public class MainActivity extends BaseActivity implements MainFragment.OnFragmentInteractionListener {

    private static final String TAG = MainActivity.class.getSimpleName();

    private Toolbar mMainToolbar = null;
    private ListView mMainListView = null;

    private float mStartY = 0, mLastY = 0, mLastDeltaY;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mMainToolbar = (Toolbar)this.findViewById(R.id.main_bar);
        this.setSupportActionBar(mMainToolbar);

        mMainListView = (ListView)this.findViewById(R.id.main_list_view);
        final View header = LayoutInflater.from(this).inflate(R.layout.layout_header, null);
        mMainListView.addHeaderView(header);
        mMainListView.setAdapter(new AudioAdapter(this));


        mMainListView.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                final float y = event.getY();
                float translationY = mMainToolbar.getTranslationY();
                switch (event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
//                        Log.v(TAG, "Down");
                        mStartY = y;
                        mLastY = mStartY;
                        break;
                    case MotionEvent.ACTION_MOVE:
                        float mDeltaY = y - mLastY;

                        float newTansY = translationY + mDeltaY;
                        if (newTansY <= 0 && newTansY >= -mMainToolbar.getHeight()) {
                            mMainToolbar.setTranslationY(newTansY);
                        }
                        mLastY = y;
                        mLastDeltaY = mDeltaY;
//                        Log.v(TAG, "Move");
                        break;
                    case MotionEvent.ACTION_UP:
                        ObjectAnimator animator = null;
                        Log.d(TAG, "mLastDeltaY=" + mLastDeltaY);
                        if (mLastDeltaY < 0 && mMainListView.getFirstVisiblePosition() > 1) {
                            Log.v(TAG, "listView.first=" + mMainListView.getFirstVisiblePosition());
                            animator = ObjectAnimator.ofFloat(mMainToolbar, "translationY", mMainToolbar.getTranslationY(), -mMainToolbar.getHeight());
                        } else {
                            animator = ObjectAnimator.ofFloat(mMainToolbar, "translationY", mMainToolbar.getTranslationY(), 0);
                        }
                        animator.setDuration(100);
                        animator.start();
                        animator.setInterpolator(AnimationUtils.loadInterpolator(MainActivity.this, android.R.interpolator.linear));
//                        Log.v(TAG, "Up");
                        break;
                }
                return false;
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
