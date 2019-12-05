package com.example.RecipeApp.fragment;


import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.RecipeApp.R;
import com.example.RecipeApp.adapter.RecipeListAdapter;
import com.example.RecipeApp.datamodel.Recipe;
import com.example.RecipeApp.rest.ApiClient;
import com.example.RecipeApp.rest.ApiInterface;
import com.google.gson.Gson;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecipeFragment extends Fragment {
    RecyclerView recipeListRecycler;
    RecipeListAdapter recipeListAdapter = null;
    ArrayList<Recipe> recipeArrayList;
    ApiInterface apiInterface;
    Gson mGson = new Gson();

    public RecipeFragment() {

    }

    public void addData(){
        Log.d("ASD", "masuk");
        recipeArrayList = new ArrayList<>();
        apiInterface = ApiClient.getClient().create(ApiInterface.class);
        Log.d("ASD", "masuk 1");
        //apiInterface = ApiClient.getClient();
//        Call<ArrayList<Recipe>> getRecipeCall = apiInterface.getRecipe();
        Log.d("ASD", "masuk 2");

        apiInterface.getRecipe().enqueue(new Callback<ArrayList<Recipe>>() {
            @Override
            public void onResponse(Call<ArrayList<Recipe>> call, Response<ArrayList<Recipe>> response) {
                recipeArrayList = response.body();
                Log.d("ASD", "ini " + recipeArrayList.get(0).getName());
                recipeListAdapter.setDataList(recipeArrayList);
            }

            @Override
            public void onFailure(Call<ArrayList<Recipe>> call, Throwable t) {
                Log.d("ASD", t.getMessage());
            }
        });

    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_recipe, container, false);

        addData();

        recipeListRecycler = view.findViewById(R.id.rv_recipe_list);
        recipeListAdapter = new RecipeListAdapter(recipeArrayList);

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getContext());

        recipeListRecycler.setLayoutManager(layoutManager);

        recipeListRecycler.setAdapter(recipeListAdapter);


        return view;
    }

}
