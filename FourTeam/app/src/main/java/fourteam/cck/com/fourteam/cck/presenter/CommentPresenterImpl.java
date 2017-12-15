package fourteam.cck.com.fourteam.cck.presenter;

import fourteam.cck.com.fourteam.bean.CommentBean;
import fourteam.cck.com.fourteam.cck.model.CommentModel;
import fourteam.cck.com.fourteam.cck.model.CommentModelImpl;
import fourteam.cck.com.fourteam.cck.view.PingJiaView;

/**
 * Created by C-PC on 2017/12/15.
 */

public class CommentPresenterImpl implements CommentPresenter{
    PingJiaView pingJiaView;
    private final CommentModel commentModel;

    public CommentPresenterImpl(PingJiaView pingJiaView) {
        this.pingJiaView = pingJiaView;
        commentModel = new CommentModelImpl(this);
    }


    @Override
    public void guanlian(String id) {
        commentModel.getData(id);
    }

    @Override
    public void OngetData(CommentBean commentBean) {
        pingJiaView.showData(commentBean);
    }
}
