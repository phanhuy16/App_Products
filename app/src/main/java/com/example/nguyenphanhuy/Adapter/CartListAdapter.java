package com.example.nguyenphanhuy.Adapter;

import android.annotation.SuppressLint;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.nguyenphanhuy.Domain.FoodDomain;
import com.example.nguyenphanhuy.Helper.ManagementCart;
import com.example.nguyenphanhuy.Interface.ChangeNumberItemsListner;
import com.example.nguyenphanhuy.R;

import java.util.ArrayList;

public class CartListAdapter extends RecyclerView.Adapter<CartListAdapter.ViewHolder> {
    ArrayList<FoodDomain> listFoodSelectd;
    private ManagementCart managementCart;
    ChangeNumberItemsListner changeNumberItemsListner;

    public CartListAdapter(ArrayList<FoodDomain> listFoodSelectd, Context context, ChangeNumberItemsListner changeNumberItemsListner) {
        this.listFoodSelectd = listFoodSelectd;
        managementCart = new ManagementCart(context);
        this.changeNumberItemsListner = changeNumberItemsListner;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View inflate = LayoutInflater.from(parent.getContext()).inflate(R.layout.viewholder_cart, parent, false);
        return  new  ViewHolder(inflate);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.title.setText(listFoodSelectd.get(position).getTitle());
        holder.feeEachItem.setText("$"  + listFoodSelectd.get(position).getFee());
        holder.totalEachItem.setText("$" + Math.round((listFoodSelectd.get(position).getNumberInCart() * listFoodSelectd.get(position).getFee())));
        holder.num.setText(String.valueOf(listFoodSelectd.get(position).getNumberInCart()));

        @SuppressLint("DiscouragedApi")
        int drawableReourceId = holder.itemView.getContext().getResources()
                .getIdentifier(listFoodSelectd.get(position).getPic(), "drawable",
                        holder.itemView.getContext().getPackageName());
        Glide.with(holder.itemView.getContext())
                .load(drawableReourceId)
                .into(holder.pic);

        holder.plusItem.setOnClickListener(v -> managementCart.plusNumberFood(listFoodSelectd, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListner.Changed();
        }));

        holder.minusItem.setOnClickListener(v -> managementCart.minusNumberFood(listFoodSelectd, position, () -> {
            notifyDataSetChanged();
            changeNumberItemsListner.Changed();
        }));
    }

    @Override
    public int getItemCount() {
        return listFoodSelectd.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView title, feeEachItem;
        ImageView pic, plusItem, minusItem;
        TextView totalEachItem, num;
        public ViewHolder(@NonNull View itemView){
            super(itemView);
            title = itemView.findViewById(R.id.titleTxt);
            pic = itemView.findViewById(R.id.pic);
            feeEachItem = itemView.findViewById(R.id.feeEachItem);
            totalEachItem = itemView.findViewById(R.id.totalEachItem);
            plusItem = itemView.findViewById(R.id.plusCartBtn);
            minusItem = itemView.findViewById(R.id.minusCartBtn);
            num = itemView.findViewById(R.id.numberItemTxt);
        }
    }
}
