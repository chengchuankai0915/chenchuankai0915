package fourteam.cck.com.fourteam.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.bean.ChoicenessBean;
import fourteam.cck.com.fourteam.cck.presenter.ChoicenessPresenterImpl;
import fourteam.cck.com.fourteam.cck.view.ChoicenessView;
import fourteam.cck.com.fourteam.csh.FilmLibraryActivity;
import fourteam.cck.com.fourteam.csh.adapter.SpecialAdapter;

/**
 * Created by C-PC on 2017/12/13.
 */
public class SpecialFragment extends Fragment implements ChoicenessView{

    private RecyclerView recyc_special;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_fragment, null);
        //找控件
        recyc_special = view.findViewById(R.id.recyc_special);
        //关联
        ChoicenessPresenterImpl choicenessPresenter=new ChoicenessPresenterImpl(this);
        choicenessPresenter.guanlian();

        return view;
    }

    @Override
    public void showData(final ChoicenessBean choicenessBean) {
        Log.i("aaa","111"+choicenessBean.getMsg());
        List<ChoicenessBean.RetBean.ListBean> sp_list = choicenessBean.getRet().getList();

        recyc_special.setLayoutManager(new GridLayoutManager(getActivity(),2));
        SpecialAdapter adapter=new SpecialAdapter(getActivity(),sp_list);
        recyc_special.setAdapter(adapter);
        adapter.setOnRecyclerListener(new SpecialAdapter.OnRecyclerListener() {

            private String moreURL;

            @Override
            public void onRecycler(int position) {
                moreURL = choicenessBean.getRet().getList().get(position).getMoreURL();

                if(moreURL.equals("")){
                    moreURL = "http://api.svipmovie.com/front/columns/getVideoList.do?catalogId=ff8080815b9075a6015b94ef79dc0284&information=null";
                }

                Intent intent=new Intent(getActivity(), FilmLibraryActivity.class);
                intent.putExtra("moreURL",moreURL);

                startActivity(intent);
            }
        });

    }
}
