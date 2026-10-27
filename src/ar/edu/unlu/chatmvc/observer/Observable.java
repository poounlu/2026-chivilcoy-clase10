package ar.edu.unlu.chatmvc.observer;

import java.util.ArrayList;
import java.util.List;

public abstract class Observable implements IObservable {
    protected List<IObservador> observadores;

    public Observable() {
        this.observadores = new ArrayList<>();
    }

    @Override
    public void agregarObservador(IObservador observador) {
        if (!this.observadores.contains(observador)) {
            this.observadores.add(observador);
        }
    }

    @Override
    public void removerObservador(IObservador observador) {
        this.observadores.remove(observador);
    }

    @Override
    public void notificarObservadores(Object evento) {
        for (IObservador observador : this.observadores) {
            observador.actualizar(this, evento);
        }
    }

    @Override
    public void notificarObservadores() {
        this.notificarObservadores(null);
    }
}
