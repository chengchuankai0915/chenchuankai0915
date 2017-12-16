package fourteam.cck.com.fourteam.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.adapter.FindAdapter;
import fourteam.cck.com.fourteam.bean.FindBean;
import fourteam.cck.com.fourteam.cck.presenter.FindPresenter;
import fourteam.cck.com.fourteam.cck.presenter.FindPresenterImpl;
import fourteam.cck.com.fourteam.cck.view.FindView;

public class FindActivity extends AppCompatActivity implements FindView {

    private ImageView mFanhuif;
    /**
     * 请输入您喜欢的电影
     */
    private EditText mEtFind;
    /**
     * 搜索
     */
    private TextView mTvSousuo;
    private RecyclerView mRv;
    private int pnum= 1;
    private FindAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_find);
        initView();


        //给搜索按钮设置点击事件
        mTvSousuo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String string = mEtFind.getText().toString();
                if (!string.equals("")){
                    FindPresenter findPresenter=new FindPresenterImpl(FindActivity.this);
                    findPresenter.guanlian(string,pnum);
                }else {
                    Toast.makeText(FindActivity.this,"请输入内容",Toast.LENGTH_SHORT).show();
                }

            }
        });
        //返回按钮的点击事件
        mFanhuif.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    @Override
    public void showDate(FindBean findBean) {
        String msg = findBean.getMsg();
        Log.e("xxx", "搜索---" + msg);
        List<FindBean.RetBean.ListBean> list = findBean.getRet().getList();
        mRv.setLayoutManager(new GridLayoutManager(FindActivity.this,3));
        FindAdapter adapter = new FindAdapter(FindActivity.this,list);
        mRv.setAdapter(adapter);
    }


    private void initView() {
        mFanhuif = (ImageView) findViewById(R.id.iv_back);
        mEtFind = (EditText) findViewById(R.id.et_find);
        mTvSousuo = (TextView) findViewById(R.id.tv_sousuo);
        mRv = (RecyclerView) findViewById(R.id.rv);
    }
}
