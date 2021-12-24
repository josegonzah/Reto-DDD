package co.com.sofka.Estudiante.events;

import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Estudiante.Values.EstadoCurso;
import co.com.sofka.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstudianteCreado extends DomainEvent {
    private final EstudianteId estudianteId;
    private final CursoId cursoId;
    private final EstadoCurso estadoCurso;

    public EstudianteCreado(EstudianteId estudianteId, CursoId cursoId, EstadoCurso estadoCurso) {
        super("sofka.estudiante.estudiantecreado");
        this.estudianteId = estudianteId;
        this.cursoId = cursoId;
        this.estadoCurso = estadoCurso;
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
