package fourteam.cck.com.fourteam.cck.presenter;

import fourteam.cck.com.fourteam.bean.FindBean;
import fourteam.cck.com.fourteam.cck.model.FindModel;
import fourteam.cck.com.fourteam.cck.model.FindModelImpl;
import fourteam.cck.com.fourteam.cck.view.FindView;

/**
 * Created by C-PC on 2017/12/15.
 */

public class FindPresenterImpl implements FindPresenter{
    private FindView findView;
    private final FindModel findModel;

    public FindPresenterImpl(FindView findView) {
        this.findView = findView;
        findModel = new FindModelImpl(this);
    }

    @Override
    public void guanlian(String keyword, int pnum) {
        findModel.getData(keyword,pnum);
    }

    @Override
    public void OngetData(FindBean findBean) {
        findView.showDate(findBean);
    }
}
