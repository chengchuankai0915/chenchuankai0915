package fourteam.cck.com.fourteam.cck.model;

import fourteam.cck.com.fourteam.api.Api;
import fourteam.cck.com.fourteam.apiserver.ApiServer;
import fourteam.cck.com.fourteam.bean.ChoicenessBean;
import fourteam.cck.com.fourteam.cck.presenter.ChoicenessPresenterImpl;
import fourteam.cck.com.fourteam.net.RetrofitUtils;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by C-PC on 2017/12/14.
 */

public class ChoicenessModelImpl implements ChoicenessModel{
    ChoicenessPresenterImpl choicenessPresenter;

    public ChoicenessModelImpl(ChoicenessPresenterImpl choicenessPresenter) {
        this.choicenessPresenter = choicenessPresenter;
    }

    @Override
    public void getData() {
        ApiServer apiService = RetrofitUtils.getInstance().getApiService(Api.SHOUYE, ApiServer.class);
        Observable<ChoicenessBean> observable = apiService.getParms();
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ChoicenessBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(ChoicenessBean choicenessBean) {
                        choicenessPresenter.OngetData(choicenessBean);
                    }
                });
    }
}
