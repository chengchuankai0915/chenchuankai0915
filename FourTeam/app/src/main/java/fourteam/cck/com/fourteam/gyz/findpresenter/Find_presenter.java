package fourteam.cck.com.fourteam.gyz.findpresenter;

import fourteam.cck.com.fourteam.bean.BaseBean;
import fourteam.cck.com.fourteam.gyz.findmodel.Find_model;
import fourteam.cck.com.fourteam.gyz.findview.Find_View;
import fourteam.cck.com.fourteam.ok.OnNetListener;

/**
 * Created by GUO on 2017/12/14.
 */

public class Find_presenter implements OnNetListener {
    Find_View find_view;
    private final Find_model find_model;

    public Find_presenter(Find_View find_view) {
     this.find_view=find_view;
        find_model = new Find_model();
    }
    public  void  relevance(String id,String pnum){
        find_model.GetFindModel(this,id,pnum);
    }

    @Override
    public void onSuccess(BaseBean baseBean) {
        find_view.GetFindView(baseBean);
    }

    @Override
    public void onError() {

    }
}
