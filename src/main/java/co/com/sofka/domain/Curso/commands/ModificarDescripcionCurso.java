package co.com.sofka.domain.Curso.commands;

import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Curso.values.DescripcionCurso;
import co.com.sofka.domain.generic.Command;

public class ModificarDescripcionCurso extends Command {
    private final CursoId cursoId;
    private final DescripcionCurso descripcionCurso;

    public ModificarDescripcionCurso(CursoId cursoId, DescripcionCurso descripcionCurso) {
        this.cursoId = cursoId;
        this.descripcionCurso = descripcionCurso;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public DescripcionCurso getDescripcion() {
        return descripcionCurso;
    }
}
