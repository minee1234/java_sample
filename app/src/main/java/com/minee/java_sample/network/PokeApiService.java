package com.minee.java_sample.network;

import com.minee.java_sample.model.PokemonResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokeApiService {

    @GET("pokemon")
    Observable<PokemonResponse> getPokemons();
}
