package com.example.sgogsammenlign;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.sgogsammenlign.model.Product;
import com.example.sgogsammenlign.model.ProductViewModel;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.sgogsammenlign.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    private EditText editText;
    private ProductViewModel viewModel;
    private TextView textView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        NavigationUI.setupWithNavController(binding.navView, navController);


        ImageView imageView = findViewById(R.id.imageView);
        editText = findViewById(R.id.editText);
        textView = findViewById(R.id.text_dashboard);
        viewModel = new ViewModelProvider(this).get(ProductViewModel.class);

//
        viewModel.getSearchedProduct().observe(this,titles -> {
            textView.append(titles.getTitle());
//            for (Product listOfProducts : titles ) {
//                textView.append(listOfProducts.getTitle() + "\n");
//            }
        });

        viewModel.getSearchedProduct().observe(this, product -> {
            Glide.with(this).load(product.getImgUrl()).into(imageView);
        });

    }

    public void searchForProduct(View view)
    {


        viewModel.searchForProduct(editText.getText().toString());
    }

}