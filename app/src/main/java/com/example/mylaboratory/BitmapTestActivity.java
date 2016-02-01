package com.example.mylaboratory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.ViewGroup;
import android.view.WindowManager;
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
        DisplayMetrics metrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(metrics);
        int width = metrics.widthPixels; // 屏幕宽度（像素）
        int height = metrics.heightPixels; // 屏幕高度（像素）
        int result = 0;
        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = getResources().getDimensionPixelSize(resourceId);
        }
        TextView tv = (TextView) findViewById(R.id.tv);
        ViewGroup.LayoutParams params = tv.getLayoutParams();
        params.width = width;
        params.height = height - result;

    }


}
