package com.minee.java_sample.ui;

import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.minee.java_sample.R;
import com.minee.java_sample.databinding.ActivityPokemonBinding;
import com.minee.java_sample.ui.fragments.Favorites;
import com.minee.java_sample.ui.fragments.Home;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class PokemonActivity extends AppCompatActivity {
    private ActivityPokemonBinding binding;
    private boolean isFavoriteListVisible = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.activity_pokemon);
        binding = ActivityPokemonBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Home()).commit();

        binding.changeFragment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isFavoriteListVisible) {
                    isFavoriteListVisible = false;
                    binding.changeFragment.setText("Favorites");
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Home()).commit();
                } else {
                    isFavoriteListVisible = true;
                    binding.changeFragment.setText("Home");
                    getSupportFragmentManager().beginTransaction().replace(R.id.frameLayout, new Favorites()).commit();
                }
            }
        });

    }
}