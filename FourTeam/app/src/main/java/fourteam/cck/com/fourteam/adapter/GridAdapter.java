package fourteam.cck.com.fourteam.adapter;

import android.content.Context;
import android.content.Intent;
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
import fourteam.cck.com.fourteam.activity.XiangQingActivity;
import fourteam.cck.com.fourteam.bean.XiangQingBean;

/**
 * Created by C-PC on 2017/12/15.
 */

public class GridAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>{
    private Context context;
    private List<XiangQingBean.RetBean.ListBean.ChildListBean> childList;
    private OnGoodsListener onGoodsListener;
    public interface OnGoodsListener {
        public void onChildItemClick(XiangQingBean.RetBean.ListBean.ChildListBean childListBean);
    }

    public void setOnGoodsListener(OnGoodsListener onGoodsListener) {
        this.onGoodsListener = onGoodsListener;
    }



    public GridAdapter(Context context, List<XiangQingBean.RetBean.ListBean.ChildListBean> childList) {
        this.context = context;
        this.childList = childList;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.grid_item, null);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
        MyViewHolder myViewHolder= (MyViewHolder) holder;
        String pic = childList.get(position).getPic();
        String title = childList.get(position).getTitle();
        final String loadURL = childList.get(position).getLoadURL();
        Uri uri=Uri.parse(pic);
        myViewHolder.sdv.setImageURI(uri);
        myViewHolder.tv_name.setText(title);
        myViewHolder.ll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //onGoodsListener.onChildItemClick(childList.get(position));
                Intent intent=new Intent(context, XiangQingActivity.class);
                intent.putExtra("loadURL",loadURL);
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return childList.size();
    }
    class MyViewHolder extends RecyclerView.ViewHolder {

        private final SimpleDraweeView sdv;
        private final TextView tv_name;
        private final LinearLayout ll;

        public MyViewHolder(View itemView) {
            super(itemView);
            sdv = itemView.findViewById(R.id.sdv);
            tv_name = itemView.findViewById(R.id.tv_name);
            ll = itemView.findViewById(R.id.ll);
        }
    }
}
