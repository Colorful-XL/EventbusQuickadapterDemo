package com.example.EventbusQuickadapterDemo.Avtivity;

import androidx.constraintlayout.widget.Group;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.EventbusQuickadapterDemo.R;

public class ConstraintLayoutActivity extends BaseActivity implements View.OnClickListener {

    Button button;
    TextView textView1;
    Group group;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_constraint_layout);
//        textView1 = this.findViewById(R.id.textView1);
        group = this.findViewById(R.id.group);
        button = this.findViewById(R.id.goneButton);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.goneButton) {
            if (group.getVisibility() == View.VISIBLE) {
                group.setVisibility(View.GONE);
                button.setText("可见");
            } else {
                group.setVisibility(View.VISIBLE);
                button.setText("不可见");
            }
            Toast.makeText(this, "textView visibility changed", Toast.LENGTH_SHORT).show();
        }
    }
}
