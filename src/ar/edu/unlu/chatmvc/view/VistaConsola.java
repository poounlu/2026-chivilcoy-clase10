package ar.edu.unlu.chatmvc.view;

import ar.edu.unlu.chatmvc.controller.Controlador;
import ar.edu.unlu.chatmvc.modelo.IMensaje;
import ar.edu.unlu.chatmvc.modelo.IUsuario;

import java.util.Scanner;

public class VistaConsola implements IVista {

    private Controlador controlador;

    private Scanner stdin;

    public VistaConsola() {
        this.stdin = new Scanner(System.in);
    }

    @Override
    public void mostrarMensaje(IMensaje mensaje){
        String usuario = mensaje.getUsuario()
                .isPresent()
                ?
                mensaje.getUsuario().get().getNombre()
                :
                "Sistema";
        System.out.println("[" + usuario + "]: " + mensaje.getTexto());
    }

    @Override
    public void mostrarUsuariosConectados(IUsuario[] usuarios){
        System.out.println("Usuarios conectados:");
        for(IUsuario usuario : usuarios){
            System.out.println(usuario.getNombre());
        }
    }

    @Override
    public void setControlador(Controlador controlador) {
        this.controlador = controlador;
    }

    @Override
    public void mostrarIngresoDeUsuario() {
        System.out.println("Ingresá tu nombre");
        String nombre = this.stdin.nextLine();
        this.controlador.conectarUsuario(nombre);
    }

    @Override
    public void mostrarIngresoDeMensaje() {
        System.out.print("Mensaje: ");
        String mensaje = this.stdin.nextLine();
        this.controlador.enviarMensaje(mensaje);
    }
}
