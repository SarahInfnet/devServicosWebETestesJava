package org.example.postagem;

import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.example.conta.Usuario;

@Getter@RequiredArgsConstructor
public class Postagem {
    @NonNull private String textoPostagem;
    private List<Usuario> usuariosCurtiram;

    public void curtirPostagem(Usuario usuario) {
        if (!usuariosCurtiram.contains(usuario)) {
            usuariosCurtiram.add(usuario);
        }
        System.out.println("Postagem curtida!");
    }

    public int getTotalCurtidas() {
        return usuariosCurtiram.size();
    }
}
