package fourteam.cck.com.fourteam.cck.model;

import fourteam.cck.com.fourteam.api.Api;
import fourteam.cck.com.fourteam.apiserver.ApiServer;
import fourteam.cck.com.fourteam.bean.CommentBean;
import fourteam.cck.com.fourteam.cck.presenter.CommentPresenterImpl;
import fourteam.cck.com.fourteam.net.RetrofitUtils;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by C-PC on 2017/12/15.
 */

public class CommentModelImpl implements CommentModel{
    CommentPresenterImpl commentPresenter;

    public CommentModelImpl(CommentPresenterImpl commentPresenter) {
        this.commentPresenter = commentPresenter;
    }

    @Override
    public void getData(String id) {
        ApiServer apiService = RetrofitUtils.getInstance().getApiService(Api.SHOUYE, ApiServer.class);
        Observable<CommentBean> observable = apiService.getHasParms(id);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<CommentBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(CommentBean commentBean) {
                        commentPresenter.OngetData(commentBean);
                    }
                });
    }
}
