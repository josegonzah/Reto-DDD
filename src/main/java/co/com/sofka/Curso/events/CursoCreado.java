package co.com.sofka.Curso.events;

import co.com.sofka.Curso.Profesor;
import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.DescripcionCurso;
import co.com.sofka.Curso.values.TituloCurso;
import co.com.sofka.domain.generic.DomainEvent;

public class CursoCreado extends DomainEvent {
    private final CursoId cursoId;
    private final TituloCurso tituloCurso;
    private final Profesor profesor;
    private final DescripcionCurso descripcionCurso;


    public CursoCreado(CursoId cursoId, Profesor profesor, TituloCurso tituloCurso, DescripcionCurso descripcionCurso) {
        super("sofka.curso.cursocreado");
        this.cursoId = cursoId;
        this.profesor = profesor;
        this.tituloCurso = tituloCurso;
        this.descripcionCurso = descripcionCurso;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public TituloCurso getTitulo() {
        return tituloCurso;
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public DescripcionCurso getDescripcion() {
        return descripcionCurso;
    }
}
