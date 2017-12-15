package fourteam.cck.com.fourteam.gyz.findadapter;

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
import fourteam.cck.com.fourteam.bean.FaXianBean;

/**
 * Created by GUO on 2017/12/14.
 */

public class Find_Adapter extends RecyclerView.Adapter {
    private Context context;
    private List<FaXianBean.RetBean.ListBean> listBeen;
private  OnCilcklist onCilcklist;
    public interface  OnCilcklist{
        void  Onsewssce(FaXianBean.RetBean.ListBean listBean);
    }
    public  void  setOnCilcklist(OnCilcklist onCilcklist){
        this.onCilcklist=onCilcklist;
    }
    public Find_Adapter(Context context, List<FaXianBean.RetBean.ListBean> listBeen) {
        this.context = context;
        this.listBeen = listBeen;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.find_adapter, parent, false);
        TypeViewHolder typeViewHolder = new TypeViewHolder(inflate);
        return typeViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, final int position) {
   TypeViewHolder typeViewHolder= (TypeViewHolder) holder;
     typeViewHolder.find_title.setText(listBeen.get(position).getTitle());
        typeViewHolder.find_description.setText(listBeen.get(position).getDescription());
        Uri parse = Uri.parse(listBeen.get(position).getPic());
         typeViewHolder.find_png.setImageURI(parse);
        typeViewHolder.linearLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listBeen!=null){
                    onCilcklist.Onsewssce(listBeen.get(position));
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return listBeen.size();
    }
    private  class  TypeViewHolder extends RecyclerView.ViewHolder{

        private final TextView find_title;
        private final TextView find_description;
        private final SimpleDraweeView find_png;
        private final LinearLayout linearLayout;

        public TypeViewHolder(View itemView) {
            super(itemView);
            find_title = itemView.findViewById(R.id.find_title);
            find_description = itemView.findViewById(R.id.find_description);
            find_png = itemView.findViewById(R.id.find_png);
            linearLayout = itemView.findViewById(R.id.ll);
        }
    }
    public  void  Add(List<FaXianBean.RetBean.ListBean> list){
        listBeen.clear();
        listBeen.addAll(list);
        notifyDataSetChanged();
    }
}
