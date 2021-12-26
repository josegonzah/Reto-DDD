package co.com.sofka.domain.Curso.events;

import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Curso.values.TituloCurso;
import co.com.sofka.domain.generic.DomainEvent;

public class TituloCursoModificado extends DomainEvent {
    private final CursoId cursoId;
    private final TituloCurso tituloCurso;


    public TituloCursoModificado(CursoId cursoId, TituloCurso tituloCurso) {
        super("sofka.curso.titulocursomodificado");
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
