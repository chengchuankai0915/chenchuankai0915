package fourteam.cck.com.fourteam.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.bean.ChoicenessBean;

/**
 * Created by C-PC on 2017/12/14.
 */

public class ChoicenessAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<ChoicenessBean.RetBean.ListBean.ChildListBean> Rvlist;
    private OnGoodsListener onGoodsListener;

    public interface OnGoodsListener {
        public void onChildItemClick(ChoicenessBean.RetBean.ListBean.ChildListBean Rvlist);
    }

    public void setOnGoodsListener(OnGoodsListener onGoodsListener) {
        this.onGoodsListener = onGoodsListener;
    }


    public ChoicenessAdapter(Context context, List<ChoicenessBean.RetBean.ListBean.ChildListBean> rvlist) {
        this.context = context;
        Rvlist = rvlist;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.rvlist_item,parent,false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        String pic = Rvlist.get(position).getPic();
        Uri uri=Uri.parse(pic);
        myViewHolder.sdv_pic.setImageURI(uri);
        String title = Rvlist.get(position).getTitle();
        myViewHolder.tv_title.setText(title);
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onGoodsListener.onChildItemClick(Rvlist.get(position));
            }
        });
    }

    @Override
    public int getItemCount() {
        return Rvlist.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv_pic;
        private final TextView tv_title;
        private final LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv_pic = itemView.findViewById(R.id.sdv_pic);
            tv_title = itemView.findViewById(R.id.tv_title);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
