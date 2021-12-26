package co.com.sofka.domain.Certificacion;

import co.com.sofka.domain.Certificacion.Values.DescripcionPosiblePuesto;
import co.com.sofka.domain.Certificacion.Values.PosiblePuestoId;
import co.com.sofka.domain.generic.Entity;

public class PosiblePuesto extends Entity<PosiblePuestoId> {
    protected DescripcionPosiblePuesto descripcionPosiblePuesto;

    public PosiblePuesto(PosiblePuestoId entityId, DescripcionPosiblePuesto descripcionPosiblePuesto) {
        super(entityId);
        this.descripcionPosiblePuesto = descripcionPosiblePuesto;
    }

    public DescripcionPosiblePuesto getDescripcionPosiblePuesto() {
        return descripcionPosiblePuesto;
    }
}
