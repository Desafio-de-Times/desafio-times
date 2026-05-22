import java.util.UUID;
import java.math.BigDecimal;
public class Jogo
{
    private UUID id;
    private String nome;
    private String desenvolvedora;
    private BigDecimal preco;

    public Jogo(String nome){
        this.id = UUID.randomUUID();
        this.nome = nome;
        this.desenvolvedora = desenvolvedora;
        this.preco = preco;
    }

    public UUID getId(){
        return id;
    }

    public String getNome(){
        return nome;
    }

    public String getDesenvolvedora(){
        return desenvolvedora;
    }

    public BigDecimal getPreco(){
        return preco;
    }

    public void setNome(String nome){
        this.nome = nome;
    }

    public void setDesenvolvedora(String desenvolvedora){
        this.desenvolvedora = desenvolvedora;
    }

    public void setPreco(BigDecimal preco){
        this.preco = preco;
    }

    public String toString(){
        return "\f ID: " + id +
                "\n Nome: " + nome +
                "\n Desenvolvedora: " + desenvolvedora +
                "\n Preço: " + preco;
    }
}
