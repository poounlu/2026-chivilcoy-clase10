package ar.edu.unlu.chatmvc.controller;

import ar.edu.unlu.chatmvc.modelo.Chat;
import ar.edu.unlu.chatmvc.modelo.Evento;
import ar.edu.unlu.chatmvc.modelo.IMensaje;
import ar.edu.unlu.chatmvc.modelo.IUsuario;
import ar.edu.unlu.chatmvc.observer.IObservable;
import ar.edu.unlu.chatmvc.observer.IObservador;
import ar.edu.unlu.chatmvc.view.IVista;
import ar.edu.unlu.chatmvc.view.VistaConsola;

public class Controlador implements IObservador {

    private final Chat chat;

    private IVista vista;

    private IUsuario usuario;

    public Controlador(Chat chat, IVista vista){
        this.chat = chat;
        this.vista = vista;
        vista.setControlador(this);
    }

    public void conectarUsuario(String nombre){
        this.usuario = this.chat.conectarUsuario(nombre);
    }

    public void enviarMensaje(String texto){
        this.chat.enviarMensaje(texto, this.usuario);
    }

    @Override
    public void actualizar(IObservable fuente, Object evento) {
        switch ((Evento) evento){
            case NUEVO_MENSAJE:
                this.vista.mostrarMensaje(this.chat.getUltimoMensaje().orElseThrow());
                break;
            case CAMBIO_LISTA_USUARIOS:
                this.vista.mostrarUsuariosConectados(this.chat.getUsuarios());
                break;
        }
    }

    public void iniciar() {
        this.vista.mostrarIngresoDeUsuario();
        while(true){
            this.vista.mostrarIngresoDeMensaje();
        }
    }
}
