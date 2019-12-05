package com.example.bakerzin.rest;

import com.example.bakerzin.datamodel.Recipe;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiInterface {
    @GET("topher/2017/May/59121517_baking/baking.json")
    Call<ArrayList<Recipe>> getRecipe();
}
