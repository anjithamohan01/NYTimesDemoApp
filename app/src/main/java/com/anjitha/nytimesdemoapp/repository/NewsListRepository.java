package com.anjitha.nytimesdemoapp.repository;

import android.util.Log;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;

import com.anjitha.nytimesdemoapp.constants.AppConstants;
import com.anjitha.nytimesdemoapp.response.NewsListResponse;
import com.anjitha.nytimesdemoapp.retrofit.RetrofitClient;
import com.anjitha.nytimesdemoapp.retrofit.RetrofitService;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class NewsListRepository {

    private static final String TAG = NewsListRepository.class.getSimpleName();
    private RetrofitService retrofitService;


    public NewsListRepository() {
        retrofitService = RetrofitClient.getRetrofitInstance().create(RetrofitService.class);
    }

    /**
     * method for getting the newslist from api
     * @return LiveData<NewsListResponse>
     */
    public LiveData<NewsListResponse>  getNewsList() {
        final MutableLiveData<NewsListResponse> data = new MutableLiveData<>();

        retrofitService.getNewsList(AppConstants.API_KEY)
                .enqueue(new Callback<NewsListResponse>() {

                    @Override
                    public void onResponse(Call<NewsListResponse> call, Response<NewsListResponse> response) {
                        Log.d(TAG, "onResponse response:: " + response);

                        if (response.body() != null) {
                            data.postValue(response.body());
                        }
                    }

                    @Override
                    public void onFailure(Call<NewsListResponse> call, Throwable t) {
                        Log.d(TAG, "Failure response:: " );
                        data.postValue(null);
                    }
                });
        return data;
    }

}
