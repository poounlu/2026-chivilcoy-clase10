package ar.edu.unlu.chatmvc.view;

import ar.edu.unlu.chatmvc.controller.Controlador;
import ar.edu.unlu.chatmvc.modelo.IMensaje;
import ar.edu.unlu.chatmvc.modelo.IUsuario;

public interface IVista {
    void mostrarMensaje(IMensaje mensaje);

    void mostrarUsuariosConectados(IUsuario[] usuarios);

    void setControlador(Controlador controlador);

    void mostrarIngresoDeUsuario();

    void mostrarIngresoDeMensaje();
}
