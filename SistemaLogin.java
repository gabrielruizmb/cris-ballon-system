package global;

import java.util.ArrayList;
import java.util.Scanner;

public class SistemaLogin {
    private static Scanner scanner = new Scanner(System.in);

    public static void cadastrarUsuario(ArrayList<SistemaLogin.Usuario> usuarios) {
        System.out.println("\n--- CADASTRO DE USUÁRIO ---");

        System.out.print("Nome: ");
        String nome = scanner.nextLine();

        String usuarioInput;
        while (true) {
            System.out.print("Usuário (deve ser único): ");
            usuarioInput = scanner.nextLine();

            final String usuarioFinal = usuarioInput;
            boolean usuarioExistente = usuarios.stream().anyMatch(u -> u.usuario.equals(usuarioFinal));

            if (usuarioExistente) {
                System.out.println("Nome de usuário já existe. Tente outro.");
            } else {
                break;
            }
        }

        System.out.print("Data de Nascimento (dd/mm/yyyy): ");
        String dataNascimento = scanner.nextLine();

        String cpf;
        do {
            System.out.print("CPF (11 dígitos): ");
            cpf = scanner.nextLine();
            if (cpf.length() != 11) {
                System.out.println("O CPF deve ter exatamente 11 dígitos. Tente novamente.");
            }
        } while (cpf.length() != 11);

        System.out.println("Sexo: ");
        System.out.println("1 - Masculino");
        System.out.println("2 - Feminino");
        System.out.println("3 - Outro");
        System.out.print("Escolha: ");
        int opcaoSexo = scanner.nextInt();
        scanner.nextLine();

        String sexo = switch (opcaoSexo) {
            case 1 -> "Masculino";
            case 2 -> "Feminino";
            case 3 -> {
                System.out.print("Digite seu sexo: ");
                yield scanner.nextLine();
            }
            default -> "Outro";
        };

        System.out.print("Endereço: ");
        String endereco = scanner.nextLine();

        String senha, confirmarSenha;
        do {
            System.out.print("Senha: ");
            senha = scanner.nextLine();

            System.out.print("Confirme a senha: ");
            confirmarSenha = scanner.nextLine();

            if (!senha.equals(confirmarSenha)) {
                System.out.println("As senhas não coincidem. Tente novamente.");
            }
        } while (!senha.equals(confirmarSenha));

        SistemaLogin.Usuario novoUsuario = new SistemaLogin.Usuario(nome, usuarioInput, dataNascimento, cpf, sexo, endereco, senha);
        usuarios.add(novoUsuario);
        System.out.println("Usuário cadastrado com sucesso!");
    }

    public static void editarUsuario(SistemaLogin.Usuario usuarioLogado, ArrayList<SistemaLogin.Usuario> usuarios) {
        if (usuarioLogado == null) {
            System.out.println("Nenhum usuário logado.");
            return;
        }

        while (true) {
            System.out.println("\n--- EDITAR INFORMAÇÕES ---");
            System.out.println("1. Alterar nome");
            System.out.println("2. Alterar usuário");
            System.out.println("3. Alterar data de nascimento");
            System.out.println("4. Alterar CPF");
            System.out.println("5. Alterar sexo");
            System.out.println("6. Alterar endereço");
            System.out.println("7. Alterar senha");
            System.out.println("8. Voltar");
            System.out.print("Escolha uma opção: ");
            int escolha = scanner.nextInt();
            scanner.nextLine();

            switch (escolha) {
                case 1:
                    System.out.print("Novo nome: ");
                    usuarioLogado.nome = scanner.nextLine();
                    break;
                case 2:
                    String novoUsuario;
                    while (true) {
                        System.out.print("Novo usuário (deve ser único): ");
                        novoUsuario = scanner.nextLine();
                        final String usuarioFinal = novoUsuario;
                        boolean usuarioExistente = usuarios.stream().anyMatch(u -> u.usuario.equals(usuarioFinal));

                        if (usuarioExistente) {
                            System.out.println("Nome de usuário já existe. Tente outro.");
                        } else {
                            break;
                        }
                    }
                    usuarioLogado.usuario = novoUsuario;
                    break;
                case 3:
                    System.out.print("Nova data de nascimento (dd/mm/yyyy): ");
                    usuarioLogado.dataNascimento = scanner.nextLine();
                    break;
                case 4:
                    String novoCpf;
                    do {
                        System.out.print("Novo CPF (11 dígitos): ");
                        novoCpf = scanner.nextLine();
                        if (novoCpf.length() != 11) {
                            System.out.println("O CPF deve ter exatamente 11 dígitos. Tente novamente.");
                        }
                    } while (novoCpf.length() != 11);
                    usuarioLogado.cpf = novoCpf;
                    break;
                case 5:
                    System.out.println("Sexo: ");
                    System.out.println("1 - Masculino");
                    System.out.println("2 - Feminino");
                    System.out.println("3 - Outro");
                    System.out.print("Escolha: ");
                    int opcaoSexo = scanner.nextInt();
                    scanner.nextLine();
                    if (opcaoSexo == 3) {
                        System.out.print("Digite seu sexo: ");
                        usuarioLogado.sexo = scanner.nextLine();
                    } else {
                        usuarioLogado.sexo = (opcaoSexo == 1) ? "Masculino" : "Feminino";
                    }
                    break;
                case 6:
                    System.out.print("Novo endereço: ");
                    usuarioLogado.endereco = scanner.nextLine();
                    break;
                case 7:
                    String novaSenha, confirmarNovaSenha;
                    do {
                        System.out.print("Nova senha: ");
                        novaSenha = scanner.nextLine();
                        System.out.print("Confirme a nova senha: ");
                        confirmarNovaSenha = scanner.nextLine();
                        if (!novaSenha.equals(confirmarNovaSenha)) {
                            System.out.println("As senhas não coincidem. Tente novamente.");
                        }
                    } while (!novaSenha.equals(confirmarNovaSenha));
                    usuarioLogado.senha = novaSenha;
                    break;
                case 8:
                    System.out.println("Voltando ao menu anterior...");
                    return;
                default:
                    System.out.println("Opção inválida.");
            }
            System.out.println("Informações atualizadas com sucesso!");
        }
    }
}
