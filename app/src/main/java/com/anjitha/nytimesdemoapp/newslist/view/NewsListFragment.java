package com.anjitha.nytimesdemoapp.newslist.view;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import com.anjitha.nytimesdemoapp.R;
import com.anjitha.nytimesdemoapp.databinding.FragmentNewsListBinding;
import com.anjitha.nytimesdemoapp.newslist.viewmodel.NewsListViewModel;
import com.anjitha.nytimesdemoapp.response.NewsListResponse;
import com.anjitha.nytimesdemoapp.utils.Utils;


public class NewsListFragment extends Fragment {
    private NewsListViewModel viewModel;
    private NewsListAdapter adapter;
    private LinearLayoutManager layoutManager;
    private FragmentNewsListBinding binding;


    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        binding = FragmentNewsListBinding.inflate(inflater, container, false);
        View view = binding.getRoot();
        initialization();
        getNewsArticles();
        return view;
    }

    private void initialization() {

        layoutManager = new LinearLayoutManager(getActivity());
        binding.rvNewsList.setLayoutManager(layoutManager);
        binding.rvNewsList.setHasFixedSize(true);

        // adapter
        adapter = new NewsListAdapter();
        binding.rvNewsList.setAdapter(adapter);

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
                        binding.progressBar.setVisibility(View.GONE);
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
