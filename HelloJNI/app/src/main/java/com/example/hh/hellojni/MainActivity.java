package com.example.hh.hellojni;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv;
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("native-lib");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(stringFromJNI());
        tv.setMovementMethod(new ScrollingMovementMethod());
    }
    public void protocolinfo(View v){
        tv.setText(urlprotocolinfo());
        tv.setMovementMethod(new ScrollingMovementMethod());
    }
    public void formatinfo(View v){
        tv.setText(avformatinfo());
        tv.setMovementMethod(new ScrollingMovementMethod());
    }
    public void codecinfo(View v){
        tv.setText(avcodecinfo());
        tv.setMovementMethod(new ScrollingMovementMethod());
    }
    public void filterinfo(View v){
        tv.setText(avfilterinfo());
        tv.setMovementMethod(new ScrollingMovementMethod());
    }
    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String stringFromJNI();
    public native String urlprotocolinfo();
    public native String avformatinfo();
    public native String avcodecinfo();
    public native String avfilterinfo();
}
