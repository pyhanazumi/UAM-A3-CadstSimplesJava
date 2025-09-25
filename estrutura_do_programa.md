
**Estrutura do Programa Java para Cadastro**

Com base na sua descrição, criei uma estrutura básica em Java para atender às suas necessidades. O programa é um **sistema de gerenciamento simples para usuários, projetos e equipes**, que armazena os dados em arquivos de texto.

A solução está dividida em classes para melhor organização e reutilização de código.

**Classes de Entidades**

Criei classes para representar cada uma das entidades: Usuario, Projeto, Equipe e EquipeMembro. Elas contêm os atributos que você listou e métodos para manipulação dos dados.

-   Usuario.java:
    
    -   Atributos: codigoIdentificador, nome, cpf, email, cargo, login, senha, perfil.
        
-   Projeto.java:
    
    -   Atributos: codigoProjeto, nomeProjeto, descricao, dataInicio, dataTermino, status, codigoGerente.
        
-   Equipe.java:
    
    -   Atributos: codigoEquipe, nomeEquipe, descricao.
        
-   EquipeMembro.java:
    
    -   Atributos: codigoEquipe, codigoUsuario.
        

**Métodos de Cadastro**

Cada item que você descreveu se traduzirá em um método específico em uma classe chamada GerenciadorDados. Essa classe será responsável por toda a lógica de negócio, como a leitura dos dados do usuário, a validação das informações e a escrita nos arquivos de texto.

1.  **cadastrarUsuario()**:
    
    -   Solicita todos os dados do usuário.
        
    -   Salva no arquivo **usuario.txt**.
        
2.  **cadastrarProjeto()**:
    
    -   Solicita todos os dados do projeto.
        
    -   Salva no arquivo **projeto.txt**.
        
3.  **cadastrarEquipe()**:
    
    -   Solicita os dados da equipe.
        
    -   Salva no arquivo **equipe.txt**.
        
4.  **cadastrarMembroEquipe()**:
    
    -   Solicita o código da equipe e o código do usuário.
        
    -   **Validações**:
        
        -   Verifica se o código da equipe existe no arquivo equipe.txt.
            
        -   Verifica se o código do usuário existe no arquivo usuario.txt.
            
    -   Salva no arquivo **equipe_membro.txt**.
        
5.  **associarEquipeProjeto()**:
    
    -   Solicita o código da equipe e o código do projeto.
        
    -   **Validações**:
        
        -   Verifica se o código da equipe existe no arquivo equipe.txt.
            
        -   Verifica se o código do projeto existe no arquivo projeto.txt.
            
        -   Verifica se a associação (equipe-projeto) já não existe no arquivo equipe_projeto.txt.
            
    -   Salva no arquivo **equipe_projeto.txt**.
        

**Execução do Programa**

O programa principal (Main.java) irá conter um menu interativo que permitirá ao usuário escolher qual operação deseja realizar (cadastrar usuário, projeto, equipe, etc.). Ele chamará os métodos da classe GerenciadorDados conforme a escolha do usuário.

  
  

**1. Classe Usuario.java**

Esta classe é um modelo de dados (POJO - Plain Old Java Object) que representa um usuário. Ela contém os atributos que você mencionou e um construtor para facilitar a criação de novos objetos.

**2. Classe Projeto.java**

Esta classe representa um projeto, seguindo a mesma estrutura de Usuario.java.

**3. Classe Equipe.java**

Esta classe representa uma equipe, com seus atributos e métodos.

**4. Classe EquipeMembro.java**

Essa classe é a que irá ligar as equipes aos seus membros.

**5. Classe GerenciadorDados.java**

Esta classe centraliza as operações de cadastro e validação. Para a leitura dos dados, ela utiliza a classe Scanner. Para a gravação nos arquivos, usa as classes FileWriter e BufferedWriter para escrever linha por linha. Para as verificações de existência (como a validação de códigos), ela utiliza o FileReader para ler o conteúdo dos arquivos.

**Observações sobre o código**

-   **Tratamento de Exceções**: O código inclui blocos try-catch para lidar com possíveis erros de I/O (Input/Output), como a falha ao abrir ou escrever em um arquivo.
    
-   **Armazenamento de Dados**: Os dados em cada arquivo de texto são separados por vírgulas (formato CSV - Comma Separated Values).
    
-   **Validação**: Os métodos cadastrarMembroEquipe() e associarEquipeProjeto() utilizam métodos auxiliares (verificarExistencia e verificarAssociacaoExistente) para garantir que os códigos de entrada são válidos.
    

**6. Classe** **Main.java**

Esta classe contém o método main, que inicia a aplicação. Ela gerencia o fluxo de execução, exibindo as opções para o usuário e chamando os métodos correspondentes da classe GerenciadorDados.

**Como Executar o Programa**

Para compilar e executar o código, você precisará ter todos os arquivos (Usuario.java, Projeto.java, Equipe.java, EquipeMembro.java, GerenciadorDados.java e Main.java) na mesma pasta.

1.  **Compile os arquivos**: Abra o terminal ou prompt de comando na pasta onde estão os arquivos e use o seguinte comando:
    

javac *.java

2.  **Execute o programa**: Após a compilação, execute a classe principal:
    

java Main

O menu interativo será exibido e você poderá começar a utilizar as funcionalidades de cadastro. Os arquivos de texto (usuario.txt, projeto.txt, etc.) serão criados automaticamente na mesma pasta à medida que você for salvando os dados.
