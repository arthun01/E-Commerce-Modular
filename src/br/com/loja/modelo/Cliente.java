package br.com.loja.modelo;

import java.util.ArrayList;
import java.util.List;

public class Cliente{
    private String nome;
    private String cpf;
    private List<Produto> carrinho;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        this.carrinho = new ArrayList<>();
    }

    public String getNome(){
        return this.nome;
    }

    public String getCpf(){
        return this.cpf;
    }

    public void adicionarItem(Produto p){
        this.carrinho.add(p);
        System.out.println(p.nome + " adicionado ao carrinho de " + this.nome);
    }

    public void removerItem(int chave){
        this.carrinho.remove(chave);
    }

    public List<Produto> getCarrinho(){
        return this.carrinho;
    }
}