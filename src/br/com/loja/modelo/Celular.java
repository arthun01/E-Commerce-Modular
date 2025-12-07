package br.com.loja.modelo;

import br.com.loja.interfaces.Tributavel;
import br.com.loja.interfaces.Transportavel;

/**
 * Representa um produto do tipo Celular no e-commerce.
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
public class Celular extends Produto implements Tributavel, Transportavel{
    /**
     * Construtor da classe Celular.
     * * @param nome  O nome do modelo do celular.
     * @param preco O preço base do celular.
     */
    public Celular(String nome, double preco){
        super(nome, preco);
    }

    /**
     * Gera uma etiqueta formatada para o celular.
     * Sobrescreve o método abstrato da classe mãe.
     * * @return Uma String contendo "Celular:", o nome e o preço formatados.
     */
    @Override
    public String getEtiqueta(){
        return "Celular: " + this.nome + " | R$ " + this.preco;
    }

    /**
     * Calcula o imposto específico para celulares.
     * <p>
     * Regra de negócio: Celulares possuem uma taxa de imposto de 10% sobre o valor.
     * </p>
     * * @return O valor do imposto calculado (10% do preço).
     */
    @Override
    public double calcularImposto(){
        return this.preco * 0.10;
    }

    /**
     * Calcula o valor do frete para o transporte do celular.
     * <p>
     * Regra de negócio: Celulares possuem frete fixo devido ao seguro de transporte.
     * </p>
     * * @return O valor fixo de R$ 50.00.
     */
    @Override
    public double calcularFrete(){
        return 50.00;
    }
}