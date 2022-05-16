package com.example.sgogsammenlign.model.product;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sgogsammenlign.R;

import java.util.ArrayList;
import java.util.List;

public class ProductAdapter extends  RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private List<ProductResponse> productResponseList;
    private List<Product> products;
    OnListItemClickListener listener;
    public ProductAdapter(OnListItemClickListener listener)
    {
        this.products = new ArrayList<Product>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public ProductAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view =  inflater.inflate(R.layout.fragment_products_rv,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ViewHolder holder, int position) {


        holder.title.setText(products.get(position).getTitle());

        Glide.with(holder.itemView.getContext()).load(products.get(position).getImg()).override(400,400).into(holder.img);

        holder.price.setText(String.valueOf(products.get(position).getPrice()));
    }

    @Override
    public int getItemCount() {
       return products.size();

    }

    public void addProducts(List<Product> products) {

       this.products =  products;
       notifyDataSetChanged();
    }


    public interface OnListItemClickListener {
        void onClick(Product product);

    }



    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView link;
        TextView title;
        ImageView img;
        TextView price;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(products.get(getBindingAdapterPosition()));
                }
            });
            title = itemView.findViewById(R.id.title);
            img = itemView.findViewById(R.id.img);
            price = itemView.findViewById(R.id.price);

        }

    }
}
