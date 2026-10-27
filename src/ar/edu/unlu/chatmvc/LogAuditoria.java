package ar.edu.unlu.chatmvc;

import ar.edu.unlu.chatmvc.modelo.Chat;
import ar.edu.unlu.chatmvc.modelo.Evento;
import ar.edu.unlu.chatmvc.modelo.IMensaje;
import ar.edu.unlu.chatmvc.modelo.Mensaje;
import ar.edu.unlu.chatmvc.observer.IObservable;
import ar.edu.unlu.chatmvc.observer.IObservador;

public class LogAuditoria implements IObservador {
    private Chat chat;

    public LogAuditoria(Chat chat) {
        this.chat = chat;
    }

    @Override
    public void actualizar(IObservable observable, Object evento) {
        if(evento == Evento.NUEVO_MENSAJE) {
            for (IMensaje mensaje : this.chat.getMensajes()) {
                System.out.println("[LOG] " + mensaje.getTexto());
            }
        }
    }
}
