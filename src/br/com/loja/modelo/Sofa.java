package br.com.loja.modelo;

import br.com.loja.interfaces.Tributavel;
import br.com.loja.interfaces.Transportavel;

/**
 * Representa um produto do tipo Sofa no e-commerce.
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
public class Sofa extends Produto implements Tributavel, Transportavel{
    /**
     * Construtor da classe Sofa.
     * * @param nome  O nome do modelo do sofa.
     * @param preco O preço base do sofa.
     */
    public Sofa(String nome, double preco){
        super(nome, preco);
    }

    /**
     * Gera uma etiqueta formatada para o sofa.
     * Sobrescreve o método abstrato da classe mãe.
     * * @return Uma String contendo "Sofa:", o nome e o preço formatados.
     */
    @Override
    public String getEtiqueta(){
        return "Sofa: " + this.nome + " | R$ " + this.preco;
    }

    /**
     * Calcula o imposto específico para sofas.
     * <p>
     * Regra de negócio: Sofas possuem uma taxa de imposto de 6% sobre o valor.
     * </p>
     * * @return O valor do imposto calculado (6% do preço).
     */
    @Override
    public double calcularImposto(){
        return this.preco * 0.06;
    }

    /**
     * Calcula o valor do frete para o transporte do sofa.
     * <p>
     * Regra de negócio: Celulares possuem frete fixo devido ao seguro de transporte.
     * </p>
     * * @return O valor fixo de R$ 25.00.
     */
    @Override
    public double calcularFrete(){
        return 25.00;
    }
}