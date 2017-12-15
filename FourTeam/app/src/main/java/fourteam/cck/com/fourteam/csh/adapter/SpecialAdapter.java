package fourteam.cck.com.fourteam.csh.adapter;

import android.content.Context;
import android.net.Uri;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.bean.ChoicenessBean;

/**
 * Created by 曹少航 on 2017/12/14.
 */

public class SpecialAdapter extends RecyclerView.Adapter<SpecialAdapter.MyViewHolder> {

    private Context context;
    private List<ChoicenessBean.RetBean.ListBean> Clist;

    public SpecialAdapter(Context context, List<ChoicenessBean.RetBean.ListBean> clist) {
        this.context = context;
        this.Clist = clist;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
      View view=LayoutInflater.from(context).inflate(R.layout.item_special,parent,false);
        final MyViewHolder holder=new MyViewHolder(view);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onRecyclerListener.onRecycler(holder.getPosition());
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder,final int position) {
        Log.i("aaa","ddd====="+Clist.get(position).getTitle());
//        String pic = Clist.get(position).getChildList().get(0).getPic();
        ChoicenessBean.RetBean.ListBean listBean = Clist.get(position);
        String loadType = listBean.getLoadType();
//        if(loadType.equals("movieList")){
            String pic1 = listBean.getChildList().get(0).getPic();
            holder.special1.setImageURI(Uri.parse(pic1));
            holder.special2.setText(listBean.getTitle());
//        }

    }

    @Override
    public int getItemCount() {
        return Clist.size();
    }

    class MyViewHolder extends  RecyclerView.ViewHolder{

        private final SimpleDraweeView special1;
        private final TextView special2;

        public MyViewHolder(View itemView) {
            super(itemView);
            special1 = itemView.findViewById(R.id.special_1);
            special2 = itemView.findViewById(R.id.special_2);
        }
    }

    /**
     * 自定义接口实现点击事件
     */
    private OnRecyclerListener onRecyclerListener;

    public  interface  OnRecyclerListener{
        void onRecycler(int position);
    }
    public  void setOnRecyclerListener(OnRecyclerListener onRecyclerListener){
        this.onRecyclerListener=onRecyclerListener;
    }

}
