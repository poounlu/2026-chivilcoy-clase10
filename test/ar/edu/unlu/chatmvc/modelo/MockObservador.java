package ar.edu.unlu.chatmvc.modelo;

import ar.edu.unlu.chatmvc.observer.IObservable;
import ar.edu.unlu.chatmvc.observer.IObservador;

public class MockObservador implements IObservador {
    private boolean notificado;
    private int cantidadLlamadas;
    private IObservable ultimaFuente;
    private Object ultimoEvento;

    public MockObservador() {
        this.notificado = false;
        this.cantidadLlamadas = 0;
    }

    @Override
    public void actualizar(IObservable fuente, Object evento) {
        this.notificado = true;
        this.cantidadLlamadas++;
        this.ultimaFuente = fuente;
        this.ultimoEvento = evento;
    }

    public boolean isNotificado() {
        return notificado;
    }

    public int getCantidadLlamadas() {
        return this.cantidadLlamadas;
    }

    public IObservable getUltimaFuente(){
        return this.ultimaFuente;
    }

    public Object getUltimoEvento(){
        return this.ultimoEvento;
    }
}
