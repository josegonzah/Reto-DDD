package co.com.sofka.Curso.commands;

import co.com.sofka.Curso.Profesor;
import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.Descripcion;
import co.com.sofka.Curso.values.Titulo;
import co.com.sofka.domain.generic.Command;

public class CrearCurso extends Command {
    private final CursoId cursoId;
    private final Profesor profesor;
    private final Titulo titulo;
    private final Descripcion descripcion;

    public CrearCurso(CursoId cursoId, Profesor profesor, Titulo titulo, Descripcion descripcion) {
        this.cursoId = cursoId;
        this.profesor = profesor;
        this.titulo = titulo;
        this.descripcion = descripcion;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public Titulo getTitulo() {
        return titulo;
    }

    public Descripcion getDescripcion() {
        return descripcion;
    }
}
