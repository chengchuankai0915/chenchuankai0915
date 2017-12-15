package fourteam.cck.com.fourteam.csh;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.io.IOException;
import java.util.List;

import fourteam.cck.com.fourteam.R;
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

        //获取moreURL
        Intent intent = getIntent();
        String moreURLs = intent.getStringExtra("moreURL");
        OkHttpUtils.getInstance(this).doget(moreURLs, FilmBean.class, new OnNetListener() {
            @Override
            public void onSuccess(Object o) throws IOException {
                FilmBean filmBean=(FilmBean)o;
                List<FilmBean.RetBean.ListBean> list = filmBean.getRet().getList();
                FilmAdapter adapter = new FilmAdapter(FilmLibraryActivity.this,list);
                film_recycler.setAdapter(adapter);

            }

            @Override
            public void onError(IOException e) {

            }
        });


    }
}
