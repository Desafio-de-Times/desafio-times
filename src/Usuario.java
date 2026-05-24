public class Usuario
{
    // variáveis de instância - substitua o exemplo abaixo pelo seu próprio
    private String nome;
    private String historico;
    private String jogofav;


    public Usuario(String nome)
    {
        // inicializa variáveis de instância
        this.nome = nome;
        this.jogofav = jogofav;
        this.historico = historico;
    }
    public String jogofav(String jogo){
        jogofav = jogo;
        return jogofav;
    }
    public String historico(String jogo){
        historico = jogo;
        return historico;
    }

    //get
    public String getNome(){
        return nome;
    }
    public String getJogofav(){
        return jogofav;
    }
    public String getHistorico(String jogo){
        return historico;
    }

    //set
    public void setJogofav(String jogofav){
        this.jogofav = jogofav;
    }
    public void setNome(String nome){
        this.nome = nome;
    }
    public void setHistorico(String jogo){
        this.historico = historico;
    }

    public String toString(){
        return "Usuário: " +nome+
                "Jogo favorito: " +jogofav+
                "Histórico de jogos: "+historico;

    }


  /*  public Jogo getJogo1() {
        return jogo1;
    }

    public void setJogo1(String jogo1) {
        this.jogo1 = jogo1;
    }
    */
}
