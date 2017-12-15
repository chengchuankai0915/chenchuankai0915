package fourteam.cck.com.fourteam.apiserver;

import fourteam.cck.com.fourteam.bean.ChoicenessBean;
<<<<<<< HEAD
import fourteam.cck.com.fourteam.bean.FaXianBean;
=======
import fourteam.cck.com.fourteam.bean.CommentBean;
>>>>>>> aa5864b399f830de74f38ed4f7b6874d1189254b
import retrofit2.http.GET;
import retrofit2.http.Query;
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
<<<<<<< HEAD
/**
 * 发现界面
 */
    @GET("columns/getVideoList.do")
    Observable<FaXianBean>    getFind(@Query("catalogId") String catalogId , @Query("pnum") String pnum);
=======

    /**
     * 评论http://api.svipmovie.com/front/Commentary/getCommentList.do?mediaId=2b6ae30e59af48fb8a8cbec28535f3cd
     */

    @GET("Commentary/getCommentList.do")
    Observable<CommentBean> getHasParms(@Query("mediaId") String mediaId);
>>>>>>> aa5864b399f830de74f38ed4f7b6874d1189254b
}
