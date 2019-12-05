package com.example.RecipeApp.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.RecipeApp.R;
import com.example.RecipeApp.datamodel.Recipe;

import java.util.ArrayList;

public class RecipeListAdapter extends RecyclerView.Adapter<RecipeListAdapter.RecipeListViewHolder> {
    ArrayList<Recipe> mRecipeList;

    public RecipeListAdapter(ArrayList<Recipe> mRecipeList) {
        this.mRecipeList = mRecipeList;
    }

    @NonNull
    @Override
    public RecipeListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_list_row, parent, false);
        RecipeListViewHolder mRecipeListViewHolder = new RecipeListViewHolder(view);
        return mRecipeListViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecipeListViewHolder holder, int position) {
        holder.mTextViewRecipeName.setText(mRecipeList.get(position).getName());
    }

    @Override
    public int getItemCount() {
        return mRecipeList.size();
    }

    public void setDataList(ArrayList<Recipe> sourceList){
        this.mRecipeList = sourceList;
        notifyDataSetChanged();
    }

    public class RecipeListViewHolder extends RecyclerView.ViewHolder {
        public TextView mTextViewRecipeName;

        public RecipeListViewHolder(@NonNull View itemView) {
            super(itemView);
            mTextViewRecipeName = itemView.findViewById(R.id.tv_recipe_list_row_recipe_name);
        }
    }
}
