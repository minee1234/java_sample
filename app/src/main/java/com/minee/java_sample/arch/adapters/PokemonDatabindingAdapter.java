package com.minee.java_sample.arch.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.minee.java_sample.arch.model.Pokemon;
import com.minee.java_sample.databinding.DatabindingListItemBinding;

import java.util.ArrayList;

public class PokemonDatabindingAdapter extends RecyclerView.Adapter<PokemonDatabindingAdapter.PokemonViewHolder> {

    private final Context mContext;
    private ArrayList<Pokemon> mList;
    private DatabindingListItemBinding binding;

    public PokemonDatabindingAdapter(Context mContext, ArrayList<Pokemon> mList) {
        this.mContext = mContext;
        this.mList = mList;
    }

    @NonNull
    @Override
    public PokemonDatabindingAdapter.PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(mContext);
        binding = DatabindingListItemBinding.inflate(inflater, parent, false);
        return new PokemonDatabindingAdapter.PokemonViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonDatabindingAdapter.PokemonViewHolder holder, int position) {
        Pokemon pokemon = mList.get(position);
        holder.itemBinding.setPokemon(pokemon);
    }

    @Override
    public int getItemCount() {
        return mList == null ? 0 : mList.size();
    }

    public void updateList(ArrayList<Pokemon> updatedList) {
        mList = updatedList;
        notifyDataSetChanged();
    }

    public Pokemon getPokomonAt(int position) {
        return mList.get(position);
    }

    class PokemonViewHolder extends RecyclerView.ViewHolder {
        private final DatabindingListItemBinding itemBinding;

        public PokemonViewHolder(DatabindingListItemBinding itemBinding) {
            super(itemBinding.getRoot());
            this.itemBinding = itemBinding;
        }
    }
}
