import java.util.Scanner;

public class Main {
    private static Usuario usuario1 = null;
    private static Usuario usuario2 = null;
    private static Usuario usuario3 = null;

    private static Biblioteca biblioteca1 = null;
    private static Biblioteca biblioteca2 = null;
    private static Biblioteca biblioteca3 = null;

    public static void main(String args[]) {
        Scanner in = new Scanner(System.in);
        int opcao = 0;

        while (opcao != 6) {
            mostrarMenu();
            opcao = lerInteiro(in);
            executarOpcao(in, opcao);
        }

        in.close();
    }

    private static void mostrarMenu() {
        System.out.println("Bem-vindo ao Backlog de Jogos");
        System.out.println("1) Criar novo usuario");
        System.out.println("2) Adicionar novo jogo ao backlog");
        System.out.println("3) Atualizar jogo");
        System.out.println("4) Remover jogo");
        System.out.println("5) Review");
        System.out.println("6) Sair");
        System.out.print("Escolha uma opcao: ");
    }

    private static void executarOpcao(Scanner in, int opcao) {
        if (opcao == 1) {
            criarNovoUsuario(in);
        } else if (opcao == 2) {
            adicionarNovoJogo(in);
        } else if (opcao == 3) {
            atualizarJogo(in);
        } else if (opcao == 4) {
            removerJogo(in);
        } else if (opcao == 5) {
            mostrarReview();
        } else if (opcao == 6) {
            System.out.println("Programa encerrado.");
        } else {
            System.out.println("Opcao invalida.");
        }
    }

    private static void criarNovoUsuario(Scanner in) {
        System.out.println("Selecione um espaco disponivel:");
        mostrarUsuario();

        int escolha = lerInteiro(in);

        if (escolha == 1) {
            if (usuario1 == null) {
                usuario1 = cadastrarUsuario(in);
                biblioteca1 = cadastrarBiblioteca(in);
            } else {
                System.out.println("Usuario ja cadastrado nesse espaco.");
            }
        } else if (escolha == 2) {
            if (usuario2 == null) {
                usuario2 = cadastrarUsuario(in);
                biblioteca2 = cadastrarBiblioteca(in);
            } else {
                System.out.println("Usuario ja cadastrado nesse espaco.");
            }
        } else if (escolha == 3) {
            if (usuario3 == null) {
                usuario3 = cadastrarUsuario(in);
                biblioteca3 = cadastrarBiblioteca(in);
            } else {
                System.out.println("Usuario ja cadastrado nesse espaco.");
            }
        } else {
            System.out.println("Espaco indisponivel.");
        }
    }

    private static Usuario cadastrarUsuario(Scanner in) {
        System.out.print("Qual seu nome? ");
        String nome = in.nextLine();

        return new Usuario(nome);
    }

    private static Biblioteca cadastrarBiblioteca(Scanner in) {
        System.out.print("Qual sera o nome da sua biblioteca? ");
        String nome = in.nextLine();

        return new Biblioteca(nome);
    }

    private static void adicionarNovoJogo(Scanner in) {
        System.out.println("Escolha o usuario:");
        mostrarUsuario();

        int escolha = lerInteiro(in);

        if (escolha == 1) {
            adicionarJogoNaBiblioteca(in, usuario1, biblioteca1);
        } else if (escolha == 2) {
            adicionarJogoNaBiblioteca(in, usuario2, biblioteca2);
        } else if (escolha == 3) {
            adicionarJogoNaBiblioteca(in, usuario3, biblioteca3);
        } else {
            System.out.println("Usuario invalido.");
        }
    }

    private static void adicionarJogoNaBiblioteca(Scanner in, Usuario usuario, Biblioteca biblioteca) {
        if (usuario == null) {
            System.out.println("Usuario nao cadastrado.");
            return;
        }

        Jogo jogo = criarJogo(in);
        biblioteca.cadastrarJogo(jogo);
    }

