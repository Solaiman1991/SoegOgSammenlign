package com.example.sgogsammenlign.ui.notifications;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.sgogsammenlign.R;
import com.example.sgogsammenlign.databinding.FragmentButikkerBinding;
import com.example.sgogsammenlign.model.store.Store;
import com.example.sgogsammenlign.model.store.StoreAdapter;
import com.example.sgogsammenlign.model.store.StoreViewModel;


public class NotificationsFragment extends Fragment implements StoreAdapter.OnListItemClickListener {

    private FragmentButikkerBinding binding;


    private EditText editText;
    private EditText editTextbrand;
    private StoreViewModel viewModel;
    RecyclerView recyclerView;
    Button requestButton;
    StoreAdapter adapter = new StoreAdapter(this);


    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        NotificationsViewModel notificationsViewModel =
                new ViewModelProvider(this).get(NotificationsViewModel.class);

        binding = FragmentButikkerBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        requestButton = root.findViewById(R.id.requestButtonStore);
        requestButton.setOnClickListener(view -> searchForStore());


        editText = root.findViewById(R.id.editTextStore);
        editTextbrand = root.findViewById(R.id.editTextStoreBrand);

        // the recycler view
        recyclerView = root.findViewById(R.id.rvStore);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.hasFixedSize();

        viewModel = new ViewModelProvider(this).get(StoreViewModel.class);

        recyclerView.setAdapter(adapter);
        return root;


    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

    public void searchForStore() {
        viewModel.searchForStore(editText.getText().toString(),editTextbrand.getText().toString()).observe(getViewLifecycleOwner(), stores -> {
            adapter.addStores(stores);

        });

    }

    @Override
    public void onClick(Store store) {
        Uri gmmIntentUri = Uri.parse("geo:" + store.getCoordinates()[1] + "," + store.getCoordinates()[0]);
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);

    }
}