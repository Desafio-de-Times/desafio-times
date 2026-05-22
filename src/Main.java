import java.util.Objects;
import java.util.Scanner;

public class Main{
    public static void main(String args[]){
        Scanner in = new Scanner(System.in);

        //variaveis
        int opcao = 0;

        Jogo jogo1 = null;
        Jogo jogo2 = null;
        Jogo jogo3 = null;

        Usuario usuario1 = null;
        Usuario usuario2 = null;
        Usuario usuario3 = null;

        Biblioteca biblioteca1 = null;
        Biblioteca biblioteca2 = null;
        Biblioteca biblioteca3 = null;



        String usuarioString = null;

        int opcaoMenu1;
        int opcaoMenu2;
        //programa
            while(opcao != 6) {
                System.out.println("Bem-vindo ao Backlog de Jogos");
                System.out.println("1) Criar novo usuário");
                System.out.println("2) Entrar");
                System.out.println("3) Adicionar novo jogo ao backlog");
                System.out.println("3) Atualizar jogo");
                System.out.println("4) Remover jogo");
                System.out.println("5) Editar jogo");
                System.out.println("6) Review");
                opcao = in.nextInt();
                in.nextLine();
                switch (opcao) {
                    case 1:
                        System.out.println("Escolha um local da memória:");
                        System.out.println("1) " + usuario1);
                        System.out.println("2) " + usuario2);
                        System.out.println("3) " + usuario3);
                        opcaoMenu1 = in.nextInt();
                        in.nextLine();
                        if (opcaoMenu1 == 1 && usuario1 == null) {
                            System.out.println("Digite o nome do usuário:");
                            usuarioString = in.nextLine();
                            usuario1 = new Usuario(usuarioString);
                            System.out.println("Digite o nome do usuário:");
                            String bibliotecaUsuario1 = in.nextLine();
                            biblioteca1 = new Biblioteca(bibliotecaUsuario1);
                        } else if (opcaoMenu1 == 2 && usuario2 == null) {
                            System.out.println("Digite o nome do usuário:");
                            usuarioString = in.nextLine();
                            usuario2 = new Usuario(usuarioString);
                            String bibliotecaUsuario2 = in.nextLine();
                            biblioteca2 = new Biblioteca(bibliotecaUsuario2);
                        } else if (opcaoMenu1 == 3 && usuario3 == null) {
                            System.out.println("Digite o nome do usuário:");
                            usuarioString = in.nextLine();
                            usuario3 = new Usuario(usuarioString);
                            String bibliotecaUsuario3 = in.nextLine();
                            biblioteca3 = new Biblioteca(bibliotecaUsuario3);
                        } else {
                            System.out.println("Deu!");
                        }
                        break;
                    case 2:
                        System.out.println("Digite seu nome de usuário para adicionar um jogo:");
                        String nomeUsuario = in.nextLine();
                        if (Objects.equals(nomeUsuario, usuarioString)) {
                            System.out.println("Escolha um local da memória:");
                            System.out.println("1) " + jogo1);
                            System.out.println("2) " + jogo2);
                            System.out.println("3) " + jogo3);
                            int opcaoJogo = in.nextInt();
                            in.nextLine();
                            if (opcaoJogo == 1) {
                                System.out.println("Digite o nome do jogo:");
                                String nomeJogo1 = in.nextLine();
                                jogo1 = new Jogo(nomeJogo1);
                            }
                        } else {
                            System.out.println("Usuário não criado!");
                        }
                        break;

                }
            }
            }
        }


