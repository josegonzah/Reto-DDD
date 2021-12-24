package co.com.sofka.Curso.events;

import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.Descripcion;
import co.com.sofka.Curso.values.ProfesorId;
import co.com.sofka.Curso.values.Titulo;
import co.com.sofka.domain.generic.DomainEvent;

public class CursoCreado extends DomainEvent {
    private final CursoId cursoId;
    private final Titulo titulo;
    private final ProfesorId profesorId;
    private final Descripcion descripcion;


    public CursoCreado(CursoId cursoId, ProfesorId profesorId, Titulo titulo, Descripcion descripcion) {
        super("sofka.curso.cursocreado");
        this.cursoId = cursoId;
        this.profesorId = profesorId;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public ProfesorId getProfesorId() {
        return profesorId;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
