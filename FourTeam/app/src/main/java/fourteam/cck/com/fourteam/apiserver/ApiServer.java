package fourteam.cck.com.fourteam.apiserver;

import fourteam.cck.com.fourteam.bean.ChoicenessBean;
import retrofit2.http.GET;
import rx.Observable;

/**
 * Created by C-PC on 2017/12/14.
 */

public interface ApiServer {


    /**
     *  首页接口
     *  http://api.svipmovie.com/front/homePageApi/homePage.do
     */

    @GET("homePageApi/homePage.do")
    Observable<ChoicenessBean> getParms();
}
