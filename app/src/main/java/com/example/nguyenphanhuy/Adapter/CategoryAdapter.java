package com.example.nguyenphanhuy.Adapter;

import android.annotation.SuppressLint;
import android.view.View;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nguyenphanhuy.Domain.CategoryDomain;
import com.example.nguyenphanhuy.Domain.FoodDomain;
import com.example.nguyenphanhuy.R;

import java.util.ArrayList;

public class CategoryAdapter extends RecyclerView.Adapter<CategoryAdapter.ViewHolder> {
    ArrayList<CategoryDomain> RecomendedDomains;

    public CategoryAdapter(ArrayList<CategoryDomain> RecomendedDomains) {
        this.RecomendedDomains = RecomendedDomains;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_category, parent, false);
        return  new  ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(RecomendedDomains.get(position).getTitle());

        @SuppressLint("DiscouragedApi") int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(RecomendedDomains.get(position).getPic(), "drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.pic);
    }

    @Override
    public int getItemCount() {
        return RecomendedDomains.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title;
        ImageView pic;
        ImageView addBtn;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.categoryName);
            pic = itemView.findViewById(R.id.categoryPic);
            addBtn = itemView.findViewById(R.id.addBtn);
        }
    }
}
