package co.com.sofka.Curso.events;

import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.DescripcionCurso;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionCursoModificada extends DomainEvent {
    private final CursoId cursoId;
    private final DescripcionCurso descripcionCurso;


    public DescripcionCursoModificada(CursoId cursoId, DescripcionCurso descripcionCurso) {
        super("sofka.curso.descripcionmodificada");
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
