package co.com.sofka.domain.Certificacion.commands;

import co.com.sofka.domain.Certificacion.Values.CertificacionId;
import co.com.sofka.domain.Certificacion.Values.DescripcionPosiblePuesto;
import co.com.sofka.domain.Certificacion.Values.PosiblePuestoId;
import co.com.sofka.domain.generic.Command;

public class CrearPosiblePuesto extends Command {
    private final CertificacionId certificacionId;
    private final PosiblePuestoId posiblePuestoId;
    private final DescripcionPosiblePuesto descripcionPosiblePuesto;

    public CrearPosiblePuesto(CertificacionId certificacionId, PosiblePuestoId posiblePuestoId, DescripcionPosiblePuesto descripcionPosiblePuesto) {
        this.certificacionId = certificacionId;
        this.posiblePuestoId = posiblePuestoId;
        this.descripcionPosiblePuesto = descripcionPosiblePuesto;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }

    public PosiblePuestoId getPosiblePuestoId() {
        return posiblePuestoId;
    }

    public DescripcionPosiblePuesto getDescripcionPosiblePuesto() {
        return descripcionPosiblePuesto;
    }
}
