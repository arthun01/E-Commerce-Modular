package br.com.loja.modelo;

public abstract class Produto{
    protected String nome;
    protected double preco;
    private static int contadorId = 0;
    private int id;

    public Produto(String nome, double preco){
        this.nome = nome;
        this.preco = preco;
        this.id = contadorId++;
    }

    public double getPreco(){
        return this.preco;
    }

    public int getId(){
        return this.id;
    }

    // método abstrato
    public abstract String getEtiqueta();
}