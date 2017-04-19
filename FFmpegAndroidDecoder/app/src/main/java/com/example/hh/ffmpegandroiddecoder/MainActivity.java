package com.example.hh.ffmpegandroiddecoder;

import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editText, editText2;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = (Button) findViewById(R.id.sample_Button);
        editText = (EditText)findViewById(R.id.editText);
        editText2 = (EditText)findViewById(R.id.editText2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String folderurl= Environment.getExternalStorageDirectory().getPath();
                String editTextstr = editText.getText().toString().trim();
                String editTextstr2 = editText2.getText().toString().trim();
                Log.v("FFmpeg",folderurl + "editTextstr" +editTextstr+"@"+editTextstr2);
                decoder(folderurl + "/"+editTextstr, folderurl+"/" +editTextstr2);
            }
        });
    }
    public native int decoder(String inputurl, String outputurl);
    static{
        System.loadLibrary("avutil-54");
        System.loadLibrary("swresample-1");
        System.loadLibrary("avcodec-56");
        System.loadLibrary("avformat-56");
        System.loadLibrary("swscale-3");
        System.loadLibrary("postproc-53");
        System.loadLibrary("avfilter-5");
        System.loadLibrary("avdevice-56");
        System.loadLibrary("decoder-lib");
    }
}
