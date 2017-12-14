package fourteam.cck.com.fourteam.cck.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import fourteam.cck.com.fourteam.R;

/**
 * Created by C-PC on 2017/12/14.
 */

public class CommentFragment extends Fragment{
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.comment_fragment, null);
        return view;
    }
}
