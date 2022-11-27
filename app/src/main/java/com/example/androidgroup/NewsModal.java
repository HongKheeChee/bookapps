package com.example.androidgroup;

import java.util.ArrayList;

public class NewsModal {
    private int totalResults;
    private String status;
    private ArrayList<com.example.androidgroup.Articles> articles;

    public NewsModal(int totalResults, String status, ArrayList<com.example.androidgroup.Articles> articles) {
        this.totalResults = totalResults;
        this.status = status;
        this.articles = articles;
    }

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public ArrayList<com.example.androidgroup.Articles> getArticles() {
        return articles;
    }

    public void setArticles(ArrayList<com.example.androidgroup.Articles> articles) {
        this.articles = articles;
    }
}
