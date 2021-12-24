package co.com.sofka.Curso.events;

import co.com.sofka.Curso.values.NombreProfesor;
import co.com.sofka.Curso.values.Nombre;
import co.com.sofka.domain.generic.DomainEvent;

public class ProfesorCreado extends DomainEvent {
    private final Nombre profesorId;
    private final NombreProfesor nombreProfesor;


    public ProfesorCreado(Nombre profesorId, NombreProfesor nombreProfesor) {
        super("sofka.curso.profesorcreado");
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
