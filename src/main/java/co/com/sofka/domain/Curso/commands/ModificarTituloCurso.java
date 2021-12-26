package co.com.sofka.domain.Curso.commands;

import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Curso.values.TituloCurso;
import co.com.sofka.domain.generic.Command;

public class ModificarTituloCurso extends Command {
    private final CursoId cursoId;
    private final TituloCurso tituloCurso;

    public ModificarTituloCurso(CursoId cursoId, TituloCurso tituloCurso) {
        this.cursoId = cursoId;
        this.tituloCurso = tituloCurso;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public TituloCurso getTitulo() {
        return tituloCurso;
    }
}
