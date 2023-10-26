package org.example.conta;
import java.util.List;
import lombok.*;
import org.example.chat.Conversa;
import org.example.postagem.Postagem;

@Getter@AllArgsConstructor
public class Usuario {
    protected String nome;
    protected String sobrenome;
    protected List<Usuario> seguindo;
    protected List<Usuario> seguidores;
    protected String bio;
    protected List<Postagem> postagens;

    public String getNomeCompleto() {
        return nome + " " + sobrenome;
    }
}
