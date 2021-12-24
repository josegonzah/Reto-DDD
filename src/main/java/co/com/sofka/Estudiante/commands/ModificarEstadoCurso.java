package co.com.sofka.Estudiante.commands;

import co.com.sofka.Estudiante.Values.EstadoCurso;
import co.com.sofka.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.generic.Command;

public class ModificarEstadoCurso extends Command {
    private final EstudianteId estudianteId;
    private final EstadoCurso estadoCurso;

    public ModificarEstadoCurso(EstudianteId estudianteId, EstadoCurso estadoCurso) {
        this.estudianteId = estudianteId;
        this.estadoCurso = estadoCurso;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public EstadoCurso getEstadoCurso() {
        return estadoCurso;
    }
}
