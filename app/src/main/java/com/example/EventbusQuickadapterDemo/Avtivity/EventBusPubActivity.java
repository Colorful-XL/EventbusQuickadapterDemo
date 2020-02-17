package com.example.EventbusQuickadapterDemo.Avtivity;

import android.os.Bundle;
import android.widget.Button;

import com.example.EventbusQuickadapterDemo.R;
import com.example.EventbusQuickadapterDemo.Router.MessageEvent;

import org.greenrobot.eventbus.EventBus;

public class EventBusPubActivity extends BaseActivity {
    Button btnPub;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_pub);
        btnPub = this.findViewById(R.id.btnPub);
        btnPub.setOnClickListener(v->{
//            EventBus.getDefault().post(new MessageEvent("普通：一给我哩giao"));

            EventBus.getDefault().postSticky(new MessageEvent("Stick:giao!"));
            finish();
        });
    }
}
