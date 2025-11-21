package br.com.loja.app;
import br.com.loja.modelo.Televisao;
import br.com.loja.modelo.Celular;
import br.com.loja.modelo.Sofa;

import br.com.loja.modelo.Cliente;
import br.com.loja.financeiro.NotaFiscal;

public class SistemaLoja{
    public static void main(String[] args){
        Cliente arthur = new Cliente("Arthur", "123.456.789-12");

        Televisao tvSala = new Televisao("Samsung 55", 3000.00);
        Celular smartPhone = new Celular("Samsung S24", 3500.00);
        Sofa sofaNovo = new Sofa("King House", 4500.00);

        arthur.adicionarItem(tvSala);
        arthur.adicionarItem(smartPhone);
        arthur.adicionarItem(sofaNovo);

        NotaFiscal nf = new NotaFiscal();
        nf.gerar(arthur);
    }
}