package co.com.sofka.Curso.events;

import co.com.sofka.Curso.values.NombreProfesor;
import co.com.sofka.Curso.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class NombreProfesorModificado extends DomainEvent {
    private final Nombre profesorId;
    private final NombreProfesor nombreProfesor;


    public NombreProfesorModificado(Nombre profesorId, NombreProfesor nombreProfesor) {
        super("sofka.curso.nombreprofesormodificado");
        this.profesorId = profesorId;
        this.nombreProfesor = nombreProfesor;
    }

    public Nombre getProfesorId() {
        return profesorId;
    }

    public NombreProfesor getNombreProfesor() {
        return nombreProfesor;
    }
}
