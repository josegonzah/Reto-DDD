package co.com.sofka.domain.Estudiante.commands;

import co.com.sofka.domain.Estudiante.Values.EstadoMeta;
import co.com.sofka.domain.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.Estudiante.Values.MetaId;
import co.com.sofka.domain.generic.Command;

public class ModificarEstadoMeta extends Command {
    private final EstudianteId estudianteId;
    private final MetaId metaId;
    private final EstadoMeta estadoMeta;

    public ModificarEstadoMeta(EstudianteId estudianteId, MetaId metaId, EstadoMeta estadoMeta) {
        this.estudianteId = estudianteId;
        this.metaId = metaId;
        this.estadoMeta = estadoMeta;
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
}
