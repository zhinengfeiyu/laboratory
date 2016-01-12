package com.example.mylaboratory;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by ShineMo-177 on 2016/1/4.
 */
public class RegexTestActivity extends Activity {

    EditText patternEt;
    EditText strEt;
    TextView resultShowTv;
    Button btn;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.regex_test_activity);
        patternEt = (EditText) findViewById(R.id.patternEt);
        strEt = (EditText) findViewById(R.id.strEt);
        resultShowTv = (TextView) findViewById(R.id.resultShowTv);
        btn = (Button) findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "验证完成！", Toast.LENGTH_SHORT).show();
                String patternStr = patternEt.getText().toString();
                String str = strEt.getText().toString();
                Pattern pattern = Pattern.compile("\d{3}");
                Matcher matcher = pattern.matcher(str);
                if (matcher.find())
                    resultShowTv.setText("匹配成功！");
                else
                    resultShowTv.setText("抱歉，匹配失败");
            }
        });

    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Toast.makeText(this, "RegexTestActivity onNewIntent", Toast.LENGTH_SHORT).show();
    }
}
