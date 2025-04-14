package chat;

import java.util.Date;

public class Mensagem {
    private int id;
    private String conteudo;
    private Usuario autor;
    private Date horaEnvio;
    private static int contadorIds = 0;

    public Mensagem(int id, String conteudo, Usuario autor){
        this.id = id;
        this.conteudo = conteudo;
        this.autor = autor;
        this.horaEnvio = new Date();
        this.id = ++contadorIds;
    }

    public int getId(){
        return id;
    }
    public void setId(int id){
        this.id = id;
    }

    public String getConteudo(){
        return conteudo;
    }
    public void setConteudo(String conteudo){
        this.conteudo = conteudo;
    }
    public Usuario getAutor(){
        return autor;
    }
    public void setAutor(Usuario autor){
        this.autor = autor;
    }

    public Date getHoraEnvio(){
        return horaEnvio;
    }

}
