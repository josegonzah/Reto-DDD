package co.com.sofka.Curso.events;

import co.com.sofka.Curso.values.DescripcionSeccion;
import co.com.sofka.Curso.values.SeccionId;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionSeccionModificada extends DomainEvent {
    private final SeccionId seccionId;
    private final DescripcionSeccion descripcionSeccion;


    public DescripcionSeccionModificada(SeccionId seccionId, DescripcionSeccion descripcionSeccion) {
        super("sofka.curso.descripcionseccionmodificada");
        this.seccionId = seccionId;
        this.descripcionSeccion = descripcionSeccion;
    }

    public SeccionId getSeccionId() {
        return seccionId;
    }

    public DescripcionSeccion getDescripcionSeccion() {
        return descripcionSeccion;
    }
}
