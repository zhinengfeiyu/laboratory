package com.example.mylaboratory.FragmentTest;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.mylaboratory.R;
import com.example.mylaboratory.ShapeTestActivity;

/**
 * Created by ShineMo-177 on 2015/12/30.
 */
public class FragmentTestMeActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstance) {
        super.onCreate(savedInstance);
        setContentView(R.layout.fragment_test_me_activity);
        Toast.makeText(getApplicationContext(), "Activity onCreate", Toast.LENGTH_SHORT).show();
        findViewById(R.id.remove).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_CLOSE);
                ft.addToBackStack(null);
                Fragment fragment = fm.findFragmentByTag("this fragment");
                ft.remove(fragment);
                ft.commit();
            }
        });
        findViewById(R.id.add).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                FragmentManager fm = getFragmentManager();
                FragmentTransaction ft = fm.beginTransaction();
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_OPEN);
                Fragment fragment = new MyTestFragment();
                ft.add(R.id.container,fragment,"this fragment");
                ft.addToBackStack(null);
                ft.commit();
            }
        });
        findViewById(R.id.undo).setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
//                FragmentManager fm = getFragmentManager();
//                fm.popBackStack();
                Intent i = new Intent(FragmentTestMeActivity.this, ShapeTestActivity.class);
               // i.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP);
                startActivity(i);
            }
        });

    }

    public static class MyTestFragment extends Fragment {

        @Override
        public void onAttach(Context context) {
            super.onAttach(context);
            Toast.makeText(getActivity(), "Fragment onAttach", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            Toast.makeText(getActivity(), "Fragment onCreate", Toast.LENGTH_SHORT).show();
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            Toast.makeText(getActivity(), "Fragment onCreateView", Toast.LENGTH_SHORT).show();
//            Button btn = new Button(getActivity());
//            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams
//                    (LinearLayout.LayoutParams.WRAP_CONTENT,LinearLayout.LayoutParams.WRAP_CONTENT);
//            btn.setLayoutParams(params);
//            btn.setText("下一个");
//            btn.setOnClickListener(new View.OnClickListener() {
//                public void onClick(View v) {
//                    startActivity(new Intent(getActivity(), FragmentTestMainActivity.class));
//                }
//            });
//            return btn;
            View view = inflater.inflate(R.layout.grid_view_test_activity,container,false);
            return view;
        }

        @Override
        public void onActivityCreated(Bundle bundle) {
            super.onActivityCreated(bundle);
            Toast.makeText(getActivity(), "Fragment onActivityCreated", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStart() {
            super.onStart();
            Toast.makeText(getActivity(), "Fragment onStart", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onResume() {
            super.onResume();
            Toast.makeText(getActivity(), "Fragment onResume", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onPause() {
            super.onPause();
            Toast.makeText(getActivity(), "Fragment onPause", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onStop() {
            super.onStop();
            Toast.makeText(getActivity(), "Fragment onStop", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onDestroyView() {
            super.onDestroyView();
            Toast.makeText(getActivity(), "Fragment onDestroyView", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onDestroy() {
            super.onDestroy();
            Toast.makeText(getActivity(), "Fragment onDestroy", Toast.LENGTH_SHORT).show();
        }

        @Override
        public void onDetach() {
            super.onDetach();
            Toast.makeText(getActivity(), "Fragment onDetach", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onStart() {
        super.onStart();
        Toast.makeText(getApplicationContext(), "Activity onStart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(), "Activity onResume", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(), "Activity onPause", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onRestart() {
        super.onRestart();
        Toast.makeText(getApplicationContext(), "Activity onRestart", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(), "Activity onStop", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(), "Activity onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onNewIntent(Intent i) {
        super.onNewIntent(i);
        Toast.makeText(getApplicationContext(), "FragmentTestMeActivity onNewIntent", Toast.LENGTH_SHORT).show();
    }
}
