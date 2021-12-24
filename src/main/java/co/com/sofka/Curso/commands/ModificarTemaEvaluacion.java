package co.com.sofka.Curso.commands;

import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.EvaluacionId;
import co.com.sofka.Curso.values.TemaEvaluacion;
import co.com.sofka.domain.generic.Command;

public class ModificarTemaEvaluacion extends Command {
    private final CursoId cursoId;
    private final EvaluacionId evaluacionId;
    private final TemaEvaluacion temaEvaluacion;

    public ModificarTemaEvaluacion(CursoId cursoId, EvaluacionId evaluacionId, TemaEvaluacion temaEvaluacion) {
        this.cursoId = cursoId;
        this.evaluacionId = evaluacionId;
        this.temaEvaluacion = temaEvaluacion;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public EvaluacionId getEvaluacionId() {
        return evaluacionId;
    }

    public TemaEvaluacion getTemaEvaluacion() {
        return temaEvaluacion;
    }
}
