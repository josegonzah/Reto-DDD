package co.com.sofka.Curso.events;

import co.com.sofka.Curso.values.NombreProfesor;
import co.com.sofka.Curso.values.ProfesorId;
import co.com.sofka.domain.generic.DomainEvent;

public class ProfesorCreado extends DomainEvent {
    private final ProfesorId profesorId;
    private final NombreProfesor nombreProfesor;


    public ProfesorCreado(ProfesorId profesorId, NombreProfesor nombreProfesor) {
        super("sofka.curso.profesorcreado");
        this.profesorId = profesorId;
        this.nombreProfesor = nombreProfesor;
    }

    public ProfesorId getProfesorId() {
        return profesorId;
    }

    public NombreProfesor getNombreProfesor() {
        return nombreProfesor;
    }
}
