package fourteam.cck.com.fourteam.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fourteam.cck.com.fourteam.R;

/**
 * Created by C-PC on 2017/12/13.
 */

public class SpecialFragment extends Fragment{

    private RecyclerView recyc_special;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.special_fragment, null);
        //找控件
        recyc_special = view.findViewById(R.id.recyc_special);



        return view;
    }
}
