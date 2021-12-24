package co.com.sofka.Estudiante.events;

import co.com.sofka.Estudiante.Values.DescripcionInsignia;
import co.com.sofka.Estudiante.Values.InsigniaId;
import co.com.sofka.Estudiante.Values.RangoInsignia;
import co.com.sofka.domain.generic.DomainEvent;

public class InsigniaCreada extends DomainEvent {
    private final InsigniaId insigniaId;
    private final RangoInsignia rangoInsignia;
    private final DescripcionInsignia descripcionInsignia;

    public InsigniaCreada(InsigniaId insigniaId, RangoInsignia rangoInsignia, DescripcionInsignia descripcionInsignia) {
        super("sofka.estudiante.estudiantecreado");
        this.insigniaId = insigniaId;
        this.rangoInsignia = rangoInsignia;
        this.descripcionInsignia = descripcionInsignia;
    }

    public InsigniaId getInsigniaId() {
        return insigniaId;
    }

    public RangoInsignia getRangoInsignia() {
        return rangoInsignia;
    }

    public DescripcionInsignia getDescripcionInsignia() {
        return descripcionInsignia;
    }
}
