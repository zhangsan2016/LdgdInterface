package aninterface.ldgd.com.ldgdinterface.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Date;

import aninterface.ldgd.com.ldgdinterface.R;


/**
 * Created by ldgd on 2017/8/18.
 */

public class MainAct extends Activity {
    private TextView tv_time;

    private TextView tv_timing_main;
    private TextView tv_debug_main;
    private TextView tv_parameter_main;
    private ImageView ivSetting;

    private Handler timeHandler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);


            tv_time.setText(getDate());

            timeHandler.removeMessages(0);
            timeHandler.sendEmptyMessageDelayed(0, 1000);
        }
    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        tv_time = (TextView) this.findViewById(R.id.tv_time);
        timeHandler.sendEmptyMessage(0);

        tv_timing_main = (TextView) this.findViewById(R.id.tv_timing_main);
        tv_debug_main = (TextView) this.findViewById(R.id.tv_debug_main);
        tv_parameter_main = (TextView) this.findViewById(R.id.tv_parameter_main);
        ivSetting = (ImageView) this.findViewById(R.id.iv_setting);

        tv_timing_main.setOnClickListener(new MyOnClickListener());
        tv_debug_main.setOnClickListener(new MyOnClickListener());
        tv_parameter_main.setOnClickListener(new MyOnClickListener());
        ivSetting.setOnClickListener(new ClickListener());
    }


    private String getDate() {
        String time = "";
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        time = formatter.format(new Date(System.currentTimeMillis()));
        return time;
    }

    class MyOnClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            int position = 0;
            if (v == tv_timing_main) {
                position = 0;
            } else if (v == tv_parameter_main) {
                position = 1;
            } else if (v == tv_debug_main) {
                position = 2;
            }
            Intent intent = new Intent(MainAct.this, ControlAct.class);
            intent.putExtra("position", position + "");
            startActivity(intent);
        }
    }

    class ClickListener implements View.OnClickListener {

        @Override
        public void onClick(View v) {
            if (v == ivSetting) {
                Intent settingIntent = new Intent(MainAct.this, SettingAct.class);
                startActivity(settingIntent);
            }

        }
    }

}
