package br.com.loja.modelo;

import br.com.loja.interfaces.Tributavel;
import br.com.loja.interfaces.Transportavel;

/**
 * Representa um produto do tipo Televisao no e-commerce.
 * <p>
 * Esta classe estende a classe abstrata {@link Produto} e implementa as
 * interfaces {@link Tributavel} e {@link Transportavel}, definindo regras
 * específicas de etiqueta, imposto e frete para celulares.
 * </p>
 * * @author Grupo Java
 * @version 1.0
 * @see Produto
 * @see Tributavel
 */
public class Televisao extends Produto implements Tributavel, Transportavel{
    /**
     * Construtor da classe Televisao.
     * * @param nome  O nome do modelo da televisao.
     * @param preco O preço base da televisao.
     */
    public Televisao(String nome, double preco){
        super(nome, preco);
    }

    /**
     * Gera uma etiqueta formatada para a televisao.
     * Sobrescreve o método abstrato da classe mãe.
     * * @return Uma String contendo "Televisao:", o nome e o preço formatados.
     */
    @Override
    public String getEtiqueta(){
        return "TV: " + this.nome + " | R$ " + this.preco;
    }

    /**
     * Calcula o imposto específico para Televisoes.
     * <p>
     * Regra de negócio: Televisoes possuem uma taxa de imposto de 8% sobre o valor.
     * </p>
     * * @return O valor do imposto calculado (8% do preço).
     */
    @Override
    public double calcularImposto(){
        return this.preco * 0.08;
    }

    /**
     * Calcula o valor do frete para o transporte da televisao.
     * <p>
     * Regra de negócio: Celulares possuem frete fixo devido ao seguro de transporte.
     * </p>
     * * @return O valor fixo de R$ 30.00.
     */
    @Override
    public double calcularFrete(){
        return 30.00;
    }
}