    private static void atualizarJogo(Scanner in) {
        System.out.println("Escolha o usuario:");
        mostrarUsuario();

        int escolha = lerInteiro(in);

        if (escolha == 1) {
            atualizarJogoDaBiblioteca(in, usuario1, biblioteca1);
        } else if (escolha == 2) {
            atualizarJogoDaBiblioteca(in, usuario2, biblioteca2);
        } else if (escolha == 3) {
            atualizarJogoDaBiblioteca(in, usuario3, biblioteca3);
        } else {
            System.out.println("Usuario invalido.");
        }
    }

    private static void atualizarJogoDaBiblioteca(Scanner in, Usuario usuario, Biblioteca biblioteca) {
        if (usuario == null) {
            System.out.println("Usuario nao cadastrado.");
            return;
        }

        mostrarJogos(biblioteca);
        System.out.print("Qual jogo deseja atualizar? ");
        int escolha = lerInteiro(in);

        if (escolha == 1) {
            Jogo jogoNovo = criarJogo(in);
            biblioteca.setJogo1(jogoNovo);
        } else if (escolha == 2) {
            Jogo jogoNovo = criarJogo(in);
            biblioteca.setJogo2(jogoNovo);
        } else if (escolha == 3) {
            Jogo jogoNovo = criarJogo(in);
            biblioteca.setJogo3(jogoNovo);
        } else {
            System.out.println("Jogo invalido.");
        }
    }

    private static void removerJogo(Scanner in) {
        System.out.println("Escolha o usuario:");
        mostrarUsuario();

        int escolha = lerInteiro(in);

        if (escolha == 1) {
            removerJogoDaBiblioteca(in, usuario1, biblioteca1);
        } else if (escolha == 2) {
            removerJogoDaBiblioteca(in, usuario2, biblioteca2);
        } else if (escolha == 3) {
            removerJogoDaBiblioteca(in, usuario3, biblioteca3);
        } else {
            System.out.println("Usuario invalido.");
        }
    }

    private static void removerJogoDaBiblioteca(Scanner in, Usuario usuario, Biblioteca biblioteca) {
        if (usuario == null) {
            System.out.println("Usuario nao cadastrado.");
            return;
        }

        mostrarJogos(biblioteca);
        System.out.print("Qual jogo deseja remover? ");
        int escolha = lerInteiro(in);

        if (escolha == 1) {
            biblioteca.setJogo1(null);
        } else if (escolha == 2) {
            biblioteca.setJogo2(null);
        } else if (escolha == 3) {
            biblioteca.setJogo3(null);
        } else {
            System.out.println("Jogo invalido.");
        }
    }

    private static Jogo criarJogo(Scanner in) {
        System.out.print("Qual o nome do jogo? ");
        String nome = in.nextLine();

        return new Jogo(nome);
    }

    private static void mostrarReview() {
        System.out.println("Usuarios e bibliotecas:");

        if (usuario1 != null) {
            System.out.println("Usuario 1: " + usuario1);
            mostrarJogos(biblioteca1);
        }

        if (usuario2 != null) {
            System.out.println("Usuario 2: " + usuario2);
            mostrarJogos(biblioteca2);
        }

        if (usuario3 != null) {
            System.out.println("Usuario 3: " + usuario3);
            mostrarJogos(biblioteca3);
        }

        if (usuario1 == null && usuario2 == null && usuario3 == null) {
            System.out.println("Nenhum usuario cadastrado.");
        }
    }

    public static void mostrarUsuario() {
        System.out.println("Usuarios cadastrados:");
        System.out.println("1) " + usuario1);
        System.out.println("2) " + usuario2);
        System.out.println("3) " + usuario3);
    }

    private static void mostrarJogos(Biblioteca biblioteca) {
        System.out.println("Jogos da biblioteca:");
        System.out.println("1) " + biblioteca.getJogo1());
        System.out.println("2) " + biblioteca.getJogo2());
        System.out.println("3) " + biblioteca.getJogo3());
    }

    private static int lerInteiro(Scanner in) {
        int numero = in.nextInt();
        in.nextLine();
        return numero;
    }
}
