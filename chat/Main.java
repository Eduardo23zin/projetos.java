package chat;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ChatSystem chat = new ChatSystem(0000, "Carlos", "carlos11@gmail.com", "1111@");


        chat.cadastraUsuario(1, "João", "joão12@gmail.com", "7742@!");
        chat.cadastraUsuario(2, "Léo", "léozin21@gmail.com", "123491!");
        chat.cadastraUsuario(3, "José", "jose876@gmail.com", "8767@!$");
        chat.cadastraUsuario(4, "Luiza", "Luu22@gmail.com", "luz24"); //testando a verificação da senha que deve ter mais de 6 caracteres
        ArrayList<Integer> ids = new ArrayList<>();
        ids.add(1);
        ids.add(2);
        ids.add(3);


        chat.criaConversa(ids);
        chat.login("João", "7742@!"); // usuário deve fazer login se quiser mandar mensagens
        chat.enviaMensagem(0, 1, "Bom dia gente"); // ID 1
        chat.login("Léo", "123491!");
        chat.enviaMensagem(0, 2, "Bom dia João"); // ID 2
        //chat.enviaMensagem(0, 3, "Bom dia!"); //testando se um usuário que não está na conversa pode mandar mensagem(deu certo)
        //chat.excluiMensagem(0, 1, 2); // verificando se um usuario pode excluir a mensagem de outro(não pode)
        //chat.excluiMensagem(0, 2, 2); // consegue excluir a própria mensagem
        chat.excluiUsuario(2);
        chat.login("José", "8767@!$");
        chat.enviaMensagem(0, 3, "Fala galera!");
        chat.logout(3);
        chat.enviaMensagem(0, 2, "oi"); //testanto se um usuario excluído pode mandar mensagem(deu certo)






    }
}