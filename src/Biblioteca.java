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
    private Usuario usuario1;
    private Usuario usuario2;
    private Usuario usuario3;

    public Biblioteca(String nomeBibiloteca){
        this.nomeBiblioteca = nomeBiblioteca;
        this.jogo1 = null;
        this.jogo2 = null;
        this.jogo3 = null;
    }

    public String getNomeBiblioteca(){
        return nomeBiblioteca;
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
}
