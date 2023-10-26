package org.example.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.example.conta.Usuario;

@Getter@AllArgsConstructor
public class Mensagem {
    private Usuario remetente;
    private String conteudo;
}
