package co.com.sofka.Estudiante.events;

import co.com.sofka.Estudiante.Values.EstadoCurso;
import co.com.sofka.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.generic.DomainEvent;

public class EstadoCursoEstudianteModificado extends DomainEvent {
    private final EstudianteId estudianteId;
    private final EstadoCurso estadoCurso;


    public EstadoCursoEstudianteModificado(EstudianteId estudianteId, EstadoCurso estadoCurso) {
        super("sofka.estudiante.estadocursoestudiantemodificado");
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
