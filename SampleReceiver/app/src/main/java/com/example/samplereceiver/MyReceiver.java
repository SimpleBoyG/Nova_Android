package com.example.samplereceiver;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.widget.Toast;

public class MyReceiver extends BroadcastReceiver {

    public final static String MyAction = "hello.world.broadcastReceiverExam.ACTION_MY_BROADCAST";
    @Override
    public void onReceive(Context context, Intent intent) {
        // TODO: This method is called when the BroadcastReceiver is receiving
        // an Intent broadcast.

        if(Intent.ACTION_POWER_CONNECTED.equals(intent.getAction())){
            Toast.makeText(context, "전원연결", Toast.LENGTH_SHORT).show();
        }
        else if(MyAction.equals(intent.getAction())){
            Toast.makeText(context, "내가 원하는 이벤트로 수신하는 브로드캐스트", Toast.LENGTH_SHORT).show();
        }

        //throw new UnsupportedOperationException("Not yet implemented");
    }
}