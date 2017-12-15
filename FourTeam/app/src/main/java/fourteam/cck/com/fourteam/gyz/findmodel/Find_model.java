package fourteam.cck.com.fourteam.gyz.findmodel;

import fourteam.cck.com.fourteam.api.Api;
import fourteam.cck.com.fourteam.apiserver.ApiServer;
import fourteam.cck.com.fourteam.bean.FaXianBean;
import fourteam.cck.com.fourteam.net.RetrofitUtils;
import fourteam.cck.com.fourteam.ok.OnNetListener;
import retrofit2.Retrofit;
import rx.Observable;
import rx.Observer;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by GUO on 2017/12/14.
 */

public class Find_model {
    public  void  GetFindModel(final OnNetListener onNetListener, String id,String pnum){
        Retrofit retrofit = RetrofitUtils.getRetrofit(Api.SHOUYE);
        //通过动态代理获得apiServer
        ApiServer apiServer = retrofit.create(ApiServer.class);
        Observable<FaXianBean> observable = apiServer.getFind(id,pnum);
        observable.subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<FaXianBean>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(FaXianBean faXianBean) {
                onNetListener.onSuccess(faXianBean);
                    }
                });
    }
}
