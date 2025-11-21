package br.com.loja.modelo;

import br.com.loja.interfaces.Tributavel;
import br.com.loja.interfaces.Transportavel;

public class Celular extends Produto implements Tributavel, Transportavel{
    public Celular(String nome, double preco){
        super(nome, preco);
    }

    @Override
    public String getEtiqueta(){
        return "Celular: " + this.nome + " | R$ " + this.preco;
    }

    @Override
    public double calcularImposto(){
        return this.preco * 0.10;
    }

    @Override
    public double calcularFrete(){
        return 50.00;
    }
}