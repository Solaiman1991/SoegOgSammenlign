package com.example.sgogsammenlign.ui.home;


import android.content.Intent;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.sgogsammenlign.databinding.FragmentKortBinding;
import com.example.sgogsammenlign.ui.SignInActivity;
import com.example.sgogsammenlign.ui.SignInViewModel;

public class HomeFragment extends Fragment {


    private FragmentKortBinding binding;
    private SignInViewModel viewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        HomeViewModel homeViewModel = new ViewModelProvider(this).get(HomeViewModel.class);
        viewModel = new ViewModelProvider(this).get(SignInViewModel.class);
        binding = FragmentKortBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        checkIfSignedIn();

        return root;
    }

    private void checkIfSignedIn() {
        viewModel.getCurrentUser().observe(getViewLifecycleOwner(), user -> {
            if (user == null) {
                Intent intent = new Intent(getContext(), SignInActivity.class);
                startActivity(intent);
                getActivity().finish();
            }
        });
    }


    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}