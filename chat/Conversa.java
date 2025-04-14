package chat;

import java.util.ArrayList;

public class Conversa {
    private ArrayList<Usuario> participantes = new ArrayList<>();
    private ArrayList<Mensagem> mensagens = new ArrayList<>();

    public Conversa( ArrayList<Usuario> participantes){
        this.participantes = participantes;

    }

    public ArrayList<Usuario> getParticipantes() {
        return participantes;
    }

    public void setParticipantes(ArrayList<Usuario> participantes) {
        this.participantes = participantes;
    }

    public ArrayList<Mensagem> getMensagens() {
        return mensagens;
    }

    public void setMensagens(ArrayList<Mensagem> mensagens) {
        this.mensagens = mensagens;
    }

    public void adicionarParticipante(Usuario usuario) {
        if (!participantes.contains(usuario)) {
            participantes.add(usuario);
        }
    }


}
