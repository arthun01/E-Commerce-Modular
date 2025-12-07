package br.com.loja.financeiro;

import java.util.List;
import br.com.loja.interfaces.Tributavel;
import br.com.loja.interfaces.Transportavel;
import br.com.loja.modelo.Cliente;
import br.com.loja.modelo.Produto;

import static java.lang.String.format;

/**
 * Responsável pela lógica financeira e emissão de comprovantes de venda.
 * <p>
 * Esta classe processa o carrinho de compras de um {@link Cliente}, verifica
 * quais produtos estão sujeitos a impostos ou frete (baseado nas interfaces
 * implementadas) e calcula o valor final da compra.
 * </p>
 *
 * @author Grupo Java
 * @version 1.0
 * @see Cliente
 * @see Tributavel
 * @see Transportavel
 */
public class NotaFiscal{

  /**
   * Gera e imprime a nota fiscal detalhada no console.
   * <p>
   * O método percorre todos os itens do carrinho do cliente e realiza as seguintes operações:
   * <ul>
   * <li>Exibe o nome e preço base do produto.</li>
   * <li>Verifica dinamicamente (via {@code instanceof}) se o produto implementa {@link Tributavel}.
   * Se sim, calcula e soma o imposto.</li>
   * <li>Verifica dinamicamente se o produto implementa {@link Transportavel}.
   * Se sim, calcula e soma o frete.</li>
   * <li>Exibe o subtotal do item e acumula no total geral.</li>
   * </ul>
   * </p>
   *
   * @param c O cliente que está realizando a compra. Não deve ser nulo.
   */
  public void gerar(Cliente c){
    System.out.println("========== NOTA FISCAL ==========");
    System.out.println("- Cliente: " + c.getNome());
    System.out.println("- CPF: " + c.getCpf());
    System.out.println("=================================");

    double totalGeral = 0;
    List<Produto> itens = c.getCarrinho();

    for (Produto p : itens){
      double valorItem = p.getPreco();
      // Exibe a etiqueta (polimorfismo: chama o getEtiqueta da subclasse específica)
      System.out.println("Item (" + p.getId() + "): " + p.getEtiqueta());

      // Verificação de Interface (Polimorfismo e Segurança de Tipos)
      if (p instanceof Tributavel){
        double imposto = ((Tributavel) p).calcularImposto();
        valorItem += imposto;
        System.out.println(" + Imposto: R$ " + imposto);

        double iof = TaxaInterna.calcularIOF(valorItem);
        valorItem += iof;
        System.out.println(" + IOF (Taxa Interna): R$ " + format("%.2f", iof));
      }

      if (p instanceof Transportavel){
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