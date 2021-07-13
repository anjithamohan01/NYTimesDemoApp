package com.anjitha.nytimesdemoapp.ui.viewmodel;



import android.arch.core.executor.testing.InstantTaskExecutorRule;

import com.anjitha.nytimesdemoapp.constants.AppConstants;
import com.anjitha.nytimesdemoapp.newslist.viewmodel.NewsListViewModel;
import com.anjitha.nytimesdemoapp.response.NewsListResponse;
import com.anjitha.nytimesdemoapp.retrofit.RetrofitClient;
import com.anjitha.nytimesdemoapp.retrofit.RetrofitService;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Observer;

import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

@RunWith(JUnit4.class)
public class NewsViewModelTest {
    @Rule
    public InstantTaskExecutorRule instantExecutorRule = new InstantTaskExecutorRule();

    @Mock
    RetrofitService apiEndPoint;
    @Mock
    RetrofitClient apiClient;

    private NewsListViewModel viewModel;
    @Mock
    private Observer dataObserver;


    @Before
    public void setUp() throws Exception {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testNull() {
        when(apiEndPoint.getNewsList(AppConstants.API_KEY)).thenReturn(null);
    }

    @Test
//    public void testApiFetchDataSuccess() {
//        // Mock API response
//        when(apiEndPoint.getNewsList(AppConstants.API_KEY)).thenReturn(new NewsList());
//        viewModel.getNewsList();
//
//    }
//
//    @Test
//    public void testApiFetchDataError() {
//        when(apiClient.fetchNews()).thenReturn(Single.error(new Throwable("Api error")));
//        viewModel.fetchNews();
//        verify(observer).onChanged(NewsListViewState.LOADING_STATE);
//        verify(observer).onChanged(NewsListViewState.ERROR_STATE);
//    }

    @After
    public void tearDown() throws Exception {
        apiClient = null;
        viewModel = null;
    }
}