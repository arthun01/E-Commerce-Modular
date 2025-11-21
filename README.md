# 🛒 E-Commerce Modular

[](https://www.java.com/)
[](https://opensource.org/)

-----

## 🇧🇷 E-Commerce Modular (Português)

### 📝 Sobre o Projeto

Este é um sistema de simulação de E-Commerce desenvolvido em Java, focado em **Programação Orientada a Objetos (POO)** e arquitetura modular. O projeto demonstra como desacoplar regras de negócio utilizando pacotes bem definidos para separar modelos, lógica financeira, interfaces e a aplicação principal.

O sistema gerencia clientes, carrinhos de compras e gera notas fiscais calculando automaticamente impostos e fretes baseados em contratos de interface (`Tributavel`, `Transportavel`).

### 🚀 Tecnologias e Conceitos

  * **Java (JDK)**
  * **Make** (Automação de compilação)
  * **POO:** Herança, Polimorfismo, Encapsulamento e Abstração.
  * **Interfaces:** Para contratos de cálculo de impostos e frete.

### 📂 Estrutura do Projeto

O código está organizado nos seguintes pacotes dentro de `src/br/com/loja`:

  * `app`: Contém a classe `SistemaLoja` (Main), ponto de entrada da aplicação.
  * `modelo`: Classes de domínio como `Cliente`, `Produto`, `Celular` e `Televisao`.
  * `financeiro`: Lógica de negócios como `NotaFiscal` e `TaxaInterna`.
  * `interfaces`: Contratos `Transportavel` e `Tributavel`.

### ⚙️ Como Executar

Este projeto inclui um `Makefile` configurado para facilitar a compilação e execução.

#### Pré-requisitos

  * Java JDK instalado.
  * Make instalado (opcional, mas recomendado).

#### Usando Make (Recomendado)

Abra o terminal na raiz do projeto e execute:

1.  **Compilar e Rodar:**
    ```bash
    make run
    ```
2.  **Apenas Compilar:**
    ```bash
    make
    ```
3.  **Limpar arquivos compilados (.class):**
    ```bash
    make clean
    ```

#### Compilação Manual (Sem Make)

Caso não tenha o Make, você pode compilar manualmente via terminal:

```bash
# Compilar
javac -cp src src/br/com/loja/app/SistemaLoja.java src/br/com/loja/modelo/*.java src/br/com/loja/financeiro/*.java src/br/com/loja/interfaces/*.java

# Executar
java -cp src br.com.loja.app.SistemaLoja
```

-----

### 🧠 Exemplo de Saída

Ao executar o sistema, o console exibirá a geração da Nota Fiscal com cálculos automáticos:

```text
========== NOTA FISCAL ==========
- Cliente: Arthur
- CPF: 123.456.789-12
=================================
Item (0): TV: Samsung 55 | R$ 3000.0
 + Imposto: R$ 300.0
 + Frete: R$ 50.0
 = Subtotal: R$ 3350.0
---------------------------------
...
TOTAL A PAGAR: R$ X.XXX
```

-----

-----

## 🇺🇸 Modular E-Commerce (English)

### 📝 About the Project

This is an E-Commerce simulation system developed in Java, focusing on **Object-Oriented Programming (OOP)** and modular architecture. The project demonstrates how to decouple business rules using well-defined packages to separate models, financial logic, interfaces, and the main application.

The system manages clients and shopping carts, automatically generating invoices by calculating taxes and shipping fees based on interface contracts (`Tributavel`, `Transportavel`).

### 🚀 Technologies & Concepts

  * **Java (JDK)**
  * **Make** (Build automation)
  * **OOP:** Inheritance, Polymorphism, Encapsulation, and Abstraction.
  * **Interfaces:** Contracts for tax and shipping calculations.

### 📂 Project Structure

The code is organized into the following packages under `src/br/com/loja`:

  * `app`: Contains the `SistemaLoja` (Main) class, the application entry point.
  * `modelo`: Domain classes such as `Cliente`, `Produto` (Abstract), `Celular`, and `Televisao`.
  * `financeiro`: Business logic like `NotaFiscal` and `TaxaInterna`.
  * `interfaces`: Contracts `Transportavel` (Transportable) and `Tributavel` (Taxable).

### ⚙️ How to Run

This project includes a `Makefile` configured to streamline compilation and execution.

#### Prerequisites

  * Java JDK installed.
  * Make installed (optional, but recommended).

#### Using Make (Recommended)

Open your terminal in the project root and run:

1.  **Compile and Run:**
    ```bash
    make run
    ```
2.  **Compile Only:**
    ```bash
    make
    ```
3.  **Clean compiled files (.class):**
    ```bash
    make clean
    ```

#### Manual Compilation (Without Make)

If you don't have Make, you can compile manually via terminal:

```bash
# Compile
javac -cp src src/br/com/loja/app/SistemaLoja.java src/br/com/loja/modelo/*.java src/br/com/loja/financeiro/*.java src/br/com/loja/interfaces/*.java

# Run
java -cp src br.com.loja.app.SistemaLoja
```

-----

### 🧠 Output Example

When running the system, the console will display the Invoice generation with automatic calculations:

```text
========== NOTA FISCAL ==========
- Cliente: Arthur
- CPF: 123.456.789-12
=================================
Item (0): TV: Samsung 55 | R$ 3000.0
 + Imposto: R$ 300.0
 + Frete: R$ 50.0
 = Subtotal: R$ 3350.0
---------------------------------
...
TOTAL A PAGAR: R$ X.XXX
```