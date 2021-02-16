package com.minee.java_sample.repository;

import androidx.lifecycle.LiveData;

import com.minee.java_sample.db.PokeDao;
import com.minee.java_sample.model.Pokemon;
import com.minee.java_sample.model.PokemonResponse;
import com.minee.java_sample.network.PokeApiService;


import java.util.List;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class Repository {

    private PokeDao pokeDao;
    private PokeApiService apiService;

    @Inject
    public Repository(PokeDao pokeDao, PokeApiService apiService) {
        this.pokeDao = pokeDao;
        this.apiService = apiService;
    }

    public Observable<PokemonResponse> getPokemons() {
        return apiService.getPokemons();
    }

    public void insertPokemon(Pokemon pokemon) {
        pokeDao.insertPokemon(pokemon);
    }

    public void deletePokemon(String pokemonName) {
        pokeDao.deletePokemon(pokemonName);
    }

    public void deleteAll() {
        pokeDao.deleteAll();
    }

    public LiveData<List<Pokemon>> getFavoritePokemon() {
        return pokeDao.getFavoritePokemons();
    }
}
