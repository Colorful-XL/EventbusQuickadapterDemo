package com.example.EventbusQuickadapterDemo.Avtivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.EventbusQuickadapterDemo.R;
import com.example.EventbusQuickadapterDemo.Router.MessageEvent;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

/**
 * 事件订阅的Act
 */
public class EventBusSubActivity extends BaseActivity {

    TextView displayNormalText;
    TextView displayStickyText;
    Button btnJump;
    Button btnReg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event_bus_sub);
        displayNormalText = this.findViewById(R.id.displayNormalText);
        displayStickyText = this.findViewById(R.id.displayStickyText);
        btnJump = this.findViewById(R.id.btnJump);
        btnReg = this.findViewById(R.id.btnReg);

        btnReg.setOnClickListener(v -> {
            if (!EventBus.getDefault().isRegistered(this))
                EventBus.getDefault().register(this);
        });
        btnJump.setOnClickListener(v -> {
            startActivity(new Intent(EventBusSubActivity.this, EventBusPubActivity.class));
        });
    }

    /**
     * 收到publisher的消息后回调的方法
     *
     * @param messageEvent
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onShowEventMeaasge(MessageEvent messageEvent) {
        displayNormalText.setTextColor(Color.BLACK);
        displayNormalText.setText(messageEvent.getMessage());
    }

    @Subscribe(threadMode = ThreadMode.MAIN_ORDERED, sticky = true)
    public void onShowStickyEventMessage(MessageEvent messageEvent) {
        displayStickyText.setTextColor(Color.BLACK);
        displayStickyText.setText(messageEvent.getMessage());
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
