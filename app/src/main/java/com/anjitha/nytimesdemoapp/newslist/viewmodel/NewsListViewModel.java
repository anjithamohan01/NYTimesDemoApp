package com.anjitha.nytimesdemoapp.newslist.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.anjitha.nytimesdemoapp.repository.NewsListRepository;
import com.anjitha.nytimesdemoapp.response.NewsListResponse;

public class NewsListViewModel extends AndroidViewModel {
    private NewsListRepository newsListRepository;
    private LiveData<NewsListResponse> newsListResponseLiveData;

    public NewsListViewModel(@NonNull Application application) {
        super(application);
        newsListRepository = new NewsListRepository();
        newsListResponseLiveData = newsListRepository.getNewsList();
    }


    public void getNewsList() {
        newsListRepository.getNewsList();
    }

    /**
     * method for getting the news list livedata
     * @return LiveData<NewsListResponse>
     */
    public LiveData<NewsListResponse> getNewsListResponseLiveData() {
        return newsListResponseLiveData;
    }
}
