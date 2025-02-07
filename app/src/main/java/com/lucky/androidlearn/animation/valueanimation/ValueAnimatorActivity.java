package com.lucky.androidlearn.animation.valueanimation;

import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Interpolator;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.lucky.androidlearn.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by zfz on 2018/1/1.
 */

public class ValueAnimatorActivity extends AppCompatActivity {
    private static final String TAG = "ValueAnimatorActivity";
    @BindView(R.id.content)
    LinearLayout llContent;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_value_animation);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_value_animation)
    public void onValueAnimationClick(View view) {
        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 100);
        valueAnimator.setTarget(llContent);
        valueAnimator.setDuration(2000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Float value = (Float) animation.getAnimatedValue();
                Log.e(TAG, "onAnimationUpdate: value "+value);
            }
        });
        valueAnimator.start();
    }

    public class LLinearInterpolator implements Interpolator{


        @Override
        public float getInterpolation(float input) {
            return input;
        }
    }


    public class IntEvaluator implements TypeEvaluator<Integer>{


        @Override
        public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
            int startInt = startValue;
            return (int)(startInt+(endValue-startValue)*fraction);
        }
    }


}
