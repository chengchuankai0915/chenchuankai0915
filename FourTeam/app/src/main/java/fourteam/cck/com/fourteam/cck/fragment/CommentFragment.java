package fourteam.cck.com.fourteam.cck.fragment;

import android.content.Context;
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
import android.widget.Toast;

import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.adapter.CommentAdapter;
import fourteam.cck.com.fourteam.bean.CommentBean;
import fourteam.cck.com.fourteam.cck.presenter.CommentPresenter;
import fourteam.cck.com.fourteam.cck.presenter.CommentPresenterImpl;
import fourteam.cck.com.fourteam.cck.view.PingJiaView;

/**
 * Created by C-PC on 2017/12/14.
 */

public class CommentFragment extends Fragment implements PingJiaView {
    private View view;
    private RecyclerView mRv;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comment_fragment, null);
        SharedPreferences sharedPreferences = getActivity().getSharedPreferences("ID", Context.MODE_PRIVATE);
        String dataId = sharedPreferences.getString("dataId", "dataId");
        Toast.makeText(getActivity(), dataId, Toast.LENGTH_SHORT).show();
        Log.i("xxx", "Dataid------" + dataId);
        //getNetComment();
        CommentPresenter commentPresenter = new CommentPresenterImpl(this);
        commentPresenter.guanlian(dataId);
        initView(view);


        return view;
    }


    @Override
    public void showData(CommentBean commentBean) {
        mRv.setLayoutManager(new LinearLayoutManager(getActivity()));
        String msg = commentBean.getMsg();
        List<CommentBean.RetBean.ListBean> list = commentBean.getRet().getList();
        Log.e("zzz", msg);
        CommentAdapter adapter = new CommentAdapter(getActivity(),list);
        mRv.setAdapter(adapter);
    }

    private void initView(View view) {
        mRv = (RecyclerView) view.findViewById(R.id.rv);
    }
}
