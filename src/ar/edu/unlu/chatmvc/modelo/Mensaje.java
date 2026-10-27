package ar.edu.unlu.chatmvc.modelo;

import java.time.LocalDateTime;
import java.util.Optional;

public class Mensaje implements IMensaje {
    private LocalDateTime fecha;
    private IUsuario iUsuario;
    private String texto;

    public Mensaje(String texto, IUsuario usuario) {
        this.fecha = LocalDateTime.now();
        this.iUsuario = usuario;
        this.texto = texto;
    }

    public Mensaje(String texto) {
        this(texto, null);
    }

    @Override
    public LocalDateTime getFecha() {
        return this.fecha;
    }

    @Override
    public Optional<IUsuario> getUsuario() {
        return Optional.ofNullable(this.iUsuario);
    }

    @Override
    public String getTexto() {
        return this.texto;
    }

    public void setTexto(String texto) {
        this.texto = texto;
    }

    public boolean isMensajeDelSistema() {
        return this.iUsuario == null;
    }
}
