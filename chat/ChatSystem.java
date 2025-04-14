package chat;

import java.lang.reflect.Array;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;

public class ChatSystem{
    private HashMap<Integer, Usuario> usuarios = new HashMap<>();
    private ArrayList<Conversa> conversas = new ArrayList<>();
    private HashMap<Conversa, Integer> idsMensagemPorConversa = new HashMap<>();

    private int id;
    private String nome;
    private String email;
    private String senha;
    private Usuario usuarioLogado;

    public ChatSystem(int id, String nome, String email, String senha){
        this.usuarios = new HashMap<>();
        this.conversas = new ArrayList<>();
        this.id = id;
        this.nome = nome;
        this.email = email;
        this.senha = senha;
    }

    public boolean cadastraUsuario(int id, String nome, String email, String senha) {

        if (senha.length() < 6) {
            System.out.println("Erro: a senha deve conter pelo menos 6 caracteres. ");
            return false;
        }

        if (usuarios.containsKey(id)) {
            System.out.println("Erro: esse id já existe. ");
            return false;
        } else {
            Usuario u = new Usuario(id, nome, email, senha);
            usuarios.put(id, u);
            System.out.println("Usuário cadastrado com sucesso. ");
            return true;
        }
    }

        public void excluiUsuario(int id){
            if(usuarios.containsKey(id)){
                Usuario usuarioRemovido = usuarios.get(id); // Pega antes de remover
                usuarios.remove(id);
                System.out.println("O usuário " + usuarioRemovido.getNome() + " do ID:" + id + " foi excluído com sucesso. ");
            }else{
                System.out.println("Erro: id de usuário não encontrado. ");
            }

        }

        public void criaConversa(ArrayList<Integer> idsParticipantes){
            if (idsParticipantes == null || idsParticipantes.size() < 2) {
                System.out.println("Erro: é necessário pelo menos dois participantes para criar uma conversa.");
                return;
            }
            ArrayList<Usuario> participantes = new ArrayList<>();

            //verifica se o usuário com id existe
            for(int id: idsParticipantes){
                Usuario u = usuarios.get(id);
                if(u != null) {
                    participantes.add(u); //se existir, pega o usuário e adiciona a lista de participantes
                }else{
                    System.out.println("Erro: usuário com esse ID: " + id + " Não encontrado");
                }
            }

            Conversa novaConversa = new Conversa(participantes);
            conversas.add(novaConversa);
            System.out.println("A conversa foi criada com sucesso. ");
        }

        public void enviaMensagem(int idConversa, int idAutor, String conteudo){

            if (usuarioLogado == null || usuarioLogado.getId() != idAutor) {
                System.out.println("Erro: você precisa estar logado para enviar mensagens.");
                return;
            }

            if(idConversa < 0 || idConversa >= conversas.size()){
                System.out.println("Erro: conversa não encontrada");
                return;
            }

            if(!usuarios.containsKey(idAutor)){
                System.out.println("Erro: autor da mensagem não encontrado. ");
                return;
            }

            Conversa conversa = conversas.get(idConversa);
            Usuario autor = usuarios.get(idAutor);

            if(!conversa.getParticipantes().contains(autor)){
                System.out.println("Erro: usuário não participa dessa conversa. ");
                return;
            }
            // faz com que cada mensagem tem um ID único
            int idMensagem = idsMensagemPorConversa.getOrDefault(conversa, 0);
            Mensagem nova = new Mensagem(idMensagem, conteudo, autor);// ID incrementado
            conversa.getMensagens().add(nova);

            //Atualiza o ID pra próxima mensagem
            idsMensagemPorConversa.put(conversa, idMensagem + 1);

            System.out.println("Mensagem enviada com sucesso");

        }

        public void excluiMensagem(int idConversa, int idMensagem, int idSolicitante){
            if(idConversa < 0 || idConversa >= conversas.size()){
                System.out.println("Erro: conversa não encontrada. ");
                return;
            }

            if(!usuarios.containsKey(idSolicitante)){
                System.out.println("Erro: usuário não encontrado");
                return;
            }
            Conversa conversa = conversas.get(idConversa);
            Usuario solicinte = usuarios.get(idSolicitante);
            //Busca pela mensagem na conversa
            for(Mensagem m: conversa.getMensagens()){
                if(m.getId() == idMensagem){
                    //Verifica se o solicitatante é o autor da mensagem
                    if(m.getAutor().getId() !=(idSolicitante)){
                        System.out.println(solicinte.getNome() + " tentou excluir a mensagem de: " +m.getAutor().getNome());
                        System.out.println("Erro: você não pode excluir a mensagem de outro usuário. ");
                        return;
                    }
                    // Se for o autor, o conteúdo da mensagem é trocado
                    m.setConteudo("Mensagem excluída. ");
                    System.out.println( solicinte.getNome() + " Excluiu a própria mensagem. ");
                    return;
                }
            }
            //Se a mensagem não for encontrada
            System.out.println("Erro: mensagem não encotrada. ");
        }

        public void ExibirConversas(){
            if(conversas.isEmpty()){
                System.out.println("Sem registro de conversas. ");
            }else{
                // Formata a data: exemplo "12/04/2025 15:41"
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy HH:mm");

                for (int i = 0; i < conversas.size(); i++) {
                    Conversa conversa = conversas.get(i);
                    ArrayList<Mensagem> mensagens = conversa.getMensagens();

                    System.out.println("\n--- Conversa " + i + " ---");

                    for (Mensagem m : mensagens) {
                        String hora = sdf.format(m.getHoraEnvio());
                        String nomeAutor = m.getAutor().getNome();
                        String conteudo = m.getConteudo();

                        System.out.println(nomeAutor + " enviou: " + conteudo + " às " + "[" + hora + "] " );
                    }
                }

            }

    }

        public void login(String nome, String senha) {
            for (Usuario u : usuarios.values()) {
                if (u.getNome().equals(nome) && u.getSenha().equals(senha)) {
                usuarioLogado = u;
                System.out.println("Login realizado com sucesso. Bem-vindo, " + nome + "!");
                return;
            }
        }
        System.out.println("Erro: nome ou senha incorretos.");
    }

        public void logout(int id) {
            if (usuarioLogado != null && usuarioLogado.getId() == id) {
                System.out.println("Usuário " + usuarioLogado.getNome() + " deslogou.");
                usuarioLogado = null;
            } else {
                System.out.println("Nenhum usuário está logado.");
            }
        }



}

