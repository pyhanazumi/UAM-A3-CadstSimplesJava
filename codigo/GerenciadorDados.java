import java.io.*;
import java.util.Scanner;

public class GerenciadorDados {
    private Scanner scanner;

    public GerenciadorDados() {
        this.scanner = new Scanner(System.in);
    }

    public void cadastrarUsuario() {
        System.out.println("\n--- Cadastro de Usuário ---");
        System.out.print("Digite o código identificador: ");
        String codigoIdentificador = scanner.nextLine();
        System.out.print("Digite o nome: ");
        String nome = scanner.nextLine();
        System.out.print("Digite o CPF: ");
        String cpf = scanner.nextLine();
        System.out.print("Digite o endereço de e-mail: ");
        String email = scanner.nextLine();
        System.out.print("Digite o cargo: ");
        String cargo = scanner.nextLine();
        System.out.print("Digite o login: ");
        String login = scanner.nextLine();
        System.out.print("Digite a senha: ");
        String senha = scanner.nextLine();
        System.out.print("Digite o perfil (colaborador, administrador, gerente): ");
        String perfil = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("usuario.txt", true))) {
            writer.write(codigoIdentificador + "," + nome + "," + cpf + "," + email + "," + cargo + "," + login + "," + senha + "," + perfil);
            writer.newLine();
            System.out.println("Usuário cadastrado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o usuário: " + e.getMessage());
        }
    }

    public void cadastrarProjeto() {
        System.out.println("\n--- Cadastro de Projeto ---");
        System.out.print("Digite o código do projeto: ");
        String codigoProjeto = scanner.nextLine();
        System.out.print("Digite o nome do projeto: ");
        String nomeProjeto = scanner.nextLine();
        System.out.print("Digite a descrição resumida: ");
        String descricao = scanner.nextLine();
        System.out.print("Digite a data de início (dd/mm/aaaa): ");
        String dataInicio = scanner.nextLine();
        System.out.print("Digite a data de término (dd/mm/aaaa): ");
        String dataTermino = scanner.nextLine();
        System.out.print("Digite o status (planejado, em andamento, concluído, cancelado): ");
        String status = scanner.nextLine();
        System.out.print("Digite o código do gerente: ");
        String codigoGerente = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("projeto.txt", true))) {
            writer.write(codigoProjeto + "," + nomeProjeto + "," + descricao + "," + dataInicio + "," + dataTermino + "," + status + "," + codigoGerente);
            writer.newLine();
            System.out.println("Projeto cadastrado com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o projeto: " + e.getMessage());
        }
    }

    public void cadastrarEquipe() {
        System.out.println("\n--- Cadastro de Equipe ---");
        System.out.print("Digite o código da equipe: ");
        String codigoEquipe = scanner.nextLine();
        System.out.print("Digite o nome da equipe: ");
        String nomeEquipe = scanner.nextLine();
        System.out.print("Digite a descrição da equipe: ");
        String descricao = scanner.nextLine();

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("equipe.txt", true))) {
            writer.write(codigoEquipe + "," + nomeEquipe + "," + descricao);
            writer.newLine();
            System.out.println("Equipe cadastrada com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar a equipe: " + e.getMessage());
        }
    }

    public void cadastrarMembroEquipe() {
        System.out.println("\n--- Cadastro de Membro de Equipe ---");
        System.out.print("Digite o código da equipe: ");
        String codigoEquipe = scanner.nextLine();

        if (!verificarExistencia("equipe.txt", codigoEquipe)) {
            System.out.println("Erro: Código da equipe não encontrado!");
            return;
        }

        System.out.print("Digite o código do usuário: ");
        String codigoUsuario = scanner.nextLine();

        if (!verificarExistencia("usuario.txt", codigoUsuario)) {
            System.out.println("Erro: Código do usuário não encontrado!");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("equipe_membro.txt", true))) {
            writer.write(codigoEquipe + "," + codigoUsuario);
            writer.newLine();
            System.out.println("Membro cadastrado na equipe com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao salvar o membro da equipe: " + e.getMessage());
        }
    }
    
    public void associarEquipeProjeto() {
        System.out.println("\n--- Associar Equipe a Projeto ---");
        System.out.print("Digite o código da equipe: ");
        String codigoEquipe = scanner.nextLine();

        if (!verificarExistencia("equipe.txt", codigoEquipe)) {
            System.out.println("Erro: Código da equipe não encontrado!");
            return;
        }

        System.out.print("Digite o código do projeto: ");
        String codigoProjeto = scanner.nextLine();

        if (!verificarExistencia("projeto.txt", codigoProjeto)) {
            System.out.println("Erro: Código do projeto não encontrado!");
            return;
        }

        if (verificarAssociacaoExistente("equipe_projeto.txt", codigoEquipe, codigoProjeto)) {
            System.out.println("Erro: Esta equipe já está associada a este projeto.");
            return;
        }

        try (BufferedWriter writer = new BufferedWriter(new FileWriter("equipe_projeto.txt", true))) {
            writer.write(codigoEquipe + "," + codigoProjeto);
            writer.newLine();
            System.out.println("Equipe associada ao projeto com sucesso!");
        } catch (IOException e) {
            System.err.println("Erro ao associar equipe e projeto: " + e.getMessage());
        }
    }

    private boolean verificarExistencia(String nomeArquivo, String codigo) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length > 0 && partes[0].trim().equals(codigo)) {
                    return true;
                }
            }
        } catch (IOException e) {
            // Arquivo não existe ou erro de leitura, assumimos que o código não existe.
            return false;
        }
        return false;
    }
    
    private boolean verificarAssociacaoExistente(String nomeArquivo, String codigoEquipe, String codigoProjeto) {
        try (BufferedReader reader = new BufferedReader(new FileReader(nomeArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                String[] partes = linha.split(",");
                if (partes.length >= 2 && partes[0].trim().equals(codigoEquipe) && partes[1].trim().equals(codigoProjeto)) {
                    return true;
                }
            }
        } catch (IOException e) {
            // Arquivo não existe ou erro, assume-se que a associação não existe
            return false;
        }
        return false;
    }
}