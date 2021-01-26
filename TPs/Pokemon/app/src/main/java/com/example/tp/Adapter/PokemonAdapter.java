package com.example.tp.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.tp.Model.Pokemon;
import com.example.tp.R;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

public class PokemonAdapter extends RecyclerView.Adapter<PokemonAdapter.PokemonViewHolder> {
    private Context mContext;
    private List<Pokemon> mPokemonList;
    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int id);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }

    public PokemonAdapter(Context context, List<Pokemon> pokemons) {
        mContext = context;
        mPokemonList = pokemons;
    }

    @NonNull
    @Override
    public PokemonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.pokemon_item, parent, false);
        return new PokemonViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull PokemonViewHolder holder, int position) {
        Pokemon currentPokemon = mPokemonList.get(position);

        String imageURL = currentPokemon.ImageURL;
        Picasso.with(mContext).load(imageURL).fit().centerInside().into(holder.mImageView);
    }

    @Override
    public int getItemCount() {
        return mPokemonList.size();
    }

    public class PokemonViewHolder extends RecyclerView.ViewHolder {
        public ImageView mImageView;

        public PokemonViewHolder(@NonNull View itemView) {
            super(itemView);
            mImageView = itemView.findViewById(R.id.image_view);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if(mListener!=null){
                        int position=getAdapterPosition();
                        if(position!=RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
