package org.example.conta;

import org.example.chat.Conversa;
import org.example.postagem.Postagem;

import java.util.List;
import java.util.ArrayList;

public class GerenciadorContas {
    public static UsuarioLogado fazerLogin(String nomeUsuario, String senha) {
        if (nomeUsuario.equalsIgnoreCase("admin") && (senha.equalsIgnoreCase("admin"))) {
            UsuarioLogado usuario = new UsuarioLogado("Rodrigo", "Magalhães", new ArrayList<Usuario>(), new ArrayList<Usuario>(), "Programador Java", new ArrayList<Postagem>(), new ArrayList<Conversa>());
            System.out.println("Seja bem-vindo, " + usuario.getNomeCompleto() + "!\n");
            return usuario;
        }
        System.out.println("Usuário ou senha inválido.");
        return null;
    }

    public static List<Usuario> getContasFake() {
        List<Usuario> listaUsuarios = new ArrayList<Usuario>();
        listaUsuarios.add(new Usuario(
                "Leonardo",
                "Glória",
                new ArrayList<Usuario>(),
                new ArrayList<Usuario>(),
                "Professor de Java",
                new ArrayList<Postagem>()));
        listaUsuarios.add(new Usuario(
                "Sarah",
                "Figueiredo",
                new ArrayList<Usuario>(),
                new ArrayList<Usuario>(),
                "Estudante de Engenharia",
                new ArrayList<Postagem>()));
        listaUsuarios.add(new Usuario(
                "Diego",
                "Dias",
                new ArrayList<Usuario>(),
                new ArrayList<Usuario>(),
                "Professor de C#",
                new ArrayList<Postagem>()));
        return listaUsuarios;
    }
}