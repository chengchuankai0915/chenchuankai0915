package fourteam.cck.com.fourteam.fragment;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.youth.banner.Banner;
import com.youth.banner.listener.OnBannerClickListener;

import java.util.ArrayList;
import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.activity.FindActivity;
import fourteam.cck.com.fourteam.activity.XiangQingActivity;
import fourteam.cck.com.fourteam.adapter.ChoicenessAdapter;
import fourteam.cck.com.fourteam.bean.ChoicenessBean;
import fourteam.cck.com.fourteam.cck.presenter.ChoicenessPresenterImpl;
import fourteam.cck.com.fourteam.cck.view.ChoicenessView;
import fourteam.cck.com.fourteam.util.FrescoImageLoader;

/**
 * Created by C-PC on 2017/12/13.
 * 精选页面fragment
 */

public class ChoicenessFragment extends Fragment implements ChoicenessView{
    private View view;
    private Banner mBanner;
    /**
     * 一念天堂
     */
    private RecyclerView mRvList;
    List<String> list=new ArrayList<>();
    private RelativeLayout find;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choiceness_fragment, null);
        find = view.findViewById(R.id.find);
        initView(view);
        ChoicenessPresenterImpl choicenessPresenter=new ChoicenessPresenterImpl(this);
        choicenessPresenter.guanlian();
        //搜索跳转
        find.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getActivity(), FindActivity.class);
                startActivity(intent);
            }
        });
        return view;
    }

    private void initView(View view) {
        mBanner = (Banner) view.findViewById(R.id.banner);
        mRvList = (RecyclerView) view.findViewById(R.id.rv_list);
    }

    @Override
    public void showData(final ChoicenessBean choicenessBean) {
        String msg = choicenessBean.getMsg();
        Log.i("xxx", msg);
        final List<ChoicenessBean.RetBean.ListBean.ChildListBean> childList = choicenessBean.getRet().getList().get(10).getChildList();
        for (int i = 0; i < childList.size(); i++) {
            String pic = childList.get(i).getPic();
            list.add(pic);
        }
        //设置图片加载器
        mBanner.setImageLoader(new FrescoImageLoader());
        //设置图片集合
        mBanner.setImages(list);
        //设置轮播时间
        mBanner.setDelayTime(3000);
        //banner设置方法全部调用完毕时最后调用
        mBanner.start();
        //banner点击事件
        mBanner.setOnBannerClickListener(new OnBannerClickListener() {
            @Override
            public void OnBannerClick(int position) {
                //List<ChoicenessBean.RetBean.ListBean.ChildListBean> list = choicenessBean.getRet().getList().get(10).getChildList();
                String title=childList.get(position).getTitle();
                String loadURL = childList.get(position).getLoadURL();
                Toast.makeText(getActivity(),title,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(), XiangQingActivity.class);
                intent.putExtra("loadURL",loadURL);
                //intent.putExtra("dataId",dataId);
                startActivity(intent);
            }
        });
        mRvList.setLayoutManager(new LinearLayoutManager(getActivity()));
        //实例化adapter对象
        List<ChoicenessBean.RetBean.ListBean.ChildListBean> Rvlist = choicenessBean.getRet().getList().get(4).getChildList();
        ChoicenessAdapter choicenessAdapter = new ChoicenessAdapter(getActivity(), Rvlist);
        mRvList.setAdapter(choicenessAdapter);
        choicenessAdapter.setOnGoodsListener(new ChoicenessAdapter.OnGoodsListener() {
            @Override
            public void onChildItemClick(ChoicenessBean.RetBean.ListBean.ChildListBean Rvlist) {
                String title = Rvlist.getTitle();
                String loadURL = Rvlist.getLoadURL();
                String dataId = Rvlist.getDataId();
                Rvlist.getAirTime();
               // String dataId = childList.get(position).getDataId();
                Log.e("zzz",dataId);
                SharedPreferences sharedPreferences=getActivity().getSharedPreferences("ID", Context.MODE_PRIVATE);
                SharedPreferences.Editor edit = sharedPreferences.edit();
                edit.putString("dataId",dataId);
                edit.commit();
                Toast.makeText(getActivity(),title,Toast.LENGTH_SHORT).show();
                Intent intent=new Intent(getActivity(), XiangQingActivity.class);
                intent.putExtra("title",title);
                intent.putExtra("loadURL",loadURL);
                intent.putExtra("dataId",dataId);
                startActivity(intent);
            }
        });

    }
}
