package com.minee.java_sample.arch.di;

import android.app.Application;

import androidx.room.Room;

import com.minee.java_sample.arch.db.PokeDao;
import com.minee.java_sample.arch.db.PokemonDB;

import org.jetbrains.annotations.NotNull;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import dagger.hilt.InstallIn;
import dagger.hilt.components.SingletonComponent;

@Module
@InstallIn(SingletonComponent.class)
public class DataBaseModule {

    @NotNull
    @Provides
    @Singleton
    public static PokemonDB providePokemonDB(@NotNull Application application) {
        return Room.databaseBuilder(application, PokemonDB.class, "Favorite Database")
                .fallbackToDestructiveMigration()
                .allowMainThreadQueries()
                .build();
    }

    @Provides
    @Singleton
    public static PokeDao providePokeDao(@NotNull PokemonDB pokemonDB) {
        return pokemonDB.pokeDao();
    }
}
