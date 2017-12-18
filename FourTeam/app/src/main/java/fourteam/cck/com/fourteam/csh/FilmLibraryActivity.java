package fourteam.cck.com.fourteam.csh;

import android.content.Intent;
<<<<<<< HEAD
import android.os.Bundle;
=======
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
>>>>>>> beff5e788cc2f24a6fd41f7593d5e71afde33294
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
<<<<<<< HEAD
import android.widget.ImageView;
import android.widget.TextView;
=======
>>>>>>> beff5e788cc2f24a6fd41f7593d5e71afde33294

import java.io.IOException;
import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.activity.XiangQingActivity;
import fourteam.cck.com.fourteam.csh.adapter.FilmAdapter;
import fourteam.cck.com.fourteam.csh.utils.OkHttpUtils;
import fourteam.cck.com.fourteam.csh.utils.OnNetListener;

public class FilmLibraryActivity extends AppCompatActivity {

    private RecyclerView film_recycler;
    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_film_library);
        //找控件
        film_recycler = (RecyclerView) findViewById(R.id.film_recycler);
        tv = (TextView) findViewById(R.id.tv_title);
        film_recycler.setLayoutManager(new GridLayoutManager(this,3));
<<<<<<< HEAD
       ImageView iv_back= (ImageView) findViewById(R.id.iv_back);

=======
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
>>>>>>> beff5e788cc2f24a6fd41f7593d5e71afde33294
        //获取moreURL
        Intent intent = getIntent();
        String moreURLs = intent.getStringExtra("moreURL");
        //给主题设置字体
        String title = intent.getStringExtra("title");
        tv.setText(title);

        iv_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });

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
