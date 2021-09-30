package com.example.practical_round;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

public interface UserInterface {

    @GET("api/users?page=2")
    Call<List<Data>> getUser();
}
