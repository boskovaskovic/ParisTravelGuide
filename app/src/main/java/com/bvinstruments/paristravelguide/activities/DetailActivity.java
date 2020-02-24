package com.bvinstruments.paristravelguide.activities;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.bvinstruments.paristravelguide.R;
import com.bvinstruments.paristravelguide.items.Item;
import com.bvinstruments.paristravelguide.items.ListItem;
import com.bvinstruments.paristravelguide.items.NewsItem;

public class DetailActivity extends AppCompatActivity {

    RequestOptions option;
    private TextView content;
    private TextView title;
    private ImageView image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details_activity);
        option=new RequestOptions().centerCrop().placeholder(R.drawable.loading_shape).error(R.drawable.loading_shape);
        content=findViewById(R.id.detail_description);
        title=findViewById(R.id.detail_title);
        Item item=(Item) this.getIntent().getSerializableExtra("item");
        title.setText(item.getHeadline());



        content.setText(item.getDescription());
        image=findViewById(R.id.details_image);
        Glide.with(this).load(item.getImageResource()).apply(option).into(image);



    }
}
