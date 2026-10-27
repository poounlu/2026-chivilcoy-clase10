package ar.edu.unlu.chatmvc.modelo;

import java.time.LocalDateTime;
import java.util.Optional;

public interface IMensaje {
    LocalDateTime getFecha();

    Optional<IUsuario> getUsuario();

    String getTexto();
}
