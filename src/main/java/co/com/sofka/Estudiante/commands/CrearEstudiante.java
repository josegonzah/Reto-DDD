package co.com.sofka.Estudiante.commands;

import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Estudiante.Values.EstudianteId;
import co.com.sofka.Estudiante.Values.NombreEstudiante;
import co.com.sofka.domain.generic.Command;

public class CrearEstudiante extends Command {
    private final EstudianteId estudianteId;
    private final NombreEstudiante nombreEstudiante;
    private final CursoId cursoId;

    public CrearEstudiante(EstudianteId estudianteId, NombreEstudiante nombreEstudiante, CursoId cursoId) {
        this.estudianteId = estudianteId;
        this.nombreEstudiante = nombreEstudiante;
        this.cursoId = cursoId;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public NombreEstudiante getNombreEstudiante() {
        return nombreEstudiante;
    }

    public CursoId getCursoId() {
        return cursoId;
    }
}
