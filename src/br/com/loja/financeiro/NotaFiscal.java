package br.com.loja.financeiro;

import java.util.List;
import br.com.loja.interfaces.Tributavel;
import br.com.loja.interfaces.Transportavel;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.Produto;

public class NotaFiscal {
  public void gerar(Cliente c) {
    System.out.println("========== NOTA FISCAL ==========");
    System.out.println("- Cliente: " + c.getNome());
    System.out.println("- CPF: " + c.getCpf());
    System.out.println("=================================");

    double totalGeral = 0;
    List<Produto> itens = c.getCarrinho();

    for (Produto p : itens) {
      double valorItem = p.getPreco();
      System.out.println("Item (" + p.getId() + "): " + p.getEtiqueta());

      if (p instanceof Tributavel) {
        double imposto = ((Tributavel) p).calcularImposto();
        valorItem += imposto;
        System.out.println(" + Imposto: R$ " + imposto);
      }

      if (p instanceof Transportavel) {
        double frete = ((Transportavel) p).calcularFrete();
        valorItem += frete;
        System.out.println(" + Frete: R$ " + frete);
      }

      System.out.println(" = Subtotal: R$ " + valorItem);
      System.out.println("---------------------------------");

      totalGeral += valorItem;
    }

    System.out.println("TOTAL A PAGAR: R$ " + totalGeral);
    System.out.println("=================================");
  }
}
