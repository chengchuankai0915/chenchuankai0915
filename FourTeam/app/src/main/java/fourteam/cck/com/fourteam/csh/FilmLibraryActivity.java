package fourteam.cck.com.fourteam.csh;

import android.content.Intent;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import java.io.IOException;
import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.activity.XiangQingActivity;
import fourteam.cck.com.fourteam.csh.adapter.FilmAdapter;
import fourteam.cck.com.fourteam.csh.utils.OkHttpUtils;
import fourteam.cck.com.fourteam.csh.utils.OnNetListener;

public class FilmLibraryActivity extends AppCompatActivity {

    private RecyclerView film_recycler;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_library);
        //找控件
        film_recycler = (RecyclerView) findViewById(R.id.film_recycler);

        film_recycler.setLayoutManager(new GridLayoutManager(this,3));
        //沉浸室
        if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setNavigationBarColor(Color.TRANSPARENT);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();
        //获取moreURL
        Intent intent = getIntent();
        String moreURLs = intent.getStringExtra("moreURL");
        OkHttpUtils.getInstance(this).doget(moreURLs, FilmBean.class, new OnNetListener() {
            @Override
            public void onSuccess(Object o) throws IOException {
                final FilmBean filmBean=(FilmBean)o;
                List<FilmBean.RetBean.ListBean> list = filmBean.getRet().getList();
                FilmAdapter adapter = new FilmAdapter(FilmLibraryActivity.this,list);
                film_recycler.setAdapter(adapter);
                adapter.setOnRecyclerListener(new FilmAdapter.OnRecyclerListener() {
                    @Override
                    public void onRecycler(int position) {
                        Intent intent1 = new Intent(FilmLibraryActivity.this, XiangQingActivity.class);
                        intent1.putExtra("loadURL",filmBean.getRet().getList().get(position).getLoadURL());
                        startActivity(intent1);

                    }
                });

            }

            @Override
            public void onError(IOException e) {

            }
        });


    }
}
