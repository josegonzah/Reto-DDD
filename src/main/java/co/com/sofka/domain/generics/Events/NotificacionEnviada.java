package co.com.sofka.domain.generics.Events;

import co.com.sofka.domain.generic.DomainEvent;

public class NotificacionEnviada extends DomainEvent {
    private final String mensaje;


    public NotificacionEnviada(String mensaje) {
        super("sofka.generics.notificacionenviada");
        this.mensaje = mensaje;
    }

    public String getMensaje() {
        return mensaje;
    }
}
