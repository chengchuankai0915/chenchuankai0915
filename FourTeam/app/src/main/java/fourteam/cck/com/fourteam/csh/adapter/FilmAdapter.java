package fourteam.cck.com.fourteam.csh.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.facebook.drawee.view.SimpleDraweeView;

import java.util.List;

import fourteam.cck.com.fourteam.R;
import fourteam.cck.com.fourteam.csh.FilmBean;

/**
 * Created by 曹少航 on 2017/12/15.
 */

public class FilmAdapter extends RecyclerView.Adapter<FilmAdapter.MyViewHolder> {

    private Context context;
    private List<FilmBean.RetBean.ListBean> list;

    public FilmAdapter(Context context, List<FilmBean.RetBean.ListBean> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(context).inflate(R.layout.item_special,parent,false);
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
    public void onBindViewHolder(MyViewHolder holder, int position) {
        String pic = list.get(position).getPic();
        holder.special1.setImageURI(pic);
        holder.special2.setText(list.get(position).getTitle());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class  MyViewHolder extends RecyclerView.ViewHolder{
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
