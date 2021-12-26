package co.com.sofka.Curso.commands;

import co.com.sofka.Curso.Profesor;
import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.DescripcionCurso;
import co.com.sofka.Curso.values.TituloCurso;
import co.com.sofka.domain.generic.Command;

public class CrearCurso extends Command {
    private final CursoId cursoId;
    private final Profesor profesor;
    private final TituloCurso tituloCurso;
    private final DescripcionCurso descripcionCurso;

    public CrearCurso(CursoId cursoId, Profesor profesor, TituloCurso tituloCurso, DescripcionCurso descripcionCurso) {
        this.cursoId = cursoId;
        this.profesor = profesor;
        this.tituloCurso = tituloCurso;
        this.descripcionCurso = descripcionCurso;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public TituloCurso getTitulo() {
        return tituloCurso;
    }

    public DescripcionCurso getDescripcion() {
        return descripcionCurso;
    }
}
