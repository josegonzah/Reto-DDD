package co.com.sofka.domain.Curso.events;

import co.com.sofka.domain.Curso.values.DescripcionSeccion;
import co.com.sofka.domain.Curso.values.SeccionId;
import co.com.sofka.domain.Curso.values.TituloSeccion;
import co.com.sofka.domain.generic.DomainEvent;

public class SeccionAgregada extends DomainEvent {
    private final SeccionId seccionId;
    private final TituloSeccion tituloSeccion;
    private final DescripcionSeccion descripcionSeccion;


    public SeccionAgregada(SeccionId seccionId, TituloSeccion tituloSeccion, DescripcionSeccion descripcionSeccion) {
        super("sofka.curso.seccionagregada");
        this.seccionId = seccionId;
        this.tituloSeccion = tituloSeccion;
        this.descripcionSeccion = descripcionSeccion;
    }

    public SeccionId getSeccionId() {
        return seccionId;
    }

    public TituloSeccion getTituloSeccion() {
        return tituloSeccion;
    }

    public DescripcionSeccion getDescripcionSeccion() {
        return descripcionSeccion;
    }
}
