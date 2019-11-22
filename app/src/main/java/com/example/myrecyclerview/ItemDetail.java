package com.example.myrecyclerview;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

public class ItemDetail extends AppCompatActivity {

    public static final String EXTRA_HERO = "extra_hero";

    private String title;
    TextView tvDetail, tvName;
    ImageView imgPhoto;

    private void setActionBarTitle() {
        if (getSupportActionBar() != null) {
            getSupportActionBar().setTitle(title);
        }
    }

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.item_detail);

        tvName = findViewById(R.id.tv_item_name);
        tvDetail = findViewById(R.id.tv_item_detail);
        imgPhoto = findViewById(R.id.img_item_photo);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            Hero hero = extras.getParcelable(EXTRA_HERO);
            title = hero.getName();
            setActionBarTitle();

            tvName.setText(hero.getName());
            tvDetail.setText(hero.getDetail());
            Glide.with(this)
                    .load(hero.getPhoto())
                    .apply(new RequestOptions().override(350, 350))
                    .into(imgPhoto);
        }
    }
}
