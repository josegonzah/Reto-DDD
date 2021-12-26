package co.com.sofka.domain.Certificacion;

import co.com.sofka.domain.Certificacion.Values.DescripcionHabilidad;
import co.com.sofka.domain.Certificacion.Values.HabilidadId;
import co.com.sofka.domain.Certificacion.Values.NombreHabilidad;
import co.com.sofka.domain.generic.Entity;

public class Habilidad extends Entity<HabilidadId> {
    protected NombreHabilidad nombreHabilidad;
    protected DescripcionHabilidad descripcionHabilidad;

    public Habilidad(HabilidadId entityId, NombreHabilidad nombreHabilidad, DescripcionHabilidad descripcionHabilidad) {
        super(entityId);
        this.nombreHabilidad = nombreHabilidad;
        this.descripcionHabilidad = descripcionHabilidad;
    }

    public NombreHabilidad getNombreHabilidad() {
        return nombreHabilidad;
    }

    public DescripcionHabilidad getDescripcionHabilidad() {
        return descripcionHabilidad;
    }
}
