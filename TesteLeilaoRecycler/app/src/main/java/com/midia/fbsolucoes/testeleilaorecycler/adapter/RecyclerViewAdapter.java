package com.midia.fbsolucoes.testeleilaorecycler.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.midia.fbsolucoes.testeleilaorecycler.model.Postagem;
import com.midia.fbsolucoes.testeleilaorecycler.R;

import java.util.List;

/**
 * Created by Pessoal on 09/05/2018.
 */

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.MyViewHolder> {

    private Context mContext;
    private List<Postagem> mData;
    RequestOptions option;

    public RecyclerViewAdapter(Context mContext, List<Postagem> mData) {
        this.mContext = mContext;
        this.mData = mData;

        //Request option for glide
        option = new RequestOptions().centerCrop().placeholder(R.drawable.loading_img_produto).error(R.drawable.loading_img_produto);

    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater inflater = LayoutInflater.from(mContext);
        view = inflater.inflate(R.layout.home, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {

        holder.tv_tempo.setText(mData.get(position).getTempo());
        holder.tv_preco.setText(mData.get(position).getPreco());
        holder.tv_nome.setText(mData.get(position).getNome());
        holder.tv_data.setText(mData.get(position).getData());
        holder.tv_cidade.setText(mData.get(position).getCidade());

        Glide.with(mContext).load(mData.get(position).getImagem_url()).apply(option).into(holder.img_produto);
    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv_nome;
        TextView tv_preco;
        TextView tv_cidade;
        TextView tv_data;
        TextView tv_tempo;
        ImageView img_produto;

        public MyViewHolder(View itemView) {
            super(itemView);

            tv_cidade = itemView.findViewById(R.id.cidade);
            tv_data = itemView.findViewById(R.id.data);
            tv_nome = itemView.findViewById(R.id.nomeProduto);
            tv_preco = itemView.findViewById(R.id.preco);
            tv_tempo = itemView.findViewById(R.id.tempo);
            img_produto = itemView.findViewById(R.id.produto);
        }
    }
}
