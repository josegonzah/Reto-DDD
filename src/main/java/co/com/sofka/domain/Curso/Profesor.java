package co.com.sofka.domain.Curso;

import co.com.sofka.domain.Curso.values.NombreProfesor;
import co.com.sofka.domain.Curso.values.ProfesorId;
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
