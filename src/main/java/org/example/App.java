package org.example;

import org.example.chat.Conversa;
import org.example.chat.Mensagem;
import org.example.conta.GerenciadorContas;
import org.example.conta.Usuario;
import org.example.conta.UsuarioLogado;

import java.util.List;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    static Scanner sc = new Scanner(System.in);
    static UsuarioLogado usuarioLogado = null;

    public static void main( String[] args )
    {
        String nomeUsuario, senha;
        do {
            System.out.println("Digite o nome de usuário: ");
            nomeUsuario = sc.nextLine();
            System.out.println("Digite a senha: ");
            senha = sc.nextLine();
            usuarioLogado = (UsuarioLogado) GerenciadorContas.fazerLogin(nomeUsuario, senha);
        }
        while (usuarioLogado == null);

        List<Usuario> usuariosFake = GerenciadorContas.getContasFake();

        System.out.println("Veja as pessoas que também estão na rede social:");

        String respostaSeguir;
        for (Usuario u: usuariosFake) {
            System.out.println(u.getNomeCompleto());
            System.out.println("Deseja começar a seguir? (sim/nao)");
            respostaSeguir = sc.nextLine();
            if (respostaSeguir.equalsIgnoreCase("sim")) {
                usuarioLogado.seguirUsuario(u);
                System.out.println("Você agora segue " + u.getNomeCompleto());
            }
        }

        System.out.println("Você agora segue " + usuarioLogado.getSeguindo().size() + " usuários.");
        System.out.println(usuariosFake.get(1).getNomeCompleto() + " começou a te seguir.");

        System.out.println("\nVamos criar sua primeira postagem! Que tal dar um olá para o mundo? ");
        System.out.println("Digite sua mensagem:");
        String primeiroPost = sc.nextLine();
        usuarioLogado.criarPostagem(primeiroPost);

        System.out.println(usuariosFake.get(0).getNomeCompleto() + " curtiu sua postagem.");

        usuarioLogado.iniciarConversa(usuariosFake.get(2));
        Conversa conversa = usuarioLogado.getConversas().get(0);
        Mensagem mensagemInicial = new Mensagem(usuariosFake.get(2),"Olá, " + usuarioLogado.getNomeCompleto() + "! Como está?");
        conversa.enviarMensagem(mensagemInicial);

        System.out.println(mensagemInicial.getRemetente().getNomeCompleto() + " te enviou uma mensagem.");

        System.out.println(mensagemInicial.getRemetente().getNomeCompleto() + ": " + mensagemInicial.getConteudo());

        System.out.println("Digite sua resposta:");
        String respostaMensagem = sc.nextLine();
        usuarioLogado.enviarMensagem(conversa, respostaMensagem);


    }
}
