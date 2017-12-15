package fourteam.cck.com.fourteam.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.mcxtzhang.layoutmanager.swipecard.CardConfig;
import com.mcxtzhang.layoutmanager.swipecard.OverLayCardLayoutManager;
import com.mcxtzhang.layoutmanager.swipecard.RenRenCallback;

import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.bean.BaseBean;
import fourteam.cck.com.fourteam.bean.FaXianBean;
import fourteam.cck.com.fourteam.gyz.findadapter.Find_Adapter;
import fourteam.cck.com.fourteam.gyz.findpresenter.Find_presenter;
import fourteam.cck.com.fourteam.gyz.findview.Find_View;

/**
 * Created by C-PC on 2017/12/13.
 */

public class FindFragment extends Fragment implements Find_View, View.OnClickListener {
    private View view;
    private RecyclerView mFindRv;
    /**
     * 换一批
     */
    private Button mFindBu;
private  int i=2;
    private Find_Adapter find_adapter;
    private FaXianBean faXianBean1;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.find_fragment, null);
        Find_presenter find_presenter = new Find_presenter(this);
        find_presenter.relevance("402834815584e463015584e539330016", "1");
        initView(view);
        return view;
    }

    private void initView(View view) {
        mFindRv = (RecyclerView) view.findViewById(R.id.find_rv);
        mFindBu = (Button) view.findViewById(R.id.find_bu);
        mFindBu.setOnClickListener(this);
    }

    @Override
    public void GetFindView(BaseBean faXianBean) {
        faXianBean1 = (FaXianBean) faXianBean;
        List<FaXianBean.RetBean.ListBean> list = faXianBean1.getRet().getList();
        find_adapter = new Find_Adapter(getActivity(), list);
        mFindRv.setLayoutManager(new OverLayCardLayoutManager());
        CardConfig.initConfig(getActivity());
        ItemTouchHelper.Callback callback = new RenRenCallback(mFindRv, find_adapter, list);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
        itemTouchHelper.attachToRecyclerView(mFindRv);
       // CardConfig.MAX_SHOW_COUNT = 4;
        mFindRv.setAdapter(find_adapter);
       find_adapter.setOnCilcklist(new Find_Adapter.OnCilcklist() {
           @Override
           public void Onsewssce(FaXianBean.RetBean.ListBean listBean) {

               Toast.makeText(getActivity(),listBean.getDataId(),Toast.LENGTH_LONG).show();
           }
       });
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.find_bu:
                int add = this.i++;
                //list = faXianBean1.getRet().getList();
                Find_presenter find_presenter = new Find_presenter(this);
                find_presenter.relevance("402834815584e463015584e539330016", add+"");
               /* mFindRv.setLayoutManager(new OverLayCardLayoutManager());
                find_adapter=       new Find_Adapter(getActivity(),list);
                CardConfig.initConfig(getActivity());
                ItemTouchHelper.Callback callback = new RenRenCallback(mFindRv, find_adapter, list);
                ItemTouchHelper itemTouchHelper = new ItemTouchHelper(callback);
                itemTouchHelper.attachToRecyclerView(mFindRv);
                CardConfig.MAX_SHOW_COUNT = 3;
                mFindRv.setAdapter(find_adapter);*/
                break;
        }
    }
}
