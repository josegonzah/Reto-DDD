package co.com.sofka.Curso.events;

import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.Descripcion;
import co.com.sofka.domain.generic.DomainEvent;

public class DescripcionCursoModificada extends DomainEvent {
    private final CursoId cursoId;
    private final Descripcion descripcion;


    public DescripcionCursoModificada(CursoId cursoId, Descripcion descripcion) {
        super("sofka.curso.descripcionmodificada");
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
