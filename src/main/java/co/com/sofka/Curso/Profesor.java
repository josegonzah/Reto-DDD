package co.com.sofka.Curso;

import co.com.sofka.Curso.values.NombreProfesor;
import co.com.sofka.Curso.values.Nombre;
import co.com.sofka.Curso.values.ProfesorId;
import co.com.sofka.domain.generic.Entity;

public class Profesor extends Entity<ProfesorId> {
    protected NombreProfesor nombreProfesor;

    public Profesor(ProfesorId entityId, NombreProfesor nombreProfesor) {
        super(entityId);
        this.nombreProfesor = nombreProfesor;
    }

    public void ModificarNombreProfesor(NombreProfesor nombreProfesor){
        this.nombreProfesor = nombreProfesor;
    }

    public NombreProfesor nombreProfesor() {
        return nombreProfesor;
    }
}
