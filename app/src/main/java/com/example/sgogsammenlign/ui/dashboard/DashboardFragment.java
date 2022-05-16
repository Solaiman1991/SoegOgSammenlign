package com.example.sgogsammenlign.ui.dashboard;

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

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgogsammenlign.R;
import com.example.sgogsammenlign.databinding.FragmentProdukterBinding;
import com.example.sgogsammenlign.model.product.Product;
import com.example.sgogsammenlign.model.product.ProductAdapter;
import com.example.sgogsammenlign.model.product.ProductViewModel;

public class DashboardFragment extends Fragment  implements ProductAdapter.OnListItemClickListener {

    private FragmentProdukterBinding binding;

    private EditText editText;
    private ProductViewModel viewModel;
    private TextView textView;
    private ImageView imageView;
    RecyclerView recyclerView;
    Button requestButton;
    ProductAdapter adapter = new ProductAdapter(this);
    DashboardViewModel dashboardViewModel;


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
         dashboardViewModel = new ViewModelProvider(this).get(DashboardViewModel.class);

        binding = FragmentProdukterBinding.inflate(inflater, container, false);

        View root = binding.getRoot();

        requestButton =  root.findViewById(R.id.requestButtonProduct);
        requestButton.setOnClickListener(view -> searchForProduct(editText));


        editText = root.findViewById(R.id.editTextProduct);

        // the recycler view
        recyclerView = root.findViewById(R.id.rvProduct);
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


    public void searchForProduct(EditText editText)
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