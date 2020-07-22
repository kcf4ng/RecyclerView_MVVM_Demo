package com.practice.recyclerview_mvvm_demo;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ProgressBar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.practice.recyclerview_mvvm_demo.adapters.RecyclerViewAdapter;
import com.practice.recyclerview_mvvm_demo.adapters.RecyclerViewAdapter2;
import com.practice.recyclerview_mvvm_demo.models.NicePlace;
import com.practice.recyclerview_mvvm_demo.viewmodels.MainActivityViewModel;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "MainActivity";

    //vars
    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> mImageUrls = new ArrayList<>();

    private MainActivityViewModel mMainActivityViewModel;


    private void showProgressBar(){
        mProgressBar.setVisibility(View.VISIBLE);
    }

    private void hideProgressBar(){
        mProgressBar.setVisibility(View.GONE);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //MVC pattern
        InitialImageBitmaps();

        //MVVM pattern
        InitialComponent();

    }

    private void InitialComponent() {
        mFab = findViewById(R.id.fab);
        mRecyclerView = findViewById(R.id.recyclerView2);
        mProgressBar = findViewById(R.id.progressBar);
        mMainActivityViewModel = new ViewModelProvider(this).get(MainActivityViewModel.class);
        mMainActivityViewModel.init();
        mMainActivityViewModel.getNicePlaces().observe(this, new Observer<List<NicePlace>>() {
            @Override
            public void onChanged(List<NicePlace> nicePlaces) {
                mAdapter.notifyDataSetChanged();;
            }
        });
        mMainActivityViewModel.getIsUpdating().observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(aBoolean){
                    showProgressBar();
                }else{
                    hideProgressBar();
                    mRecyclerView.smoothScrollToPosition(mMainActivityViewModel.getNicePlaces().getValue().size()-1);
                }
            }
        });

        mFab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mMainActivityViewModel.addNewValues(     new NicePlace(
                        "https://i.imgur.com/e7ZcLWo.jpg",
                        "Chicken"
                ));
            }
        });
        initRecyclerView2();
    }

    private void initRecyclerView2() {
        mAdapter = new RecyclerViewAdapter2(this, mMainActivityViewModel.getNicePlaces().getValue());
        RecyclerView.LayoutManager  LinearLayoutManager = new LinearLayoutManager(this);
        mRecyclerView .setLayoutManager(LinearLayoutManager);
        mRecyclerView.setAdapter(mAdapter);
    }

    private void InitialImageBitmaps() {
        mImageUrls.add("https://i.imgur.com/EmIfg.jpg");
        mNames.add("Havasu Falls");

        mImageUrls.add("https://i.redd.it/tpsnoz5bzo501.jpg");
        mNames.add("Trondheim");

        mImageUrls.add("https://i.redd.it/qn7f9oqu7o501.jpg");
        mNames.add("Portugal");

        mImageUrls.add("https://i.redd.it/j6myfqglup501.jpg");
        mNames.add("Rocky Mountain National Park");

        mImageUrls.add("https://i.redd.it/0h2gm1ix6p501.jpg");
        mNames.add("Mahahual");

        mImageUrls.add("https://i.redd.it/k98uzl68eh501.jpg");
        mNames.add("Frozen Lake");

        mImageUrls.add("https://i.redd.it/glin0nwndo501.jpg");
        mNames.add("White Sands Desert");

        mImageUrls.add("https://i.redd.it/obx4zydshg601.jpg");
        mNames.add("Austrailia");

        mImageUrls.add("https://i.imgur.com/ZcLLrkY.jpg");
        mNames.add("Washington");

        initRecyclerView();
    }

    private void initRecyclerView() {
        RecyclerView recyclerView = findViewById(R.id.recyclerView);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this,mNames, mImageUrls);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    private FloatingActionButton mFab;
    private RecyclerView mRecyclerView;
    private RecyclerViewAdapter2 mAdapter;
    private ProgressBar mProgressBar;
}