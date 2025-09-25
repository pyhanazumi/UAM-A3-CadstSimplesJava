import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        GerenciadorDados gerenciador = new GerenciadorDados(); //usa a classe gerenciadordados para abrir o menu
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;

        do {
            exibirMenu();
            System.out.print("Digite a opção desejada: ");
            try {
                opcao = Integer.parseInt(scanner.nextLine());
                
                switch (opcao) {
                    case 1:
                        gerenciador.cadastrarUsuario();
                        break;
                    case 2:
                        gerenciador.cadastrarProjeto();
                        break;
                    case 3:
                        gerenciador.cadastrarEquipe();
                        break;
                    case 4:
                        gerenciador.cadastrarMembroEquipe();
                        break;
                    case 5:
                        gerenciador.associarEquipeProjeto();
                        break;
                    case 0:
                        System.out.println("Saindo do programa. Até mais!");
                        break;
                    default:
                        System.out.println("Opção inválida. Por favor, tente novamente.");
                }
            } catch (NumberFormatException e) {
                System.out.println("Entrada inválida. Por favor, digite um número.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    public static void exibirMenu() {
        System.out.println("\n--- Sistema de Gerenciamento ---");
        System.out.println("1. Cadastrar Usuário");
        System.out.println("2. Cadastrar Projeto");
        System.out.println("3. Cadastrar Equipe");
        System.out.println("4. Cadastrar Membro de Equipe");
        System.out.println("5. Associar Equipe a Projeto");
        System.out.println("0. Sair");
        System.out.println("----------------------------------");
    }
}