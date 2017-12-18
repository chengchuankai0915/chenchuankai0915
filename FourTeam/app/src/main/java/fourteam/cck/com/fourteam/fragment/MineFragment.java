package fourteam.cck.com.fourteam.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridView;
import android.widget.LinearLayout;
import android.widget.Toast;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.activity.LishiActivity;

/**
 * Created by C-PC on 2017/12/13.
 */

public class MineFragment extends Fragment {
    private LinearLayout lishi;
    private GridView gv;
    private LinearLayout huancun;
    private LinearLayout shoucang;
    private LinearLayout zhuti;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.mine_fragment, null);


        initView(view);
        return view;
    }

    private void initView(View view) {
        lishi = (LinearLayout) view.findViewById(R.id.lishi);
        gv = (GridView) view.findViewById(R.id.gv);
        huancun = (LinearLayout) view.findViewById(R.id.huancun);
        shoucang = (LinearLayout) view.findViewById(R.id.shoucang);
        zhuti = (LinearLayout) view.findViewById(R.id.zhuti);

        lishi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), LishiActivity.class));
            }
        });
        huancun.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "敬请期待", Toast.LENGTH_SHORT).show();
            }
        });
        shoucang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getContext(), "敬请期待", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
