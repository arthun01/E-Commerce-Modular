# --- Variáveis de Configuração ---
# Compilador e Executador Java
JAVAC = javac
JAVA = java

# Diretório onde estão os códigos
SRC_DIR = src

# Lista de arquivos para compilar (os 3 pacotes do seu projeto)
SOURCES = $(SRC_DIR)/br/com/loja/modelo/*.java \
          $(SRC_DIR)/br/com/loja/financeiro/*.java \
          $(SRC_DIR)/br/com/loja/interfaces/*.java \
          $(SRC_DIR)/br/com/loja/app/*.java

# A classe principal que tem o método main()
MAIN_CLASS = br.com.loja.app.SistemaLoja

# --- Regras de Execução ---

# Regra padrão (o que acontece se você digitar apenas 'make')
all: compile

# 1. Compilar: Transforma os .java em .class
compile:
	@echo "Compilando o projeto..."
	$(JAVAC) -cp $(SRC_DIR) $(SOURCES)
	@echo "Compilacao concluida com sucesso!"

# 2. Rodar: Executa o programa principal
run: compile
	@echo "--------------------------------"
	@echo "Executando o SistemaLoja:"
	@echo "--------------------------------"
	$(JAVA) -cp $(SRC_DIR) $(MAIN_CLASS)

# 3. Limpar: Apaga os arquivos .class (faxina)
# Nota: Se estiver no Windows (cmd), troque 'rm -f' por 'del /s /q'
clean:
	@echo "Limpando arquivos compilados (.class)..."
	rm -f $(SRC_DIR)/br/com/loja/modelo/*.class
	rm -f $(SRC_DIR)/br/com/loja/financeiro/*.class
	rm -f $(SRC_DIR)/br/com/loja/app/*.class
	rm -f $(SRC_DIR)/br/com/loja/interfaces/*.class
	@echo "Limpeza concluida."