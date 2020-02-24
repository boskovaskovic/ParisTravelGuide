package com.bvinstruments.paristravelguide;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bvinstruments.paristravelguide.items.ListItem;
import com.bvinstruments.paristravelguide.items.NewsItem;

public class NewsActivity extends AppCompatActivity {

    private TextView source;
    private TextView author;
    private TextView url;
    private TextView publishedAt;
    private TextView content;
    private TextView title;
    private String imageUrl;
    private RequestOptions option;
    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.news_activity);
        option=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        source=findViewById(R.id.news_source);
        url=findViewById(R.id.news_url);
        publishedAt=findViewById(R.id.news_published_at);
        content=findViewById(R.id.news_content);
        title=findViewById(R.id.news_title);
        ListItem lItem=(ListItem) this.getIntent().getSerializableExtra("newsitem");
        title.setText(lItem.getHeadline());
        imageUrl=lItem.getImaageURL();
        NewsItem item= (NewsItem) lItem;
        source.setText(item.getSource());
       url.setText(item.getUrl());
        publishedAt.setText(item.getPublishedAt());
        content.setText(item.getContent());
        image=findViewById(R.id.news_image);
        Glide.with(this).load(imageUrl).apply(option).into(image);
        url.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(v.getContext(), WebActivity.class);
                intent.putExtra("url",url.getText());
                startActivity(intent);


            }
        });


    }
}
