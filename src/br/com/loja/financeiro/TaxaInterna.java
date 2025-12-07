package br.com.loja.financeiro;

/**
 * Classe utilitária para cálculos de taxas internas financeiras.
 * <p>
 * <b>Nota sobre Encapsulamento:</b> Esta classe foi desenhada para ser usada
 * apenas dentro do pacote {@code br.com.loja.financeiro}.
 * </p>
 *
 * @author Grupo Java
 * @version 1.0
 */
public class TaxaInterna{

    /**
     * Calcula o Imposto sobre Operações Financeiras (IOF).
     * <p>
     * <b>Atenção:</b> Este método possui visibilidade de pacote (<i>package-private</i>),
     * ou seja, não possui modificador de acesso explícito. Isso significa que ele
     * SÓ pode ser chamado por classes vizinhas no mesmo pacote (como a {@link NotaFiscal}),
     * ficando invisível para o resto do sistema.
     * </p>
     *
     * @param valor O valor monetário sobre o qual o imposto será aplicado.
     * @return O valor do IOF calculado (6% do valor informado).
     */
    static double calcularIOF(double valor){
        return valor * 0.005;
    }
}