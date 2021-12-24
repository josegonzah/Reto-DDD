package co.com.sofka.Estudiante.events;

import co.com.sofka.Estudiante.Values.EstadoMeta;
import co.com.sofka.Estudiante.Values.MetaId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoMetaModificado extends DomainEvent {
    private final MetaId metaId;
    private final EstadoMeta estadoMeta;

    public EstadoMetaModificado(MetaId metaId, EstadoMeta estadoMeta) {
        super("sofka.estudiante.estadometamodificado");
        this.metaId = metaId;
        this.estadoMeta = estadoMeta;
    }

    public MetaId getMetaId() {
        return metaId;
    }

    public EstadoMeta getEstadoMeta() {
        return estadoMeta;
    }
}
