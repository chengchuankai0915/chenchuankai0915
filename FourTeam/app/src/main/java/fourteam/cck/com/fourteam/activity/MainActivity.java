package fourteam.cck.com.fourteam.activity;

import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.hjm.bottomtabbar.BottomTabBar;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.fragment.ChoicenessFragment;
import fourteam.cck.com.fourteam.fragment.FindFragment;
import fourteam.cck.com.fourteam.fragment.MineFragment;
import fourteam.cck.com.fourteam.fragment.SpecialFragment;

public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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

    }

}
