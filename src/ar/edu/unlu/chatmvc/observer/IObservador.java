package ar.edu.unlu.chatmvc.observer;

@FunctionalInterface
public interface IObservador {
    void actualizar(IObservable fuente, Object evento);
}
