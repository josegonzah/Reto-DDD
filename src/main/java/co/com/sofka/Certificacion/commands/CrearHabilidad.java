package co.com.sofka.Certificacion.commands;

import co.com.sofka.Certificacion.Values.CertificacionId;
import co.com.sofka.Certificacion.Values.DescripcionHabilidad;
import co.com.sofka.Certificacion.Values.HabilidadId;
import co.com.sofka.Certificacion.Values.NombreHabilidad;
import co.com.sofka.domain.generic.Command;

public class CrearHabilidad extends Command {
    private final CertificacionId certificacionId;
    private final HabilidadId habilidadId;
    private final NombreHabilidad nombreHabilidad;
    private final DescripcionHabilidad descripcionHabilidad;

    public CrearHabilidad(CertificacionId certificacionId, HabilidadId habilidadId, NombreHabilidad nombreHabilidad, DescripcionHabilidad descripcionHabilidad) {
        this.certificacionId = certificacionId;
        this.habilidadId = habilidadId;
        this.nombreHabilidad = nombreHabilidad;
        this.descripcionHabilidad = descripcionHabilidad;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
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
