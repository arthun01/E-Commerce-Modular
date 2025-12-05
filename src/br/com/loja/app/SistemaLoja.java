package br.com.loja.app;

import br.com.loja.modelo.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.loja.financeiro.NotaFiscal;

public class SistemaLoja {
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    List<Produto> estoque = new ArrayList<>();

    estoque.add(new Televisao("Samsung 55", 3000.00));
    estoque.add(new Celular("Samsung S24", 3500.00));
    estoque.add(new Sofa("King House", 4500.00));

    System.out.println("==================================================");
    System.out.print("Bem-vindo! Insira seu nome: ");
    String nome = scanner.nextLine();
    System.out.println();
    System.out.print("Agora insira seu CPF: ");
    String cpf = scanner.nextLine();

    Cliente cliente = new Cliente(nome, cpf);

    boolean continuarComprando = true;
    while (continuarComprando) {
      System.out.println("\nProdutos disponíveis no estoque: ");
      for (int i = 0; i < estoque.size(); i++) {
        Produto p = estoque.get(i);
        System.out.println(i + " - " + p.getNome() + " (R$ " + String.format("%.2f", p.getPreco()) + ")");
      }
      System.out.println(estoque.size() + " - Finalizar Compra");
      System.out.print(
          "Digite o número do produto que deseja adicionar ao carrinho ou" + estoque.size() + " para finalizar: ");

      int escolha = -1;
      try {
        escolha = scanner.nextInt();
      } catch (InputMismatchException e) {
        System.out.println("Opção inválida. Por favor, insira um valor válido.");
        scanner.nextLine();
        continue;
      }

      if (escolha >= 0 && escolha < estoque.size()) {
        Produto produtoEscolhido = estoque.get(escolha);
        cliente.adicionarItem(produtoEscolhido);
      } else if (escolha == estoque.size()) {
        continuarComprando = false;
        System.out.println("Finalizando operação...");
      } else {
        System.out.println("Opção inválida. Por favor, escolha um número existente da lista.");
      }
    }

    System.out.println("\n === Resumo do Carrinho ===");
    if (cliente.getCarrinho().isEmpty()) {
      System.out.println("Seu carrinho está vazio.");
    } else {
      for (Produto p : cliente.getCarrinho()) {
        System.out.println("- " + p.getNome() + " (R$ " + String.format("%.2f", p.getPreco()) + ")");
      }
    }

    NotaFiscal nf = new NotaFiscal();
    nf.gerar(cliente);

    scanner.close();
  }
}
