package aninterface.ldgd.com.ldgdinterface.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;

import aninterface.ldgd.com.ldgdinterface.R;

public class LoginAct extends Activity {

    private Button btn_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);

        initView();

        btn_login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginAct.this, MainAct.class);
                startActivity(intent);
                LoginAct.this.finish();
            }
        });
    }

    private void initView() {

        btn_login = (Button) this.findViewById(R.id.btn_login);
    }
}
