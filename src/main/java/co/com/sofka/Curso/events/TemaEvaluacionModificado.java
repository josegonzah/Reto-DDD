package co.com.sofka.Curso.events;

import co.com.sofka.Curso.values.EvaluacionId;
import co.com.sofka.Curso.values.TemaEvaluacion;
import co.com.sofka.domain.generic.DomainEvent;

public class TemaEvaluacionModificado extends DomainEvent {
    private final EvaluacionId evaluacionId;
    private final TemaEvaluacion temaEvaluacion;


    public TemaEvaluacionModificado(EvaluacionId evaluacionId, TemaEvaluacion temaEvaluacion) {
        super("sofka.curso.temaevaluacionmodificado");
        this.evaluacionId = evaluacionId;
        this.temaEvaluacion = temaEvaluacion;
    }

    public EvaluacionId getEvaluacionId() {
        return evaluacionId;
    }

    public TemaEvaluacion getTemaEvaluacion() {
        return temaEvaluacion;
    }
}
