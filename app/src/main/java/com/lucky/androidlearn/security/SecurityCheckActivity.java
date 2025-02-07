package com.lucky.androidlearn.security;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.jingewenku.abrahamcaijin.commonutil.AppToastMgr;
import com.lucky.androidlearn.R;

// 应用的安全信息检查
public class SecurityCheckActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mBtnCheckNetworkProxy;
    private Button mBtnCheckRoot;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_security_check);
        mBtnCheckNetworkProxy = findViewById(R.id.btn_check_proxy);
        mBtnCheckNetworkProxy.setOnClickListener(this);

        mBtnCheckRoot = findViewById(R.id.btn_check_root);
        mBtnCheckRoot.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.btn_check_proxy:
                boolean isProxy = NetWorkProxy.getInstance(this).isWifiProxy();
                AppToastMgr.shortToast(this, isProxy ? "使用代理中" : "没有使用代理");
                break;
            case R.id.btn_check_root:
                if (MobileRoot.isRoot()){
                    AppToastMgr.shortToast(this, "该手机已经被Root了");
                } else{
                    AppToastMgr.shortToast(this, "该手机没有被Root");
                }
                break;

        }
    }
}
