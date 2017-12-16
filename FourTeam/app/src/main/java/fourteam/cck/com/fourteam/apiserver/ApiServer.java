package fourteam.cck.com.fourteam.apiserver;

import fourteam.cck.com.fourteam.bean.ChoicenessBean;

import fourteam.cck.com.fourteam.bean.FaXianBean;

import fourteam.cck.com.fourteam.bean.CommentBean;

import fourteam.cck.com.fourteam.bean.FindBean;
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

/**
 * 发现界面
 */
    @GET("columns/getVideoList.do")
    Observable<FaXianBean>    getFind(@Query("catalogId") String catalogId , @Query("pnum") String pnum);


    /**
     * 评论http://api.svipmovie.com/front/Commentary/getCommentList.do?mediaId=2b6ae30e59af48fb8a8cbec28535f3cd
     */

    @GET("Commentary/getCommentList.do")
    Observable<CommentBean> getHasParms(@Query("mediaId") String mediaId);

    /**
     * 搜索http://api.svipmovie.com/front/searchKeyWordApi/getVideoListByKeyWord.do?keyword="哈"&pnum=1
     */

    @GET("searchKeyWordApi/getVideoListByKeyWord.do")
    Observable<FindBean> getFindHasParms(@Query("keyword") String keyword,@Query("pnum") int pnum);

}
