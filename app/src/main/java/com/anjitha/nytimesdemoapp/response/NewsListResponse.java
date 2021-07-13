package com.anjitha.nytimesdemoapp.response;


import java.io.Serializable;
import java.util.List;
import com.anjitha.nytimesdemoapp.models.Result;
import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class NewsListResponse implements Serializable {
    @SerializedName("status")
    @Expose
    private String status;
    @SerializedName("copyright")
    @Expose
    private String copyright;
    @SerializedName("num_results")
    @Expose
    private Integer numResults;
    @SerializedName("results")
    @Expose
    private List<Result> results = null;

    public String getStatus() {
        return status;
    }

    public String getCopyright() {
        return copyright;
    }

    public Integer getNumResults() {
        return numResults;
    }

    public List<Result> getResults() {
        return results;
    }
}
