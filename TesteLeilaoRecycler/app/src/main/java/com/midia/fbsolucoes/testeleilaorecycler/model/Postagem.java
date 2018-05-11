package com.midia.fbsolucoes.testeleilaorecycler.model;

/**
 * Created by Pessoal on 09/05/2018.
 */

public class Postagem {

    private String nome;
    private String preco;
    private String cidade;
    private String data;
    private String tempo;
    private String imagem_url;

    public Postagem() {
    }

    public Postagem(String nome, String preco, String cidade, String data, String tempo, String imagem_url) {
        this.nome = nome;
        this.preco = preco;
        this.cidade = cidade;
        this.data = data;
        this.tempo = tempo;
        this.imagem_url = imagem_url;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getPreco() {
        return preco;
    }

    public void setPreco(String preco) {
        this.preco = preco;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getTempo() {
        return tempo;
    }

    public void setTempo(String tempo) {
        this.tempo = tempo;
    }

    public String getImagem_url() {
        return imagem_url;
    }

    public void setImagem_url(String imagem_url) {
        this.imagem_url = imagem_url;
    }
}
