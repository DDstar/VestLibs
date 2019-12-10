package com.home.vestapplibmanager;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        SMSSDK.registerEventHandler(eh);
    }


    public void sendCode(View view) {
//        SMSSDK.getVerificationCode("86", "18850220877");
    }


//    @SuppressLint("HandlerLeak")
//    Handler mHandler = new Handler() {
//        @Override
//        public void handleMessage(Message msg) {
//            super.handleMessage(msg);
//            Toast.makeText(MainActivity.this, "发送成功", Toast.LENGTH_SHORT).show();
//        }
//    };
//    EventHandler eh = new EventHandler() {
//        @Override
//        public void afterEvent(int event, int result, Object data) {
//            Message msg = new Message();
//            msg.arg1 = event;
//            msg.arg2 = result;
//            msg.obj = data;
//            mHandler.sendMessage(msg);
//        }
//    };
}
