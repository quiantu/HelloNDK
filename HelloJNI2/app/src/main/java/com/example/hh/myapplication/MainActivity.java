package com.example.hh.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int i= 0;
    TextView tv;
    Button button;
    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Example of a call to a native method
        tv = (TextView) findViewById(R.id.sample_text);
        tv.setText(urlprotocolinfo());

        button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                switch (i){
                    case 0:
                        i++;
                        tv.setText(urlprotocolinfo());
                        break;
                    case 1:
                        i++;
                        tv.setText(avformatinfo());
                        break;
                    case 2:
                        i++;
                        tv.setText(avcodecinfo());
                        break;
                    case 3:
                        i++;
                        tv.setText(avfilterinfo());
                        break;
                    case 4:
                        i++;
                        tv.setText(configurationinfo());
                        break;
                    case 5:
                        i = 0;
                        break;
                    default:
                        i = 0;
                        break;
                }
            }
        });
    }

    /**
     * A native method that is implemented by the 'native-lib' native library,
     * which is packaged with this application.
     */
    public native String urlprotocolinfo();
    public native String avformatinfo();
    public native String avcodecinfo();
    public native String avfilterinfo();
    public native String configurationinfo();
    // Used to load the 'native-lib' library on application startup.
    static {
        System.loadLibrary("test");
        System.loadLibrary("avutil-55");
        System.loadLibrary("swresample-2");
        System.loadLibrary("avcodec-57");
        System.loadLibrary("avformat-57");
        System.loadLibrary("swscale-4");
        System.loadLibrary("postproc-54");
        System.loadLibrary("avfilter-6");
        System.loadLibrary("avdevice-57");
    }
}
