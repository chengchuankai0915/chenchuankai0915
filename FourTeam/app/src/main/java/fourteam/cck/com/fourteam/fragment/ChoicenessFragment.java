package fourteam.cck.com.fourteam.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import com.youth.banner.Banner;

import fourteam.cck.com.fourteam.R;

/**
 * Created by C-PC on 2017/12/13.
 * 精选页面fragment
 */

public class ChoicenessFragment extends Fragment {
    private View view;
    private Banner mBanner;
    /**
     * 一念天堂
     */
    private EditText mEtFind;
    private RecyclerView mRvList;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.choiceness_fragment, null);
        initView(view);

        return view;
    }

    private void initView(View view) {
        mBanner = (Banner) view.findViewById(R.id.banner);
        mEtFind = (EditText) view.findViewById(R.id.et_find);
        mRvList = (RecyclerView) view.findViewById(R.id.rv_list);
    }
}
