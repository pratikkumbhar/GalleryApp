package com.example.galleryapp.Network;

import com.example.galleryapp.Model.Photos;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("&extras=url_s")
    Call <Photos> getPhotos();



}
