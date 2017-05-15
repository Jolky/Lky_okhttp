package com.okhttp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.squareup.okhttp.Call;
import com.squareup.okhttp.Callback;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void doGet(View view){
        //1.拿到okHttpClient
        OkHttpClient okHttpClient = new OkHttpClient();
        //2.构建Request
        Request.Builder builder = new Request.Builder();
        Request request = builder.get().url("http://www.imooc.com/").build();
        //3.将Request封装为Call
        Call call = okHttpClient.newCall(request);
        //4.执行call
        call.enqueue(new Callback() {
            @Override
            public void onFailure(Request request, IOException e) {
                Log.e(TAG, "onFailure: " + e.getMessage() );
                e.printStackTrace();
            }

            @Override
            public void onResponse(Response response) throws IOException {
                String res = response.body().string();
                Log.d(TAG, "onResponse: + res");
            }
        });


    }
}
