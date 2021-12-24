package co.com.sofka.Curso.commands;

import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.NombreProfesor;
import co.com.sofka.Curso.values.Nombre;
import co.com.sofka.domain.generic.Command;

public class CrearProfesor extends Command {
    private final CursoId cursoId;
    private final Nombre profesorId;
    private final NombreProfesor nombreProfesor;


    public CrearProfesor(CursoId cursoId, Nombre profesorId, NombreProfesor nombreProfesor) {
        this.cursoId = cursoId;
        this.profesorId = profesorId;
        this.nombreProfesor = nombreProfesor;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public Nombre getProfesorId() {
        return profesorId;
    }

    public NombreProfesor getNombreProfesor() {
        return nombreProfesor;
    }
}
