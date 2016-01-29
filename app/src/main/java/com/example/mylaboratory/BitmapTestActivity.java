package com.example.mylaboratory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.mylaboratory.FragmentTest.FragmentTestMeActivity;

/**
 * Created by ShineMo-177 on 2015/12/28.
 */
public class BitmapTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.bitmap_test_activity);
        RelativeLayout layout = (RelativeLayout) findViewById(R.id.thisLayout);
        TextView tv = (TextView) layout.findViewById(R.id.txt1);
        Toast.makeText(this, "tv==null?" + (tv==null), Toast.LENGTH_SHORT).show();
    }


}
