package ar.edu.unlu.chatmvc.modelo;

public class Usuario implements IUsuario {
    private static int ID = 0;
    private int id;
    private String nombre;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.id = Usuario.ID++;
    }

    @Override
    public int getId() {
        return this.id;
    }

    @Override
    public String getNombre() {
        return this.nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
