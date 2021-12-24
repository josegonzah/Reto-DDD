package co.com.sofka.Curso.commands;

import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.Descripcion;
import co.com.sofka.domain.generic.Command;

public class ModificarDescripcionCurso extends Command {
    private final CursoId cursoId;
    private final Descripcion descripcion;

    public ModificarDescripcionCurso(CursoId cursoId, Descripcion descripcion) {
        this.cursoId = cursoId;
        this.descripcion = descripcion;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
