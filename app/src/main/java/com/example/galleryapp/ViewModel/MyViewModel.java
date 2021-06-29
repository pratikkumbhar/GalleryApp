package com.example.galleryapp.ViewModel;

import android.util.Log;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.galleryapp.Model.Photos;
import com.example.galleryapp.Network.ApiService;
import com.example.galleryapp.Network.Retroinstance;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MyViewModel extends ViewModel {
private MutableLiveData<Photos> liveData;

public MyViewModel()
{
    liveData = new MutableLiveData<>();

}
public MutableLiveData<Photos> getLiveData()
{
    return liveData;
}
    public void MakeApiCall() {
        ApiService apiService = Retroinstance.getRetrofit().create(ApiService.class);
        Call<Photos> call = apiService.getPhotos();
        call.enqueue(new Callback<Photos>() {
            @Override
            public void onResponse(Call<Photos> call, Response<Photos> response) {

                if (response.isSuccessful())
                {
                    liveData.postValue(response.body());
                }
            }


            @Override
            public void onFailure(Call<Photos> call, Throwable t) {
                liveData.postValue(null);
                Log.i("123", t.getMessage());

            }
        });
    }
}