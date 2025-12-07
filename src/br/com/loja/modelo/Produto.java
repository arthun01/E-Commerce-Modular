package br.com.loja.modelo;

/**
 * Classe abstrata que representa um produto genérico no sistema de e-commerce.
 * <p>
 * Esta classe serve como base para todos os tipos de produtos (ex: {@link Celular}, 
 * {@link Televisao}, etc.), gerenciando atributos comuns como nome, preço e 
 * um identificador único (ID) gerado automaticamente.
 * </p>
 * * @author Grupo Java
 * @version 1.0
 */
public abstract class Produto{
  
  /** * Nome do produto. 
   * É protegido (protected) para permitir acesso direto pelas subclasses.
   */
  protected String nome;
  
  /** * Preço base do produto. 
   * É protegido (protected) para permitir acesso direto pelas subclasses.
   */
  protected double preco;
  
  /** * Contador estático para gerar IDs sequenciais automaticamente. 
   */
  private static int contadorId = 0;
  
  /** * Identificador único da instância do produto. 
   */
  private int id;

  /**
   * Construtor padrão para inicializar um Produto.
   * <p>
   * Ao criar um produto, um ID único é atribuído automaticamente incrementando
   * o contador estático da classe.
   * </p>
   * * @param nome  O nome ou modelo do produto.
   * @param preco O preço unitário do produto.
   */
  public Produto(String nome, double preco){
    this.nome = nome;
    this.preco = preco;
    this.id = contadorId++;
  }

  /**
   * Obtém o preço atual do produto.
   * * @return O valor do preço (double).
   */
  public double getPreco(){
    return this.preco;
  }

  /**
   * Obtém o identificador único do produto.
   * * @return Um inteiro representando o ID gerado automaticamente.
   */
  public int getId(){
    return this.id;
  }

  /**
   * Obtém o nome do produto.
   * * @return A String contendo o nome.
   */
  public String getNome(){
    return this.nome;
  }

  /**
   * Método abstrato para gerar a etiqueta de exibição do produto.
   * <p>
   * <b>Importante:</b> Todas as classes que herdarem de {@code Produto} 
   * SÃO OBRIGADAS a implementar este método, definindo como o produto 
   * deve ser apresentado (formatado) para o cliente.
   * </p>
   * * @return Uma String formatada com os detalhes do produto.
   */
  public abstract String getEtiqueta();
}