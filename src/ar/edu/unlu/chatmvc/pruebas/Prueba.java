package ar.edu.unlu.chatmvc.pruebas;

import ar.edu.unlu.chatmvc.LogAuditoria;
import ar.edu.unlu.chatmvc.controller.Controlador;
import ar.edu.unlu.chatmvc.modelo.Chat;
import ar.edu.unlu.chatmvc.modelo.IUsuario;
import ar.edu.unlu.chatmvc.view.VistaConsola;

public class Prueba {

    public static void main(String[] args) {
        Chat chat = new Chat();
        //chat.agregarObservador(new LogAuditoria(chat));
        VistaConsola vistaAna = new VistaConsola();
        Controlador controladorAna = new Controlador(chat, vistaAna);
        VistaConsola vistaJuan = new VistaConsola();
        Controlador controladorJuan = new Controlador(chat, vistaJuan);
        chat.agregarObservador(controladorAna);
        controladorAna.iniciar();
//        controladorAna.conectarUsuario("Ana");
//        controladorAna.enviarMensaje("¡Hola a todos!");
//        controladorJuan.conectarUsuario("Juan");
//        controladorJuan.enviarMensaje("¡Hola Ana! ¿Todo bien?");
    }
}
