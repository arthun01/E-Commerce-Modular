package br.com.loja.modelo;

import br.com.loja.interfaces.Tributavel;
import br.com.loja.interfaces.Transportavel;

public class Televisao extends Produto implements Tributavel, Transportavel{
    public Televisao(String nome, double preco){
        super(nome, preco);
    }

    // reescrita por ser filho de Produto (abstract)
    @Override
    public String getEtiqueta(){
        return "TV: " + this.nome + " | R$ " + this.preco;
    }

    // reescrita por ser Tributavel
    @Override
    public double calcularImposto(){
        return this.preco * 0.10;
    }

    // reescrita por ser Transportável
    @Override
    public double calcularFrete(){
        return 50.00;
    }
}