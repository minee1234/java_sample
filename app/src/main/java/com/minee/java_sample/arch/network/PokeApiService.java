package com.minee.java_sample.arch.network;

import com.minee.java_sample.arch.model.PokemonResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface PokeApiService {

    @GET("pokemon")
    Observable<PokemonResponse> getPokemons();
}
