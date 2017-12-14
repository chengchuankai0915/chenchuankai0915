package fourteam.cck.com.fourteam.ok;

import android.os.Handler;
import android.os.Looper;

import com.google.gson.Gson;

import java.io.IOException;
import java.util.Map;

import fourteam.cck.com.fourteam.bean.BaseBean;
import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;


/**
 * Created by C-PC on 2017/10/19.
 */

public class HttpUtils implements IHttpListener {
    private OkHttpClient client;
    private final Handler handler;
    private static HttpUtils httpUtils;

    private HttpUtils() {
        handler = new Handler(Looper.getMainLooper());
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY);
        client = new OkHttpClient.Builder()
                .addInterceptor(interceptor)
                .build();
    }


    //单例模式
    public static HttpUtils getInstance() {
        if (httpUtils == null) {
            synchronized (HttpUtils.class) {
                if (httpUtils == null) {
                    httpUtils = new HttpUtils();
                }
            }
        }
        return httpUtils;
    }

    /**
     * post请求
     */
    public void doPost(String url, Map<String, String> params, final Class clazz, final OnNetListener onNetListener) {
        FormBody.Builder builder = new FormBody.Builder();
        if (params != null && params.size() > 0) {
            for (Map.Entry<String, String> entry : params.entrySet()) {
                builder.add(entry.getKey(), entry.getValue());
            }
        }
        FormBody formBody = builder.build();
        Request request = new Request.Builder().url(url).post(formBody).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                handler.post(new Runnable() {
                    String string = response.body().string();

                    @Override
                    public void run() {
                        BaseBean baseBean = (BaseBean) new Gson().fromJson(string, clazz);
                        String code = baseBean.getCode();
                        if (code.equals("200")) {
                            onNetListener.onSuccess(baseBean);
                        } else {

                        }


                    }
                });
            }
        });
    }


    /**
     * Get请求
     *
     * @param url
     * @param clazz
     * @param onNetListener
     */
    public void doget(String url, final Class clazz, final OnNetListener onNetListener) {
        Request request = new Request.Builder().url(url).build();
        client.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                    }
                });
            }

            @Override
            public void onResponse(Call call, final Response response) throws IOException {
                final String string = response.body().string();
                handler.post(new Runnable() {
                    @Override
                    public void run() {

                        BaseBean baseBean = (BaseBean) new Gson().fromJson(string, clazz);
                        String code = baseBean.getCode();
                        if (code.equals("200")) {
                            onNetListener.onSuccess(baseBean);
                        } else {

                        }

                    }
                });
            }
        });
    }


}
