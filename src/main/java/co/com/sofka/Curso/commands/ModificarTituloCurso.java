package co.com.sofka.Curso.commands;

import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.Titulo;
import co.com.sofka.domain.generic.Command;

public class ModificarTituloCurso extends Command {
    private final CursoId cursoId;
    private final Titulo titulo;

    public ModificarTituloCurso(CursoId cursoId, Titulo titulo) {
        this.cursoId = cursoId;
        this.titulo = titulo;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public Titulo getTitulo() {
        return titulo;
    }
}
