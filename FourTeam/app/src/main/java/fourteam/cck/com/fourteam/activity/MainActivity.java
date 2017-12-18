package fourteam.cck.com.fourteam.activity;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;
import com.hjm.bottomtabbar.BottomTabBar;

import java.util.ArrayList;
import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.fragment.ChoicenessFragment;
import fourteam.cck.com.fourteam.fragment.FindFragment;
import fourteam.cck.com.fourteam.fragment.MineFragment;
import fourteam.cck.com.fourteam.fragment.SpecialFragment;

public class MainActivity extends AppCompatActivity{

    private List<String> list;
    private List<Integer> integerList;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //加载布局
        setContentView(R.layout.activity_main);



        //初始化组件
        BottomTabBar btb= (BottomTabBar) findViewById(R.id.btb);
        btb.init(getSupportFragmentManager())
                .setImgSize(50, 50)
                .setFontSize(14)
                .setTabPadding(4, 6, 10)
                .setChangeColor(Color.RED, Color.DKGRAY)
                .addTabItem("精选", R.drawable.tab_02, ChoicenessFragment.class)
                .addTabItem("专题", R.drawable.tab_03, SpecialFragment.class)
                .addTabItem("发现", R.drawable.tab_01, FindFragment.class)
                .addTabItem("我的", R.drawable.tab_04, MineFragment.class)
                .isShowDivider(false)
                .setOnTabChangeListener(new BottomTabBar.OnTabChangeListener() {
                    @Override
                    public void onTabChange(int position, String name) {

                    }
                });
        //沉浸室
        //第一种
 /*       View decorView = getWindow().getDecorView();
        int option = View.SYSTEM_UI_FLAG_FULLSCREEN;
        decorView.setSystemUiVisibility(option);
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/
        //第二种
      /*  if (Build.VERSION.SDK_INT >= 21) {
            View decorView = getWindow().getDecorView();
            int option = View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE;
            decorView.setSystemUiVisibility(option);
            getWindow().setStatusBarColor(Color.TRANSPARENT);
        }
        ActionBar actionBar = getSupportActionBar();
        actionBar.hide();*/
        //第三种
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

        initW();

    }

    private void initW() {
        SimpleDraweeView ce_sdv = (SimpleDraweeView) findViewById(R.id.ce_sdv);
        ce_sdv.setImageURI("http://f.hiphotos.baidu.com/image/pic/item/0df3d7ca7bcb0a46f7988bf36263f6246a60af45.jpg");

        TextView ce_tv = (TextView) findViewById(R.id.ce_tv);
        ce_tv.setText("微影"+" , "+"微一下");
        ListView listView = (ListView) findViewById(R.id.listview);
        list=new ArrayList<>();
        integerList=new ArrayList<>();
        list.add("我的收藏");
        list.add("我的下载");
        list.add("福利");
        list.add("分享");
        list.add("建议反馈");
        list.add("设置");

        integerList.add(R.drawable.aa);
        integerList.add(R.drawable.bb);
        integerList.add(R.drawable.cc);
        integerList.add(R.drawable.dd);
        integerList.add(R.drawable.my);
        integerList.add(R.drawable.collection_select);

        listView.setAdapter(new MyAdapter());
    }

    public class MyAdapter extends BaseAdapter {
        /*private List<String> list;
        private Context context;

        public MyAdapter(List<String> list, Context context) {
            this.list = list;
            this.context = context;
        }*/

        @Override
        public int getCount() {
            return list.size();
        }

        @Override
        public Object getItem(int i) {
            return list.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            View v = View.inflate(MainActivity.this, R.layout.list_item, null);
            TextView item_tvv = v.findViewById(R.id.item_tvv);
            item_tvv.setText(list.get(i));
            ImageView item_ivv = v.findViewById(R.id.item_ivv);
            item_ivv.setImageResource(integerList.get(i));
            return v;
        }
    }

}
