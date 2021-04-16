package kaka.com.jbox2dapp;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import kaka.com.jbox2dapp.widget.JboxView;


/**
 * Created by kaka on 2017/7/27.
 */
public class FirstActivity extends AppCompatActivity implements SensorEventListener {
    private JboxView jboxView;
    private SensorManager sensorManager;
    private Sensor defaultSensor;
    private int[] imgArr = {
            R.mipmap.medal1,
            R.mipmap.medal2,
            R.mipmap.medal3,
            R.mipmap.medal4,
            R.mipmap.medal5,
    };

    @Override
    public void onContentChanged() {
        jboxView = (JboxView) findViewById(R.id.jbox_view);
        initView();
        sensorManager = (SensorManager) getSystemService(Context.SENSOR_SERVICE);
        defaultSensor = sensorManager.getDefaultSensor(Sensor.TYPE_ACCELEROMETER);
    }

    private void initView() {
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(
                120, 120
        );
        layoutParams.gravity = Gravity.CENTER;
        for (int i = 0; i < imgArr.length * 5; i++) {
            ImageView imageView = new ImageView(this);
            imageView.setImageResource(imgArr[i % 5]);
            imageView.setTag(R.id.dn_view_circle_tag, true);
            jboxView.addView(imageView, layoutParams);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_layout);
    }

    @Override
    protected void onResume() {
        super.onResume();
        sensorManager.registerListener(this, defaultSensor, SensorManager.SENSOR_DELAY_UI);
    }

    @Override
    protected void onPause() {
        super.onPause();
        sensorManager.unregisterListener(this);
    }

    @Override
    public void onSensorChanged(SensorEvent event) {
        if (event.sensor.getType() == Sensor.TYPE_ACCELEROMETER) {
            float x = event.values[0] * 2f;
            float y = event.values[1] * 2f;
            if (Math.abs(x) + Math.abs(y) < 5f) {
                return;
            }
            jboxView.onSensorChanged(-x, y);
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}
