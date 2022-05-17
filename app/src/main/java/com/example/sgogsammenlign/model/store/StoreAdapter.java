package com.example.sgogsammenlign.model.store;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgogsammenlign.R;

import java.util.ArrayList;
import java.util.List;

public class StoreAdapter extends RecyclerView.Adapter<StoreAdapter.ViewHolder> {

    private List<Store> stores;
    OnListItemClickListener listener;

    public StoreAdapter(OnListItemClickListener listener) {
        this.stores = new ArrayList<Store>();
        this.listener = listener;
    }

    @NonNull
    @Override
    public StoreAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(parent.getContext());
        View view = inflater.inflate(R.layout.fragment_stores_rv, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull StoreAdapter.ViewHolder holder, int position) {


        holder.title.setText(stores.get(position).getCity());
        holder.brand.setText(stores.get(position).getBrand());
        holder.zip.setText(stores.get(position).getZip());

    }

    @Override
    public int getItemCount() {
        return stores.size();

    }

    public void addStores(List<Store> stores) {
        this.stores =stores;
        notifyDataSetChanged();
    }


    public interface OnListItemClickListener {
        void onClick(Store store);
    }


    public class ViewHolder extends RecyclerView.ViewHolder {


        TextView title;
        TextView brand;
        TextView zip;



        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    listener.onClick(stores.get(getBindingAdapterPosition()));
                }
            });
            title = itemView.findViewById(R.id.city);
            brand = itemView.findViewById(R.id.brand);
            zip = itemView.findViewById(R.id.zip);


        }

    }
}
