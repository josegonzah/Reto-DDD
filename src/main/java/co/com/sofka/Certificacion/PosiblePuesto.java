package co.com.sofka.Certificacion;

import co.com.sofka.Certificacion.Values.DescripcionPosiblePuesto;
import co.com.sofka.Certificacion.Values.PosiblePuestoId;
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
