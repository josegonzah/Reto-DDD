package co.com.sofka.Curso.events;

import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.Titulo;
import co.com.sofka.domain.generic.DomainEvent;

public class TituloCursoModificado extends DomainEvent {
    private final CursoId cursoId;
    private final Titulo titulo;


    public TituloCursoModificado(CursoId cursoId, Titulo titulo) {
        super("sofka.curso.titulocursomodificado");
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
