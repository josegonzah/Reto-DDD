package co.com.sofka.Estudiante;

import co.com.sofka.Estudiante.Values.DescripcionMeta;
import co.com.sofka.Estudiante.Values.EstadoMeta;
import co.com.sofka.Estudiante.Values.MetaId;
import co.com.sofka.domain.generic.Entity;

public class Meta extends Entity<MetaId> {
    protected MetaId metaId;
    protected EstadoMeta estadoMeta;
    protected DescripcionMeta descripcionMeta;

    public Meta(MetaId entityId, EstadoMeta estadoMeta, DescripcionMeta descripcionMeta) {
        super(entityId);
        this.metaId = entityId;
        this.estadoMeta = estadoMeta;
        this.descripcionMeta = descripcionMeta;
    }

    public void modificarEstadoMeta(EstadoMeta estadoMeta){
        this.estadoMeta = estadoMeta;
    }

    public MetaId getMetaId() {
        return metaId;
    }

    public EstadoMeta getEstadoMeta() {
        return estadoMeta;
    }

    public DescripcionMeta getDescripcionMeta() {
        return descripcionMeta;
    }
}
