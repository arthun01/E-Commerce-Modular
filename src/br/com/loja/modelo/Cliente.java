package br.com.loja.modelo;

import java.util.ArrayList;
import java.util.List;
import java.util.InputMismatchException;

public class Cliente{
    private String nome;
    private String cpf;
    private List<Produto> carrinho;

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

    public void adicionarItem(Produto p){
        this.carrinho.add(p);
        System.out.println(p.nome + " adicionado ao carrinho de " + this.nome);
    }

    public void removerItem(int chave){
        this.carrinho.remove(chave);
    }

    public List<Produto> getCarrinho(){
        return this.carrinho;
    }

    // metodo para validar cpf
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