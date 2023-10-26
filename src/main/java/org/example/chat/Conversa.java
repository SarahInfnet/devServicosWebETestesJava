package org.example.chat;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

@Getter@AllArgsConstructor
public class Conversa {
    private List<Mensagem> mensagens;

    public void enviarMensagem(Mensagem mensagem) {
        mensagens.add(mensagem);
    }
}
