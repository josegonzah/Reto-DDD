package co.com.sofka.Certificacion.events;

import co.com.sofka.Certificacion.Values.DescripcionHabilidad;
import co.com.sofka.Certificacion.Values.HabilidadId;
import co.com.sofka.Certificacion.Values.NombreHabilidad;
import co.com.sofka.domain.generic.DomainEvent;

public class HabilidadCreada extends DomainEvent {
    private final HabilidadId habilidadId;
    private final NombreHabilidad nombreHabilidad;
    private final DescripcionHabilidad descripcionHabilidad;

    public HabilidadCreada(HabilidadId habilidadId, NombreHabilidad nombreHabilidad, DescripcionHabilidad descripcionHabilidad) {
        super("sofka.certificacion.habilidadcreada");
        this.habilidadId = habilidadId;
        this.nombreHabilidad = nombreHabilidad;
        this.descripcionHabilidad = descripcionHabilidad;
    }

    public HabilidadId getHabilidadId() {
        return habilidadId;
    }

    public NombreHabilidad getNombreHabilidad() {
        return nombreHabilidad;
    }

    public DescripcionHabilidad getDescripcionHabilidad() {
        return descripcionHabilidad;
    }
}
