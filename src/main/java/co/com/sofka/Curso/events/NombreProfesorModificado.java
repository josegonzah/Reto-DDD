package co.com.sofka.Curso.events;

import co.com.sofka.Curso.values.NombreProfesor;
import co.com.sofka.Curso.values.ProfesorId;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreProfesorModificado extends DomainEvent {
    private final ProfesorId profesorId;
    private final NombreProfesor nombreProfesor;


    public NombreProfesorModificado(ProfesorId profesorId, NombreProfesor nombreProfesor) {
        super("sofka.curso.nombreprofesormodificado");
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
