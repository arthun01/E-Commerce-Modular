package br.com.loja.interfaces;

/**
 * Interface que define o contrato para objetos que podem ser tributáveis.
 * <p>
 * Qualquer classe que implemente esta interface (como {@link br.com.loja.modelo.Televisao} 
 * ou {@link br.com.loja.modelo.Celular}) assume o compromisso de definir uma lógica 
 * para o cálculo do seu próprio tributo.
 * </p>
 * * @author Grupo Java
 * @version 1.0
 */
public interface Tributavel{

    /**
     * Calcula o valor do imposto do objeto.
     * <p>
     * A implementação deste método deve considerar as características específicas 
     * do produto (peso, dimensões, seguro, etc.) para retornar o custo do imposto.
     * </p>
     * * @return Um valor double representando o custo do imposto em Reais (R$).
     */
    double calcularImposto();
}