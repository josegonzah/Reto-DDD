package co.com.sofka.Curso;

import co.com.sofka.Curso.values.NombreProfesor;
import co.com.sofka.Curso.values.Nombre;
import co.com.sofka.domain.generic.Entity;

public class Profesor extends Entity<Nombre> {
    protected NombreProfesor nombreProfesor;

    public Profesor(Nombre entityId, NombreProfesor nombreProfesor) {
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
