package br.com.loja.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

/**
 * Representa um consumidor no sistema de e-commerce.
 * <p>
 * Esta classe é responsável por armazenar os dados pessoais do cliente (Nome e CPF)
 * e gerenciar o seu carrinho de compras. Além disso, fornece utilitários estáticos
 * para a validação de documentos (CPF) seguindo as regras da Receita Federal.
 * </p>
 *
 * @author Grupo Java
 * @version 1.0
 * @see Produto
 */

public class Cliente{
    private String nome;
    private String cpf;
    private List<Produto> carrinho;

    /**
     * Construtor padrão do Cliente.
     * <p>
     * Inicializa o cliente com seus dados básicos e instancia uma lista vazia
     * para o carrinho de compras.
     * </p>
     * * @param nome O nome do cliente.
     * @param cpf O CPF (Cadastro de Pessoas Físicas) do cliente.
     */

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


    /**
     * Adiciona um produto ao carrinho de compras do cliente.
     * * @param p O objeto {@link Produto} a ser adicionado.
     */

    public void adicionarItem(Produto p){
        this.carrinho.add(p);
        System.out.println(p.nome + " adicionado ao carrinho de " + this.nome);
    }
    
    /**
     * Remove um produto do carrinho de compras do cliente com base na chave (índice).
     * * @param chave O índice (posição na lista) do produto a ser removido.
     */

    public void removerItem(int chave){
        this.carrinho.remove(chave);
    }

    /**
     * Retorna a lista de produtos atual no carrinho de compras do cliente.
     * * @return Uma lista contendo os objetos {@link Produto} no carrinho.
     */

    public List<Produto> getCarrinho(){
        return this.carrinho;
    }

    /**
     * Realiza a validação matemática de um CPF brasileiro.
     * <p>
     * O algoritmo executa os seguintes passos:
     * <ul>
     * <li>Remove caracteres não numéricos (pontos e traços).</li>
     * <li>Verifica se é uma sequência de números iguais (ex: 11111111111), que são inválidos.</li>
     * <li>Calcula o primeiro dígito verificador baseado nos 9 primeiros números.</li>
     * <li>Calcula o segundo dígito verificador baseado nos 10 primeiros números.</li>
     * <li>Compara os dígitos calculados com os informados.</li>
     * </ul>
     * </p>
     * * @param cpf A string contendo o CPF a ser validado.
     * @return {@code true} se o CPF for válido, {@code false} caso contrário.
     */

    public static boolean CPFValido(String cpf) {
        // para remover caracteres não numéricos
        cpf = cpf.replace(".", "").replace("-", "");
        
        // checando se todos os dígitos são iguais
        if (cpf.equals("00000000000") || cpf.equals("11111111111") ||
            cpf.equals("22222222222") || cpf.equals("33333333333") ||
            cpf.equals("44444444444") || cpf.equals("55555555555") ||
            cpf.equals("66666666666") || cpf.equals("77777777777") ||
            cpf.equals("88888888888") || cpf.equals("99999999999") ) {
            return false;
        }
        char dig10, dig11;
        int soma, i, resultado, numero, peso;

        try {
            // calculo do primeiro digito verificador
            soma = 0;
            peso = 10;
            for (i = 0; i < 9; i++) {
                numero = (int) (cpf.charAt(i) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }
            resultado = 11 - (soma % 11);
            if ((resultado == 10) || (resultado == 11))
                dig10 = '0';
            else
                dig10 = (char) (resultado + 48);

            // calculo do segundo digito verificador

            soma = 0;
            peso = 11;
            for (i = 0; i < 10; i++) {
                numero = (int) (cpf.charAt(i) - 48);
                soma = soma + (numero * peso);
                peso = peso - 1;
            }
            resultado = 11 - (soma % 11);
            if ((resultado == 10) || (resultado == 11))
                dig11 = '0';
            else
                dig11 = (char) (resultado + 48);
            // verificando se os digitos calculados conferem com os digitos informados
            if ((dig10 == cpf.charAt(9)) && (dig11 == cpf.charAt(10)))
                return true;
            else
                return false;
        } catch (InputMismatchException erro) {
            return false;
        }
    }
}