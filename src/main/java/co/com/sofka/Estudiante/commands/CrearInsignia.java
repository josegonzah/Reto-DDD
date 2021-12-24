package co.com.sofka.Estudiante.commands;

import co.com.sofka.Estudiante.Values.DescripcionInsignia;
import co.com.sofka.Estudiante.Values.EstudianteId;
import co.com.sofka.Estudiante.Values.InsigniaId;
import co.com.sofka.Estudiante.Values.RangoInsignia;
import co.com.sofka.domain.generic.Command;

public class CrearInsignia extends Command {
    private final EstudianteId estudianteId;
    private final InsigniaId insigniaId;
    private final RangoInsignia rangoInsignia;
    private final DescripcionInsignia descripcionInsignia;


    public CrearInsignia(EstudianteId estudianteId, InsigniaId insigniaId, RangoInsignia rangoInsignia, DescripcionInsignia descripcionInsignia) {
        this.estudianteId = estudianteId;
        this.insigniaId = insigniaId;
        this.rangoInsignia = rangoInsignia;
        this.descripcionInsignia = descripcionInsignia;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public InsigniaId getInsigniaId() {
        return insigniaId;
    }

    public RangoInsignia getRangoInsignia() {
        return rangoInsignia;
    }

    public DescripcionInsignia getDescripcionInsignia() {
        return descripcionInsignia;
    }
}
