package co.com.sofka.domain.Curso.commands;

import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Curso.values.NombreProfesor;
import co.com.sofka.domain.Curso.values.ProfesorId;
import co.com.sofka.domain.generic.Command;

public class ModificarNombreProfesor extends Command {
    private final CursoId cursoId;
    private final ProfesorId profesorId;
    private final NombreProfesor nombreProfesor;

    public ModificarNombreProfesor(CursoId cursoId, ProfesorId profesorId, NombreProfesor nombreProfesor) {
        this.cursoId = cursoId;
        this.profesorId = profesorId;
        this.nombreProfesor = nombreProfesor;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public ProfesorId getProfesorId() {
        return profesorId;
    }

    public NombreProfesor getNombreProfesor() {
        return nombreProfesor;
    }
}
