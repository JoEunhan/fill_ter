package com.example.fill_ter;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.RelativeLayout;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class LoginActivity extends BaseActivity implements View.OnClickListener,View.OnLongClickListener {
    @BindView(R.id.loginlayout)
    RelativeLayout loginlayout;


    @BindView(R.id.find_idpw) Button find_idpw;
    @BindView(R.id.login) Button login;

    Context context = this;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        ButterKnife.bind(this);
        connectOnClickListner();
        login.setOnLongClickListener(this);
        find_idpw.setOnLongClickListener(this);
    }


    public List<View> getAllButtons(ViewGroup layout){
        List<View> viewList = new ArrayList<>();
        for(int i =0; i< layout.getChildCount(); i++){
            View v =layout.getChildAt(i); //해당 테이블로우 전부 가져오기
            viewList.addAll(v.getTouchables()); //해당 테이블로우의 버튼 id 전부 가져오기
        }
        return viewList;
    }
    private void connectOnClickListner() {
        Log.d("test","========================= connectOnClickListener =======================");

        List<View> btnList = getAllButtons(loginlayout);
        for (View btn:btnList) {
            btn.setOnClickListener(this);
        }
    }
    @Override
    public void onClick(View v) {
        switch(v.getId()){
            case R.id.login:
                toastShow("로그인 되었습니다.");
                newStartActivity(MainActivity.class);
                break;
            case R.id.find_idpw:
                toastShow("이메일 주소를 통해 계정을 찾으세요.");
                newStartActivity(Find_Account_Activity.class);
                break;
        }
    }

    @Override
    public boolean onLongClick(View v) {
        switch(v.getId()){
            case R.id.login:
                toastShow("로그인 되었습니다.");
                newStartActivity(MainActivity.class);
                break;
            case R.id.find_idpw:
                toastShow("이메일 주소를 통해 계정을 찾으세요.");
                newStartActivity(Find_Account_Activity.class);
                break;
        }
        return true;
    }
}