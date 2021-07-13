package com.anjitha.nytimesdemoapp.newslist.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.anjitha.nytimesdemoapp.R;
import com.anjitha.nytimesdemoapp.models.Result;
import com.anjitha.nytimesdemoapp.newslist.viewmodel.NewsListViewModel;
import com.anjitha.nytimesdemoapp.response.NewsListResponse;
import com.anjitha.nytimesdemoapp.utils.Utils;
import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.List;

public class NewsListFragment extends Fragment {
    private NewsListViewModel viewModel;
    private NewsListAdapter adapter;
    private RecyclerView rvNewsList;
    private LinearLayoutManager layoutManager;
    private ArrayList<Result> newsArrayList;
    private ProgressBar progressBar;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_news_list, container, false);

        rvNewsList = view.findViewById(R.id.rvNewsList);
        progressBar = view.findViewById(R.id.progressBar);
        initialization();
        getNewsArticles();
        return view;
    }

    private void initialization() {

        layoutManager = new LinearLayoutManager(getActivity());
        rvNewsList.setLayoutManager(layoutManager);
        rvNewsList.setHasFixedSize(true);

        // adapter
        adapter = new NewsListAdapter();
        rvNewsList.setAdapter(adapter);

        // View Model initialization
        viewModel = ViewModelProviders.of(this).get(NewsListViewModel.class);
    }

    /**
     * get list of news and update the recyclerview accodingly
     */
    private void getNewsArticles() {
        if (Utils.isNetworkConnected(getActivity())) {
            viewModel.getNewsListResponseLiveData().observe(getActivity(), new Observer<NewsListResponse>() {
                @Override
                public void onChanged(NewsListResponse response) {
                    if (response != null) {
                        progressBar.setVisibility(View.GONE);
                        adapter.setResults(response.getResults());
                    }
                }
            });
        } else {
            Toast.makeText(getActivity(), getResources().getString(R.string.no_network_error_message),
                    Toast.LENGTH_LONG).show();
        }
    }

}
