/**
 * Escreva uma descrição da classe Bibloteca aqui.
 *
 * @author (seu nome)
 * @version (um número da versão ou uma data)
 */
public class Biblioteca
{
    private String nomeBiblioteca;
    private Jogo jogo1;
    private Jogo jogo2;
    private Jogo jogo3;
    public Usuario usuario1;
    public Usuario usuario2;
    public Usuario usuario3;

    public Biblioteca(String nomeBibiloteca){
        this.nomeBiblioteca = nomeBiblioteca;
        this.jogo1 = null;
        this.jogo2 = null;
        this.jogo3 = null;
    }

    /*public static String getNomeBiblioteca(){
        return nomeBiblioteca;
    }*/
    public String toString(){
        return "\f Nome da biblioteca: " + nomeBiblioteca +
                "\n Jogo 1: " + jogo1 +
                "\n Jogo 3: " + jogo2 +
                "\n Jogo 2: " + jogo3;
    }

    public String setNomeBiblioteca(String nomeBiblioteca){
        return nomeBiblioteca;
    }

    public void cadastrarJogo(Jogo jogo){
        if(jogo1 == null){
            jogo1 = jogo;
        }else if(jogo2 == null){
            jogo2 = jogo;
        }else if(jogo3 == null){
            jogo3 = jogo;
        }else{
            System.out.println("Biblioteca cheia.");
        }
    }

    public Jogo getJogo1(){
        return jogo1;
    }

    public Jogo getJogo2(){
        return jogo2;
    }

    public Jogo getJogo3(){
        return jogo3;
    }

    public void setJogo1(Jogo nome){
        this.jogo1 = nome;
    }

    public void setJogo2(Jogo nome){
        this.jogo2 = nome;
    }
    public void setJogo3(Jogo nome){
        this.jogo3 = nome;
    }
}
