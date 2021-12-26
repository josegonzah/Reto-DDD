package co.com.sofka.domain.Estudiante.events;

import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Estudiante.Values.EstadoCurso;
import co.com.sofka.domain.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.Estudiante.Values.NombreEstudiante;
import co.com.sofka.domain.generic.DomainEvent;

public class EstudianteCreado extends DomainEvent {
    private final EstudianteId estudianteId;
    private final CursoId cursoId;
    private final EstadoCurso estadoCurso;
    private final NombreEstudiante nombreEstudiante;

    public EstudianteCreado(EstudianteId estudianteId, CursoId cursoId, EstadoCurso estadoCurso, NombreEstudiante nombreEstudiante) {
        super("sofka.estudiante.estudiantecreado");
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
        this.estadoCurso = estadoCurso;
        this.nombreEstudiante = nombreEstudiante;
    }

    public NombreEstudiante getNombreEstudiante() {
        return nombreEstudiante;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public EstadoCurso getEstadoCurso() {
        return estadoCurso;
    }
}
