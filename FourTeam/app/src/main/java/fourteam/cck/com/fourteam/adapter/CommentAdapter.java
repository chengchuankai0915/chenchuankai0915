package fourteam.cck.com.fourteam.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.bean.CommentBean;

/**
 * Created by C-PC on 2017/12/15.
 */

public class CommentAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<CommentBean.RetBean.ListBean> listBeen;

    public CommentAdapter(Context context, List<CommentBean.RetBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.comment_item, parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        String number = listBeen.get(position).getPhoneNumber();
        String time = listBeen.get(position).getTime();
        String msg = listBeen.get(position).getMsg();
        int likeNum = listBeen.get(position).getLikeNum();
        myViewHolder.tv1.setText(number);
        myViewHolder.tv2.setText(time);
        myViewHolder.tv3.setText(msg);
        myViewHolder.tv4.setText(likeNum+"");
    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        private final TextView tv1;
        private final TextView tv2;
        private final TextView tv3;
        private final TextView tv4;
        public MyViewHolder(View itemView) {
            super(itemView);
            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            tv4 = itemView.findViewById(R.id.tv4);
        }
    }
}
