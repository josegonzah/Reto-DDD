package co.com.sofka.Curso.events;

import co.com.sofka.Curso.values.SeccionId;
import co.com.sofka.Curso.values.TituloSeccion;
import co.com.sofka.domain.generic.DomainEvent;

public class TituloSeccionModificada extends DomainEvent {
    private final SeccionId seccionId;
    private final TituloSeccion tituloSeccion;


    public TituloSeccionModificada(SeccionId seccionId, TituloSeccion tituloSeccion) {
        super("sofka.curso.tituloseccionmodificada");
        this.seccionId = seccionId;
        this.tituloSeccion = tituloSeccion;
    }

    public SeccionId getSeccionId() {
        return seccionId;
    }

    public TituloSeccion getTituloSeccion() {
        return tituloSeccion;
    }
}
