package co.com.sofka.Estudiante.commands;

import co.com.sofka.Estudiante.Values.DescripcionInsignia;
import co.com.sofka.Estudiante.Values.EstudianteId;
import co.com.sofka.Estudiante.Values.InsigniaId;
import co.com.sofka.domain.generic.Command;

public class ModificarDescripcionInsignia extends Command {
    private final EstudianteId estudianteId;
    private final InsigniaId insigniaId;
    private final DescripcionInsignia descripcionInsignia;

    public ModificarDescripcionInsignia(EstudianteId estudianteId, InsigniaId insigniaId, DescripcionInsignia descripcionInsignia) {
        this.estudianteId = estudianteId;
        this.insigniaId = insigniaId;
        this.descripcionInsignia = descripcionInsignia;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public InsigniaId getInsigniaId() {
        return insigniaId;
    }

    public DescripcionInsignia getDescripcionInsignia() {
        return descripcionInsignia;
    }
}
