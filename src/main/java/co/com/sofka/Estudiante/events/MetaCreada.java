package co.com.sofka.Estudiante.events;

import co.com.sofka.Estudiante.Values.DescripcionMeta;
import co.com.sofka.Estudiante.Values.EstadoMeta;
import co.com.sofka.Estudiante.Values.MetaId;
import co.com.sofka.domain.generic.DomainEvent;

public class MetaCreada extends DomainEvent {
    private final MetaId metaId;
    private final EstadoMeta estadoMeta;
    private final DescripcionMeta descripcionMeta;

    public MetaCreada(MetaId metaId, EstadoMeta estadoMeta, DescripcionMeta descripcionMeta) {
        super("sofka.estudiante.metacreada");
        this.metaId = metaId;
        this.estadoMeta = estadoMeta;
        this.descripcionMeta = descripcionMeta;
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
