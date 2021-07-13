package com.anjitha.nytimesdemoapp.retrofit;

import com.anjitha.nytimesdemoapp.response.NewsListResponse;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface RetrofitService {

    @GET("mostpopular/v2/mostviewed/all-sections/7.json?")
    Call<NewsListResponse> getNewsList(
            @Query("api-key") String apiKey
    );
}
