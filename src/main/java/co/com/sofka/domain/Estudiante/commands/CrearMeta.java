package co.com.sofka.domain.Estudiante.commands;

import co.com.sofka.domain.Estudiante.Values.*;
import co.com.sofka.domain.generic.Command;

public class CrearMeta extends Command {
    private final EstudianteId estudianteId;
    private final MetaId metaId;
    private final EstadoMeta estadoMeta;
    private final DescripcionMeta descripcionMeta;


    public CrearMeta(EstudianteId estudianteId, MetaId metaId, EstadoMeta estadoMeta, DescripcionMeta descripcionMeta) {
        this.estudianteId = estudianteId;
        this.metaId = metaId;
        this.estadoMeta = estadoMeta;
        this.descripcionMeta = descripcionMeta;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
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
