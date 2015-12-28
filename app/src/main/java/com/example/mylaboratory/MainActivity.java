package com.example.mylaboratory;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private GridView gridView;
    private List<String> btnTitleList;
    private List<Class> classList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        gridView = (GridView) findViewById(R.id.gridView);
        initList();
        if (btnTitleList.size() != classList.size()) {
            Toast.makeText(getApplicationContext(), "按钮数与对应的Activity数不相等！", Toast.LENGTH_SHORT).show();
            return;
        }
        gridView.setAdapter(new GridAdapter(this));
    }

    private void initList() {
        btnTitleList = new ArrayList<>();
        classList = new ArrayList<>();
        btnTitleList.add("Bitmap测试");
        classList.add(BitmapTestActivity.class);
        btnTitleList.add("Shape测试");
        classList.add(ShapeTestActivity.class);
        btnTitleList.add("PullToRefreshListView测试");
        classList.add(PullToRefreshListViewTestActivity.class);
        btnTitleList.add("GridView测试");
        classList.add(GridViewTestActivity.class);
        btnTitleList.add("Style测试");
        classList.add(StyleTestActivity.class);
    }

    private class GridAdapter extends BaseAdapter {

        private Context mContext;

        public GridAdapter(Context context) {
            this.mContext = context;
        }

        @Override
        public int getCount() {
            return btnTitleList.size();
        }

        @Override
        public Object getItem(int position) {
            return btnTitleList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView != null) {
                return convertView;
            }
            Button btn = new Button(mContext);
            AbsListView.LayoutParams params = new AbsListView.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            btn.setLayoutParams(params);
            btn.setText((String) getItem(position));
            btn.setTextSize(14);
            btn.setSingleLine();
            btn.setOnClickListener(new BtnClickListener(position));
            return btn;
        }
    }

    private class BtnClickListener implements View.OnClickListener {
        private int position;

        public BtnClickListener(int pos) {
            this.position = pos;
        }

        @Override
        public void onClick(View v) {
            Intent intent = new Intent();
            intent.setClass(MainActivity.this, classList.get(position));
            startActivity(intent);
        }
    }

}
