package com.example.mylaboratory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.annotation.Annotation;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.lang.reflect.Method;


/**
 * Created by ShineMo-177 on 2015/12/28.
 */
public class StyleTestActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.style_test_activity);
        try {
            Class<?> cls = Class.forName("com.example.mylaboratory.BitmapTestActivity");
//        boolean flag = cls.isAnnotationPresent(MyAnnotation1.class);
//        if(flag){
//            System.out.println("判断类是annotation");
//            MyAnnotation1 annotation1 = cls.getAnnotation(MyAnnotation1.class);
//            System.out.println(annotation1.value());
//        }

            Method method = cls.getMethod("testField");
            boolean flag = method.isAnnotationPresent(MyBind.class);
            if (flag) {
                MyBind annotation2 = method.getAnnotation(MyBind.class);
                Toast.makeText(this, ""+annotation2.value(), Toast.LENGTH_SHORT).show();
            }
            else {
                Toast.makeText(this, "不存在这个Method", Toast.LENGTH_SHORT).show();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }







}
