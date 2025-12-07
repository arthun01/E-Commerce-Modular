package br.com.loja.interfaces;

/**
 * Interface que define o contrato para objetos que podem ser transportados.
 * <p>
 * Qualquer classe que implemente esta interface (como {@link br.com.loja.modelo.Televisao} 
 * ou {@link br.com.loja.modelo.Celular}) assume o compromisso de definir uma lógica 
 * para o cálculo do seu próprio frete.
 * </p>
 * * @author Grupo Java
 * @version 1.0
 */
public interface Transportavel{

    /**
     * Calcula o valor do frete para o transporte do objeto.
     * <p>
     * A implementação deste método deve considerar as características específicas 
     * do produto (peso, dimensões, seguro, etc.) para retornar o custo de envio.
     * </p>
     * * @return Um valor double representando o custo do frete em Reais (R$).
     */
    double calcularFrete();
}