package com.bwf;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.zhy.http.okhttp.OkHttpUtils;
import com.zhy.http.okhttp.callback.Callback;
import com.zhy.http.okhttp.callback.StringCallback;

import okhttp3.Call;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        String string="http://www.csdn.net/";
        OkHttpUtils.get()
                    .url(string)
                    .build()
                    .execute(new StringCallback() {
                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(String response, int id) {
                            Toast.makeText(MainActivity.this,response,Toast.LENGTH_SHORT).show();
                        }
                    });

        OkHttpUtils.post()
                    .url(string)
                    .build()
                    .execute(new Callback() {
                        @Override
                        public Object parseNetworkResponse(Response response, int id) throws Exception {
                            return null;
                        }

                        @Override
                        public void onError(Call call, Exception e, int id) {

                        }

                        @Override
                        public void onResponse(Object response, int id) {

                        }
                    });
    }
}
