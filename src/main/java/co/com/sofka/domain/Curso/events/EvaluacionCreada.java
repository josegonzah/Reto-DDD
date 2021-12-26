package co.com.sofka.domain.Curso.events;

import co.com.sofka.domain.Curso.values.EvaluacionId;
import co.com.sofka.domain.Curso.values.MetricaEvaluacion;
import co.com.sofka.domain.Curso.values.TemaEvaluacion;
import co.com.sofka.domain.generic.DomainEvent;

public class EvaluacionCreada extends DomainEvent {
    private final EvaluacionId evaluacionId;
    private final TemaEvaluacion temaEvaluacion;
    private final MetricaEvaluacion metricaEvaluacion;


    public EvaluacionCreada(EvaluacionId evaluacionId, TemaEvaluacion temaEvaluacion, MetricaEvaluacion metricaEvaluacion) {
        super("sofka.curso.evaluacioncreada");
        this.evaluacionId = evaluacionId;
        this.temaEvaluacion = temaEvaluacion;
        this.metricaEvaluacion = metricaEvaluacion;
    }

    public EvaluacionId getEvaluacionId() {
        return evaluacionId;
    }

    public TemaEvaluacion getTemaEvaluacion() {
        return temaEvaluacion;
    }

    public MetricaEvaluacion getMetricaEvaluacion() {
        return metricaEvaluacion;
    }
}
