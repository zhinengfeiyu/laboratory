package com.example.mylaboratory;

import android.app.Activity;
import android.content.Context;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.view.Gravity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;


/**
 * Created by ShineMo-177 on 2015/12/28.
 */
public class StyleTestActivity extends Activity {

    WindowManager windowManager;
    private Button btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.style_test_activity);
        windowManager = (WindowManager) getSystemService(Context.WINDOW_SERVICE);
        WindowManager.LayoutParams params = new WindowManager.LayoutParams(WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 0, 0, PixelFormat.TRANSPARENT);
        params.flags = WindowManager.LayoutParams.FLAG_DIM_BEHIND;
        params.dimAmount = 0.5f;
        params.gravity = Gravity.LEFT | Gravity.TOP;
        params.x = 100;
        params.y = 300;
        btn = new Button(this);
        btn.setText("我其实是一个窗口");
        windowManager.addView(btn, params);
    }

    @Override
    public void onBackPressed() {

    }
}
