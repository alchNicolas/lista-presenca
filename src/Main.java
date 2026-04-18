import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int opcao = 0;
        ArrayList<String> participantes = new ArrayList<>();
        ArrayList<String> presentes = new ArrayList<>();

        System.out.println("Sistema de Lista de Presença (Check-in de Evento)");

        String menu = """
                \nSelecione uma opção:
                
                1- Adicionar participantes
                2- Consultar lista
                3- Fazer check-in
                4- Remover participante
                5- Pesquisar participante
                6- Encerrar
                """;

        while (opcao != 6) {
            System.out.println(menu);
            if (!scanner.hasNextInt()) {
                System.out.println("Digite um número válido!");
                scanner.nextLine();
                continue;
            }

            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    scanner.nextLine();
                    System.out.println("Digite o nome do participante:");
                    String nome = scanner.nextLine().trim().toLowerCase();

                    if (nome == null || nome.trim().isEmpty()) {
                        System.out.println("Nome inválido, não foi adicionado");

                    } else if (participantes.contains(nome.trim())) {
                        System.out.println("Esse participante já existe!");

                    } else {
                        participantes.add(nome.trim());
                        System.out.println("Participante adicionado com sucesso.");
                    }
                    break;

                case 2:
                    System.out.println("Lista de Participantes:");
                    for (String participante : participantes) {
                        System.out.println("- " + participante);
                    }
                    System.out.println("Total de participantes: " + participantes.size());

                    System.out.println("\nLista de presentes:");
                    for (String presente : presentes) {
                        System.out.println("- " + presente);
                    }
                    System.out.println("Total de presentes: " + presentes.size());
                    break;

                case 3:
                    scanner.nextLine();
                    System.out.println("Qual nome na lista para fazer check-in?");
                    for (String participante : participantes) {
                        System.out.println("- " + participante);
                    }
                    String nomeCheck = scanner.nextLine().trim().toLowerCase();

                    if (!participantes.contains(nomeCheck)) {
                        System.out.println("Participante não encontrado. Check in não realizado");
                    } else if (presentes.contains(nomeCheck)) {
                        System.out.println("O participante " + nomeCheck + " já fez check-in");
                    } else {
                        presentes.add(nomeCheck);
                        System.out.println("Check-in realizado com sucesso!");
                    }
                    break;

                case 4:
                    scanner.nextLine();
                    System.out.println("Qual nome deseja remover:");
                    String nomeRemove = scanner.nextLine().trim().toLowerCase();

                    if (participantes.contains(nomeRemove)) {
                        System.out.println("Participante removido");
                        participantes.remove(nomeRemove);
                        presentes.remove(nomeRemove);
                    } else {
                        System.out.println("Nome não encontrado. Tente novamente");
                    }
                    break;

                case 5:
                    scanner.nextLine();
                    System.out.println("Digite o nome para pesquisa: ");
                    String nomePesquisa = scanner.nextLine().trim().toLowerCase();

                    if (participantes.contains(nomePesquisa)) {
                        System.out.println("Nome encontrado: " + nomePesquisa);
                    } else {
                        System.out.println("Não está na lista.");
                    }
                    break;

                case 6:
                    System.out.println("Encerrando programa");
                    break;

                default:
                    System.out.println("Opção inválida. Tente novamente");
            }
        }
    }
}