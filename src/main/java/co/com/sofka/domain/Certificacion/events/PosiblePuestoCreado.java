package co.com.sofka.domain.Certificacion.events;

import co.com.sofka.domain.Certificacion.Values.DescripcionPosiblePuesto;
import co.com.sofka.domain.Certificacion.Values.PosiblePuestoId;
import co.com.sofka.domain.generic.DomainEvent;

public class PosiblePuestoCreado extends DomainEvent {
    private final PosiblePuestoId posiblePuestoId;
    private final DescripcionPosiblePuesto descripcionPosiblePuesto;

    public PosiblePuestoCreado(PosiblePuestoId posiblePuestoId, DescripcionPosiblePuesto descripcionPosiblePuesto) {
        super("sofka.certificacion.posiblepuestocreado");
        this.posiblePuestoId = posiblePuestoId;
        this.descripcionPosiblePuesto = descripcionPosiblePuesto;
    }

    public PosiblePuestoId getPosiblePuestoId() {
        return posiblePuestoId;
    }

    public DescripcionPosiblePuesto getDescripcionPosiblePuesto() {
        return descripcionPosiblePuesto;
    }
}
