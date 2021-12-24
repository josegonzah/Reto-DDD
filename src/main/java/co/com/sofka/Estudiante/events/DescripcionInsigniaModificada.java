package co.com.sofka.Estudiante.events;

import co.com.sofka.Estudiante.Values.DescripcionInsignia;
import co.com.sofka.Estudiante.Values.InsigniaId;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionInsigniaModificada extends DomainEvent {
    private final InsigniaId insigniaId;
    private final DescripcionInsignia descripcionInsignia;


    public DescripcionInsigniaModificada(InsigniaId insigniaId, DescripcionInsignia descripcionInsignia) {
        super("sofka.estudiante.descripcioninsigniamodificada");
        this.insigniaId = insigniaId;
        this.descripcionInsignia = descripcionInsignia;
    }

    public InsigniaId getInsigniaId() {
        return insigniaId;
    }

    public DescripcionInsignia getDescripcionInsignia() {
        return descripcionInsignia;
    }
}
