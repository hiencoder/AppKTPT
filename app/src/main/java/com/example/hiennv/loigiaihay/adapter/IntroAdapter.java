package com.example.hiennv.loigiaihay.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.hiennv.loigiaihay.R;
import com.example.hiennv.loigiaihay.model.Intro;

import java.util.List;

public class IntroAdapter extends PagerAdapter {
    private Context context;
    private List<Intro> intros;

    public IntroAdapter(Context context, List<Intro> imageIntro) {
        this.context = context;
        this.intros = imageIntro;
    }

    @Override
    public int getCount() {
        return intros.size();
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object) {
        return (view == object);
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_intro, container, false);
        ImageView ivIntro = view.findViewById(R.id.iv_intro);
        TextView tvIntro = view.findViewById(R.id.tv_intro);
        Intro intro = intros.get(position);
        tvIntro.setText(intro.getTitle());
        Glide.with(context).load(intro.getImage()).into(ivIntro);
        container.addView(view);
        return view;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object) {
        container.removeView((View) object);
    }


}
