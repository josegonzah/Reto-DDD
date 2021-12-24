package co.com.sofka.Estudiante.commands;

import co.com.sofka.Estudiante.Values.DescripcionInsignia;
import co.com.sofka.Estudiante.Values.EstudianteId;
import co.com.sofka.Estudiante.Values.MetaId;
import co.com.sofka.Estudiante.Values.RangoInsignia;
import co.com.sofka.domain.generic.Command;

public class CrearMeta extends Command {
    private final EstudianteId estudianteId;
    private final MetaId metaId;
    private final RangoInsignia rangoInsignia;
    private final DescripcionInsignia descripcionInsignia;

    public CrearMeta(EstudianteId estudianteId, MetaId metaId, RangoInsignia rangoInsignia, DescripcionInsignia descripcionInsignia) {
        this.estudianteId = estudianteId;
        this.metaId = metaId;
        this.rangoInsignia = rangoInsignia;
        this.descripcionInsignia = descripcionInsignia;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public MetaId getMetaId() {
        return metaId;
    }

    public RangoInsignia getRangoInsignia() {
        return rangoInsignia;
    }

    public DescripcionInsignia getDescripcionInsignia() {
        return descripcionInsignia;
    }
}
