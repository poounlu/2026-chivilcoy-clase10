package ar.edu.unlu.chatmvc.modelo;

import ar.edu.unlu.chatmvc.observer.Observable;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Optional;

public class Chat extends Observable {
    private HashMap<Integer, IUsuario> usuarios;
    private ArrayList<Mensaje> mensajes;

    public Chat() {
        super();
        this.usuarios = new HashMap<>();
        this.mensajes = new ArrayList<>();
    }

    public IUsuario conectarUsuario(String nombre) {
        IUsuario u = new Usuario(nombre);
        this.usuarios.put(u.getId(), u);
        this.notificarObservadores(Evento.CAMBIO_LISTA_USUARIOS);
        this.enviarMensajeDelSistema("Usuario " + nombre + " conectado");
        return u;
    }

    public void desconectarUsuario(int usuarioId) {
        IUsuario usuario = this.usuarios.get(usuarioId);
        if (usuario != null) {
            this.usuarios.remove(usuarioId);
            this.enviarMensajeDelSistema("Usuario " + usuario.getNombre() + " desconectado");
        }
    }

    public IMensaje[] getMensajes() {
        Mensaje[] resultado = new Mensaje[this.mensajes.size()];
        return this.mensajes.toArray(resultado);
    }

    public IUsuario[] getUsuarios() {
        IUsuario[] resultado = new IUsuario[this.usuarios.size()];
        return this.usuarios.values().toArray(resultado);
    }

    public void enviarMensaje(String texto, IUsuario iUsuario) {
        this.mensajes.add(new Mensaje(texto, iUsuario));
        this.notificarObservadores(Evento.NUEVO_MENSAJE);
    }

    public void enviarMensajeDelSistema(String texto) {
        this.mensajes.add(new Mensaje(texto));
        this.notificarObservadores(Evento.NUEVO_MENSAJE);
    }

    public Optional<IMensaje> getUltimoMensaje() {
        return Optional.ofNullable(this.mensajes.isEmpty() ? null : this.mensajes.get(this.mensajes.size() - 1));
    }
}
