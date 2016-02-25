package com.example.mylaboratory;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by ShineMo-177 on 2016/2/16.
 */
public class CustomView extends FrameLayout {

    private String tvText = "请输入";
    private String etHint = "";
    private String btnText = "提交";
    private float etWidth;

    private TextView tv;
    private EditText et;
    private Button btn;

    public CustomView(Context context) {
        this(context, null);
    }

    public CustomView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public CustomView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        TypedArray t = context.obtainStyledAttributes(attrs, R.styleable.CustomAttr);
        tvText = t.getString(R.styleable.CustomAttr_tvText);
        etHint = t.getString(R.styleable.CustomAttr_etHint);
        btnText = t.getString(R.styleable.CustomAttr_btnText);
        etWidth = t.getDimension(R.styleable.CustomAttr_etWidth, 35);
        t.recycle();
        View layout = LayoutInflater.from(context).inflate(R.layout.custom_view_layout, this);
        tv = (TextView) layout.findViewById(R.id.tv);
        et = (EditText) layout.findViewById(R.id.et);
        btn = (Button) layout.findViewById(R.id.btn);

    }

    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        tv.setText(null);
        et.setHint(etHint);
        btn.setText(btnText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getContext(), et.getText().toString(), Toast.LENGTH_SHORT).show();
                tv.setTextSize(TypedValue.COMPLEX_UNIT_PX, etWidth);
            }
        });
    }
}
