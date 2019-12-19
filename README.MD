# CWI Turing

CWI Turing é uma solução intuitiva para aplicar provas com questões de múltipla escolha e de implementação técnica, com um tempo de expiração pré-definido, para que seja possível avaliar profissionais interessados em fazer parte do grupo de profissionais da CWI.

#### Recursos

+ Cadastro de questões:
  - Múltipla escolha (5 alternativas).
  - Dissertativa.
  - Técnica (código)


+ Geração de prova
+ Resolução de prova pelo candidato
+ Correção das questões da prova
+ Visualização dos resultados do candidato (em PDF)

## Instalação

Use o gerenciador de pacotes [npm](https://docs.npmjs.com/about-npm/) para instalar a aplicação no [Visual Studio Code](https://code.visualstudio.com/).

```node
npm install
```

E importe o projeto na IDEA [Intellij](https://www.jetbrains.com/idea/).

```bash
File » New » Project from Existing Source...
```

Selecione o arquivo `pom.xml` e marque a opção

**☑ Import Maven projects automatically**

## Como usar

```bash
 » O que eu coloco aqui?
```

## Contribuições
Solicitações pull request são bem-vindas. Para grandes mudanças, abra um problema primeiro para discutir o que você gostaria de mudar. 

Por favor atualize os testes conforme apropriado.

## Autores e agradecimentos

```bash
» Agradecimento e nós
```

## Licença
[CWI Software](https://cwi.com.br/)

-- Link da API de correção

https://github.com/AntoniodaRosa/java_correcao_automatizada/blob/master/README.md


-- Configurando a API

o path do compilador JDK (javac) precisa ser adicionado às variáveis de ambiente do SO (adicionado à variavel "path")
uma vez instalado, o javac pode ser encontrado neste path: "C:/Program Files/Java/jdk1.8.0_231/bin/"

Ainda, alguns paths precisam ser configurados dentro do corpo da Service CorrecaoAutomatizadaService.java
pathServicesCorrecao = "src/main/java/com/api/api/service/";
pathJDK = "C:/Program Files/Java/jdk1.8.0_231/bin/";
pathMaquinaAteService = "C:/Users/Samuel Jansen/java_correcao_automatizada/src/main/java/com/api/api/service";



-- Descrição do funcionamento da API

Por enquanto, a api corrige questões em JAVA

A API recebe do banco uma lista de questaoDTO da questões da prova, onde cada uma das DTOs contém:
	- Lista de inputs
	- Lista de outputs
	- Solução do candidato

Essas três variáveis são strings; texto.
Exemplo:

String listaInputs = "Integer[] param1 = {1, 5, 6, 73, 3, 1, 123, 1};\n" +
                "        Integer[] param2 = {1234, 2, 4};\n" +
                "        Integer[] param3 = {12, 2, 4, 7};\n" +
                "        Integer[] param4 = {12, 2, 454, 7};\n" +
                "        Integer[] param5 = {12, 2, 4, 7, 6, 7, 8, 9, 0, 11000000};\n" +
                "\n" +
                "        List<Integer[]> listaInputs = new ArrayList<>();\n" +
                "        listaInputs.add(param1);\n" +
                "        listaInputs.add(param2);\n" +
                "        listaInputs.add(param3);\n" +
                "        listaInputs.add(param4);\n" +
                "        listaInputs.add(param5);";

String listaOutputs = "List<Integer> listaOutputs = new ArrayList<>();\n" +
                "        listaOutputs.add(123);\n" +
                "        listaOutputs.add(1234);\n" +
                "        listaOutputs.add(12);\n" +
                "        listaOutputs.add(454);\n" +
                "        listaOutputs.add(11000000);";

String solucao = "Integer saida = 0;\n" +
                "\n" +
                "        for(int i = 0; i < entrada.length; i++) {\n" +
                "\n" +
                "            if(saida < entrada[i]){\n" +
                "\n" +
                "                saida = entrada[i]; \n" +
                "            \n" +
                "            }\n" +
                "        }\n";

CorrigirQuestoesCrescerService.java é um método void que recebe por parâmetro a lista de questaoDTO do banco
	- Esta Service itera sobre essa lista chamando CorrecaoAutomatizadaService.java passando por parâmetro uma única questaoDTO para cada chamada.

CorrecaoAutomatizadaService.java efetua a correção automática de uma questão.
	- Esta Service é void e recebe por parâmetro uma questaoDTO.
	- Depois, esta Service chama um processo chamado "PythonEscreveSolucao.py" passando parâmetros via String[] args.
		Este processo é responsável pelo seu próprio ciclo de vida, portando o Java não precisa monitorálo.
	- Por fim, CorrecaoAutomatizadaService.java chama RegistrarNotaQuestaoService.java

PythonEscreveSolucao.py é reponsável por testar a solução do candidato. Isto é feito em 6 etapas:
	- Escrita
	- Compilação
	- Execução
	- Persistência
	- Limpeza
	- Preparacao

	+++ Escrita:
		Nesta etapa, o PythonEscreveSolucao.py identifica parâmetros como tipo da input da solução, tipo da output da solução, linguagem da solução, etc
		Com esses dados, o PythonEscreveSolucao.py toma as decisões necessárias e gera o texto que compõe a escrita da classe Solucao.java.
		E escreve essa classe num arquivo .java
	+++ Compilação
		Nesta ecapa, o PythonEscreveSolucao.py chama e gerencia/monitora um processo que compila a classe Solucao.java, rescém escrita.
		Ao final da compilação, um arquivo Solucao.class é gerado
	+++ Execussão
		A etapa de execussão ocorre através de uma chamada externa feita pelo processo "ChamadaExternaDaExecussaoDaSolucaoJava.py"
		ChamadaExternaDaExecussaoDaSolucaoJava.py chama a execussão da classe Solução.java, já compilada neste momento
		A API de correção ainda não controla essa chamada externa; tão pouco a monitora
	+++ Persistência
		Esta etapa é feita em pela Solução.java, quando chamada pela etapa Execussão do processo PythonEscreveSolucao.py
		Ao final desta etapa, a nota da correção da questaoDTO é gerada pela execução da classe Solucao.java e persistida no arquivo "nota.txt"
	+++ Limpeza
		Quando a etapa Persistência encerra, o PythonEscreveSolucao.py efetua a deleção dos arquivos criados durante essas etapas.
	+++ Preparacao
		Terminada a etapa Limpeza, o PythonEscreveSolucao.py prepara o arquivo "nota.txt" para a próxima correção de questão


RegistrarNotaQuestaoService.java captura e armazena em "questao" a nota da questão
	-Enquanto o processo PythonEscreveSolucao.py nao finaliza, a api de correção está presa na leitura do arquivo "nota.txt".
 	-Quando a etapa Persistência do processo PythonEscreveSolucao.py encerra,
		RegistrarNotaQuestaoService.java captura e armazena em "questao" a nota da questão

Pronto :D

- feedbacks e dúvidas da última reunião
		feedback de finalização de um bloco de provas
		criação de provas por bloco
		substituir questões antes de criar a prova
		resumo textual do desempenho de um candidato na prova
		estilizar o texto do link da prova
		negociação condições da execução das da prova
		integração com rh vagas

