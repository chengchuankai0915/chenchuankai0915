package fourteam.cck.com.fourteam.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.astuetz.PagerSlidingTabStrip;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.bean.BaseBean;
import fourteam.cck.com.fourteam.bean.XiangQingBean;
import fourteam.cck.com.fourteam.cck.fragment.CommentFragment;
import fourteam.cck.com.fourteam.cck.fragment.JianJieFragment;
import fourteam.cck.com.fourteam.ok.HttpUtils;
import fourteam.cck.com.fourteam.ok.OnNetListener;
import tv.danmaku.ijk.media.widget.media.AndroidMediaController;
import tv.danmaku.ijk.media.widget.media.IjkVideoView;

import static fourteam.cck.com.fourteam.R.id.vp;

public class XiangQingActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIvBack;
    /**
     * 加载中...
     */
    private TextView mTvTitle;
    private IjkVideoView mIvv;
    private PagerSlidingTabStrip mTabs;
    private ViewPager mVp;
    private String loadURL;
    private String title;
    private String[] names = {"简介","评论"};
    //private int indicatorColor = 6064384;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xiang_qing);
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
        initView();
        Intent intent = getIntent();
        loadURL = intent.getStringExtra("loadURL");
        title = intent.getStringExtra("title");
        //设置标题
        mTvTitle.setText(title);
        //请求详情地址
        getNet();
        //向ViewPager绑定PagerSlidingTabStrip
        mVp.setAdapter(new MyPagerAdapter(getSupportFragmentManager()));
        mTabs.setViewPager(mVp);


    }

    private void initView() {
        mIvBack = (ImageView) findViewById(R.id.iv_back);
        mIvBack.setOnClickListener(this);
        mTvTitle = (TextView) findViewById(R.id.tv_title);
        mTvTitle.setOnClickListener(this);
        mIvv = (IjkVideoView) findViewById(R.id.ivv);
        mIvv.setOnClickListener(this);
        mTabs = (PagerSlidingTabStrip) findViewById(R.id.tabs);
        mTabs.setOnClickListener(this);
        mVp = (ViewPager) findViewById(vp);
        mVp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.iv_back:
                break;
            case R.id.tv_title:
                break;
            case R.id.ivv:
                break;
            case R.id.tabs:
                break;
            case vp:
                break;
        }
    }

    public void getNet(){
        HttpUtils.getInstance().doget(loadURL, XiangQingBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                XiangQingBean bean= (XiangQingBean) baseBean;
                String director = bean.getRet().getDirector();
                String actors = bean.getRet().getActors();
                XiangQingBean.RetBean ret = bean.getRet();
                SharedPreferences sharedPreferences=getSharedPreferences("BEAN",MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("loadURL", loadURL);
                edit.commit();
                String hdurl = bean.getRet().getHDURL();
                AndroidMediaController controller = new AndroidMediaController(XiangQingActivity.this, false);
                mIvv.setMediaController(controller);
                //String url = "https://wdl.wallstreetcn.com/41aae4d2-390a-48ff-9230-ee865552e72d";
                // String url = "http://o6wf52jln.bkt.clouddn.com/演员.mp3";
                mIvv.setVideoURI(Uri.parse(hdurl));
                mIvv.start();
            }
            @Override
            public void onError() {

            }
        });
    }




    //适配器
    class MyPagerAdapter extends FragmentPagerAdapter {

        public MyPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            String name = names[position];
            return name;
        }

        @Override
        public Fragment getItem(int position) {
            Fragment fragment=null;
            switch (position){
                case 0:
                    fragment = new JianJieFragment();
                    break;
                case 1:
                    fragment = new CommentFragment();
                    break;
            }
            return fragment;
        }

        @Override
        public int getCount() {
            return names.length;
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        this.finish();
    }
}
