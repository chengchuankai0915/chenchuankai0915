package fourteam.cck.com.fourteam.cck.model;

import fourteam.cck.com.fourteam.api.Api;
import fourteam.cck.com.fourteam.apiserver.ApiServer;
import fourteam.cck.com.fourteam.bean.FindBean;
import fourteam.cck.com.fourteam.cck.presenter.FindPresenter;
import fourteam.cck.com.fourteam.net.RetrofitUtils;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by C-PC on 2017/12/15.
 */

public class FindModelImpl implements FindModel{

    FindPresenter findPresenter;

    public FindModelImpl(FindPresenter findPresenter) {
        this.findPresenter = findPresenter;
    }

    @Override
    public void getData(String keyword, int pnum) {
        ApiServer apiService = RetrofitUtils.getInstance().getApiService(Api.SHOUYE, ApiServer.class);
        Observable<FindBean> observable = apiService.getFindHasParms(keyword, pnum);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FindBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FindBean findBean) {
                        findPresenter.OngetData(findBean);
                    }
                });
    }
}
