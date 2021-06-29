package com.example.galleryapp.Activity;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.example.galleryapp.Adaptor.RecycleAdaptor;
import com.example.galleryapp.Model.Photo;
import com.example.galleryapp.Model.Photos;
import com.example.galleryapp.Network.ApiService;
import com.example.galleryapp.Network.Retroinstance;
import com.example.galleryapp.R;
import com.example.galleryapp.ViewModel.MyViewModel;
import com.example.galleryapp.databinding.ActivityHomeBinding;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HomeActivity extends AppCompatActivity {

ActivityHomeBinding binding;
RecycleAdaptor adptor;
Photos photo;
MyViewModel viewmodel;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityHomeBinding.inflate(getLayoutInflater());
        View v = binding.getRoot();
        setContentView(v);

        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(this,binding.mainview,binding.toolbar,R.string.navigation_open,R.string.navigation_close);
        binding.mainview.addDrawerListener(toggle);
        toggle.syncState();

        StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2,StaggeredGridLayoutManager.VERTICAL);
        binding.recycleview.setLayoutManager(manager);
        adptor = new RecycleAdaptor(this,photo);
        binding.recycleview.setAdapter(adptor);

       viewmodel = ViewModelProviders.of(this).get(MyViewModel.class);
        viewmodel.MakeApiCall();
       viewmodel.getLiveData().observe(this, new Observer<Photos>() {
           @Override
           public void onChanged(Photos photos) {
               if (photos!=null)
               {
                   photo = photos;
                   adptor.setPhotolist(photo);

               }
               else
               {

               }

           }
       });


    }
}