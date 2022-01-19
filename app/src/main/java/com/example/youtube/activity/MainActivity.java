package com.example.youtube.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;


import com.example.youtube.R;
import com.example.youtube.adapter.AdapterVideo;
import com.example.youtube.databinding.ActivityMainBinding;
import com.example.youtube.model.Video;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.miguelcatalan.materialsearchview.MaterialSearchView;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity{

    private ActivityMainBinding binding;
    private final static String GOOGLE_API_KEY = "AIzaSyBC0PdaLsaVd5lOtlpPkpnLAwsqGB0llJw";

    private List<Video>  videos = new ArrayList<>();
    private AdapterVideo adapterVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initialSettings();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);

        MenuItem item = menu.findItem(R.id.menu_search);
        binding.includeToolbar.searchView.setMenuItem(item);

        return true;
    }

    private void initialSettings(){
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        toolbarSettings();
        recyclerVideoSettings();
        searchViewSettings();
    }

    private void toolbarSettings(){
        binding.includeToolbar.toolbar.setTitle(R.string.app_name);
        setSupportActionBar(binding.includeToolbar.toolbar);
    }

    private void recyclerVideoSettings(){
        adapterVideo = new AdapterVideo(videos, this);

        binding.recyclerVideo.setLayoutManager(new LinearLayoutManager(this));
        binding.recyclerVideo.setHasFixedSize(true);
        binding.recyclerVideo.setAdapter(adapterVideo);
    }

    private void searchViewSettings(){

        binding.includeToolbar.searchView.setOnQueryTextListener(new MaterialSearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String query) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String newText) {
                return false;
            }
        });

        binding.includeToolbar.searchView.setOnSearchViewListener(new MaterialSearchView.SearchViewListener() {
            @Override
            public void onSearchViewShown() {

            }

            @Override
            public void onSearchViewClosed() {

            }
        });
    }
}