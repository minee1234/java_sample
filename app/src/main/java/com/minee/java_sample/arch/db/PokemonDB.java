package com.minee.java_sample.arch.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.minee.java_sample.arch.model.Pokemon;

@Database(entities = {Pokemon.class}, version = 2, exportSchema = false)
public abstract class PokemonDB extends RoomDatabase {

    public abstract PokeDao pokeDao();
}
