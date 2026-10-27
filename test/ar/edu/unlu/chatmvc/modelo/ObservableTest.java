package ar.edu.unlu.chatmvc.modelo;

import ar.edu.unlu.chatmvc.observer.IObservable;
import ar.edu.unlu.chatmvc.observer.Observable;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class ObservableTest {

    private IObservable observable;

    @BeforeEach
    public void beforeEach(){
        this.observable = new Observable(){};
    }

    @Test
    public void test_notificacion_en_multiples_observadores(){
        MockObservador observador1 = new MockObservador();
        MockObservador observador2 = new MockObservador();
        String evento = "evento";
        this.observable.agregarObservador(observador1);
        this.observable.agregarObservador(observador2);
        this.observable.notificarObservadores(evento);
        assertTrue(observador1.isNotificado());
        assertEquals(evento, observador1.getUltimoEvento());
        assertEquals(this.observable, observador1.getUltimaFuente());
        assertTrue(observador2.isNotificado());
        assertEquals(evento, observador2.getUltimoEvento());
        assertEquals(this.observable, observador2.getUltimaFuente());
    }

    @Test
    public void test_baja_observador(){
        MockObservador observador1 = new MockObservador();
        this.observable.agregarObservador(observador1);
        this.observable.removerObservador(observador1);
        this.observable.notificarObservadores();
        assertFalse(observador1.isNotificado());
    }

    @Test
    public void test_agrega_observador_repetido(){
        MockObservador observador1 = new MockObservador();
        this.observable.agregarObservador(observador1);
        this.observable.agregarObservador(observador1);
        this.observable.notificarObservadores();
        assertTrue(observador1.isNotificado());
        assertEquals(1, observador1.getCantidadLlamadas());
    }

}