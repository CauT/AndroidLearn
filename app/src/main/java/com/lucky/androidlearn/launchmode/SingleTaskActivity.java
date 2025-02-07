package com.lucky.androidlearn.launchmode;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lucky.androidlearn.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zfz on 2017/11/26.
 */

public class SingleTaskActivity extends AppCompatActivity {

    private static final String TAG = "SingleTaskActivity";

    @BindView(R.id.tv_instance_name)
    TextView tvInstanceName;

    @BindView(R.id.tv_task_id)
    TextView tvTaskID;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singletask);
        ButterKnife.bind(this);
        tvInstanceName.setText(this.toString());
        tvTaskID.setText(String.format("TaskID %s", getTaskId()));
    }

    @OnClick(R.id.btn_standard)
    public void onStandardClick(View view){
        Intent intent = new Intent(this, StandardActivity.class);
        startActivity(intent);
    }


    @OnClick(R.id.btn_singletask)
    public void onSingleTaskClick(View view){
        Intent intent = new Intent(this, SingleTaskActivity.class);
        startActivity(intent);
    }

    @Override
    protected void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        Log.e(TAG, "onNewIntent: ");
    }

}
