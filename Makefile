# --- Variáveis de Configuração ---
JAVAC = javac
JAVA = java

# Diretório onde estão os códigos
SRC_DIR = src

SOURCES = $(SRC_DIR)/br/com/loja/modelo/*.java \
          $(SRC_DIR)/br/com/loja/financeiro/*.java \
          $(SRC_DIR)/br/com/loja/interfaces/*.java \
          $(SRC_DIR)/br/com/loja/app/*.java

MAIN_CLASS = br.com.loja.app.SistemaLoja

# --- Regras de Execução ---

all: compile

compile:
	@echo "Compilando o projeto..."
	$(JAVAC) -cp $(SRC_DIR) $(SOURCES)
	@echo "Compilacao concluida com sucesso!"

run: compile
	$(JAVA) -cp $(SRC_DIR) $(MAIN_CLASS)
	@echo "--------------------------------"
	@echo "Executando o SistemaLoja:"
	@echo "--------------------------------"

# Nota: Se estiver no Windows (cmd), troque 'rm -f' por 'del /s /q'
clean:
	@echo "Limpando arquivos compilados (.class)..."
	rm -f $(SRC_DIR)/br/com/loja/modelo/*.class
	rm -f $(SRC_DIR)/br/com/loja/financeiro/*.class
	rm -f $(SRC_DIR)/br/com/loja/app/*.class
	rm -f $(SRC_DIR)/br/com/loja/interfaces/*.class
	@echo "Limpeza concluida."