package com.ifading.coinmarket.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import com.ifading.coinmarket.R;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends AppCompatActivity {
    public static final String NEWS_URL = "news_url";
    @BindView(R.id.wb_news_detail)
    protected WebView webView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        setTitle("News");
        ButterKnife.bind(this);
        Intent intent = getIntent();
        String url = intent.getStringExtra(NEWS_URL);
        webView.loadUrl(url);
    }
}
