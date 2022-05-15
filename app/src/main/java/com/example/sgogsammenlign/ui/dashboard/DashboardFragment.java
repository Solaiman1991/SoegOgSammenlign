package com.example.sgogsammenlign.ui.dashboard;

import android.app.AlertDialog;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.sgogsammenlign.R;
import com.example.sgogsammenlign.databinding.FragmentDashboardBinding;
import com.example.sgogsammenlign.model.Product;
import com.example.sgogsammenlign.model.ProductAdapter;
import com.example.sgogsammenlign.model.ProductViewModel;

public class DashboardFragment extends Fragment  implements ProductAdapter.OnListItemClickListener {

    private FragmentDashboardBinding binding;

    private EditText editText;
    private ProductViewModel viewModel;
    private TextView textView;
    private ImageView imageView;
    RecyclerView recyclerView;
    Button requestButton;
    ProductAdapter adapter = new ProductAdapter(this);


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        DashboardViewModel dashboardViewModel =
                new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentDashboardBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        requestButton =  root.findViewById(R.id.requestButton);
        requestButton.setOnClickListener(view -> searchForProduct());


        editText = root.findViewById(R.id.editText);

        // the recycler view
        recyclerView = root.findViewById(R.id.rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.hasFixedSize();

        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);

        recyclerView.setAdapter(adapter);
        return root;

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


    public void searchForProduct()
    {
        viewModel.searchForProduct(editText.getText().toString()).observe(getViewLifecycleOwner(),products ->   {
            adapter.addProducts(products);

            });

    }

    @Override
    public void onClick(Product product) {

        Intent browserIntent = new Intent(Intent.ACTION_VIEW);
        browserIntent.setData(Uri.parse(product.getLink()));
        startActivity(browserIntent);

    }
}