package com.example.fill_ter;

//import android.support.v7.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.Window;
import android.view.WindowManager;

import com.example.fill_ter.MainActivity;
import com.example.fill_ter.BaseActivity;
import com.example.fill_ter.R;

public class LogoActivity extends BaseActivity {
    private final int SPLACH_DISPLAY_LENGTH = 2000;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_logo);
        subThread st = new subThread();
        st.start();
    }

    class subThread extends Thread{
        public subThread(){super();}
        @Override
        public void run(){
            try{
                Thread.sleep(SPLACH_DISPLAY_LENGTH);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
            Log.d("splash 화면","splash종료");
            newStartActivity(LoginActivity.class);
            finish();
        }

    }
}