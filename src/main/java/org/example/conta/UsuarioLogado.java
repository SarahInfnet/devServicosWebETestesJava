package org.example.conta;

import lombok.Getter;
import lombok.Setter;
import org.example.chat.Conversa;
import org.example.chat.Mensagem;
import org.example.postagem.Postagem;

import java.util.ArrayList;
import java.util.List;

@Getter@Setter
public class UsuarioLogado extends Usuario {
    private List<Conversa> conversas;

    public UsuarioLogado(String nome, String sobrenome, List<Usuario> seguindo, List<Usuario> seguidores, String bio, List<Postagem> postagens, List<Conversa> conversas) {
        super(nome, sobrenome, seguindo, seguidores, bio, postagens);
        this.conversas = conversas;
    }

    public void seguirUsuario(Usuario usuario) {
        seguindo.add(usuario);
    }

    public void iniciarConversa(Usuario usuario) {
        Conversa conversa = new Conversa(new ArrayList<Mensagem>());
        conversas.add(conversa);
    }

    public Usuario getUsuarioPublico() {
        Usuario usuarioPublico = new Usuario(
                this.nome,
                this.sobrenome,
                this.seguidores,
                this.seguindo,
                this.bio,
                this.postagens);
        return usuarioPublico;
    }

    public void enviarMensagem(Conversa conversa, String conteudo) {
        Mensagem mensagem = new Mensagem(getUsuarioPublico(), conteudo);
        conversa.enviarMensagem(mensagem);
    }

    public void criarPostagem(String conteudo) {
        postagens.add(new Postagem(conteudo));
    }
}
