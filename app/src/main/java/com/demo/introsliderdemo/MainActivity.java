package com.demo.introsliderdemo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.PagerSnapHelper;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.SnapHelper;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.List;

import ru.tinkoff.scrollingpagerindicator.ScrollingPagerIndicator;

public class MainActivity extends AppCompatActivity {

    List<IntroModel> introModelList;
    IntroAdapter adapter;
    RecyclerView recyclerIntro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        introModelList=new ArrayList<>();
        recyclerIntro=findViewById(R.id.introRecycler);
        recyclerIntro.setItemViewCacheSize(0);

        IntroModel model=new IntroModel();
        model.setImgPath(R.drawable.ic_launcher_background);
        introModelList.add(model);

        IntroModel model1=new IntroModel();
        model1.setImgPath(R.drawable.box);
        introModelList.add(model1);

        IntroModel model2=new IntroModel();
        model2.setImgPath(R.drawable.hotel);
        introModelList.add(model2);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false);
        recyclerIntro.setLayoutManager(layoutManager);


        ScrollingPagerIndicator recyclerIndicator = findViewById(R.id.indicator);
        //recyclerIndicator.attachToRecyclerView(recyclerIntro);
        SnapHelper snapHelper = new PagerSnapHelper();
        snapHelper.attachToRecyclerView(recyclerIntro);

        adapter=new IntroAdapter(introModelList,MainActivity.this);
        recyclerIntro.setAdapter(adapter);


    }
}
