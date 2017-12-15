package fourteam.cck.com.fourteam.cck.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.adapter.GridAdapter;
import fourteam.cck.com.fourteam.bean.BaseBean;
import fourteam.cck.com.fourteam.bean.XiangQingBean;
import fourteam.cck.com.fourteam.ok.HttpUtils;
import fourteam.cck.com.fourteam.ok.OnNetListener;

/**
 * Created by C-PC on 2017/12/14.
 */

public class JianJieFragment extends Fragment {

    private View view;
    /**
     * 导演:
     */
    private TextView mName;
    /**
     * 主演:
     */
    private TextView mNames;
    private TextView mDescription;
    /**
     * 展开
     */
    private TextView mShow;
    private RecyclerView mGridRv;
    private String loadURL;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.jianjie_fragment, null);
        Intent intent = getActivity().getIntent();
        loadURL = intent.getStringExtra("loadURL");
        initView(view);
        getNet();
        return view;
    }

    public void getNet() {
        HttpUtils.getInstance().doget(loadURL, XiangQingBean.class, new OnNetListener() {
            @Override
            public void onSuccess(BaseBean baseBean) {
                XiangQingBean bean = (XiangQingBean) baseBean;
                String director = bean.getRet().getDirector();
                String actors = bean.getRet().getActors();
                mName.setText("导演:"+director);
                mNames.setText("主演:"+actors);
                List<XiangQingBean.RetBean.ListBean.ChildListBean> childList = bean.getRet().getList().get(0).getChildList();
                mGridRv.setLayoutManager(new GridLayoutManager(getActivity(),3));
                GridAdapter adapter = new GridAdapter(getActivity(),childList);
                mGridRv.setAdapter(adapter);

               /* adapter.setOnGoodsListener(new GridAdapter.OnGoodsListener() {
                    @Override
                    public void onChildItemClick(XiangQingBean.RetBean.ListBean.ChildListBean childListBean) {
                        String title = childListBean.getTitle();
                        Toast.makeText(getActivity(),title,Toast.LENGTH_SHORT).show();
                        String loadURL = childListBean.getLoadURL();
                        String dataId = childListBean.getDataId();
                        Intent intent=new Intent(getActivity(),XiangQingBean.class);
                        intent.putExtra("loadURL",loadURL);
                        startActivity(intent);
                    }
                });*/

            }

            @Override
            public void onError() {

            }
        });
    }


    private void initView(View view) {
        mName = (TextView) view.findViewById(R.id.name);
        mNames = (TextView) view.findViewById(R.id.names);
        mDescription = (TextView) view.findViewById(R.id.description);
        mShow = (TextView) view.findViewById(R.id.show);
        mGridRv = (RecyclerView) view.findViewById(R.id.grid_rv);
    }
}
