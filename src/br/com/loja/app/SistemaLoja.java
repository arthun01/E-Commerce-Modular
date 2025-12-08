package br.com.loja.app;

import br.com.loja.modelo.*;

import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

import br.com.loja.financeiro.NotaFiscal;

import static java.lang.String.format;

/**
 * Classe principal responsável pela execução e orquestração do sistema de e-commerce.
 * <p>
 * Esta classe atua como o ponto de entrada da aplicação (Front-end via Console).
 * Ela gerencia a interação com o usuário, mantém o fluxo de validação de dados
 * (como CPF) e controla o loop de adição de produtos ao carrinho antes de
 * solicitar a emissão da nota fiscal.
 * </p>
 *
 * @author Grupo Java
 * @version 1.0
 * @see Cliente
 * @see Produto
 * @see NotaFiscal
 */

public class SistemaLoja {

  /**
   * Método de execução principal da aplicação.
   * <p>
   * O fluxo de execução segue as seguintes etapas:
   * <ul>
   * <li>Inicializa o estoque da loja com produtos pré-definidos (Polimorfismo).</li>
   * <li>Coleta e valida os dados do comprador (Nome e CPF) através de loops de verificação.</li>
   * <li>Apresenta o catálogo de produtos e permite a adição interativa ao carrinho.</li>
   * <li>Finaliza a compra acionando a classe {@link NotaFiscal} para cálculos tributários.</li>
   * </ul>
   * </p>
   * * @param args Argumentos de linha de comando (não utilizados nesta versão).
   */
  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);
    List<Produto> estoque = new ArrayList<>();

    estoque.add(new Televisao("Samsung 55", 3000.00));
    estoque.add(new Celular("Samsung S24", 3500.00));
    estoque.add(new Sofa("King House", 4500.00));

    System.out.println("==================================================");
    System.out.print("Bem-vindo!\nInsira seu nome: ");
    String nome = scanner.nextLine();
    System.out.println();

    // inserir e verificar cpf
    String cpf = "";
    while(true){
      System.out.print("Agora insira seu CPF: ");
      cpf = scanner.nextLine();

      // verificando a validade do cpf (se são só números)
      if(!cpf.matches("[0-9]+")){
        System.out.println("X Erro: O CPF deve conter apenas números! Tente novamente.");
        continue;
      }

      // verificando a validade do cpf (se tem exatamente 11 dígitos)
      if(cpf.length() != 11){
        System.out.println("X Erro: O CPF deve conter exatamente 11 dígitos! Tente novamente.");
        continue;
      }
        // verificando a validade do cpf (se é um cpf válido)
        if(!Cliente.CPFValido(cpf)){
          System.out.println("X Erro: CPF inválido! Tente novamente.");
          continue;
        }

      // se estiver tudo certo sai do loop
      break;
    }

    Cliente cliente = new Cliente(nome, cpf);

    boolean continuarComprando = true;
    while (continuarComprando) {
      System.out.println("==================================");
      System.out.println("\nProdutos disponíveis no estoque: ");
      for (int i = 0; i < estoque.size(); i++) {
        Produto p = estoque.get(i);
        // uso de import static
        System.out.println(i + " - " + p.getNome() + " (R$ " + format("%.2f", p.getPreco()) + ")");
      }
      System.out.println(estoque.size() + " - Finalizar Compra");
      System.out.print("Digite o número do produto que deseja adicionar ao carrinho ou " + estoque.size() + " para finalizar: ");

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
        System.out.println("- " + p.getNome() + " (R$ " + format("%.2f", p.getPreco()) + ")");
      }
    }

    NotaFiscal nf = new NotaFiscal();
    nf.gerar(cliente);

    scanner.close();
  }
}
