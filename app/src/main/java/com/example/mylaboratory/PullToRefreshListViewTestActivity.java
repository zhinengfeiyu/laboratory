package com.example.mylaboratory;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

/**
 * Created by ShineMo-177 on 2015/12/28.
 */
public class PullToRefreshListViewTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pull_refresh_list_activity);

        View v = findViewById(R.id.layout);
        View view = LayoutInflater.from(this).inflate(R.layout.bitmap_test_activity, (ViewGroup) v, false);
        Toast.makeText(this, "是子view? " + (view instanceof LinearLayout), Toast.LENGTH_SHORT).show();
    }
}
