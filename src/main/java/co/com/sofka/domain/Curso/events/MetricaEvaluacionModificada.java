package co.com.sofka.domain.Curso.events;

import co.com.sofka.domain.Curso.values.EvaluacionId;
import co.com.sofka.domain.Curso.values.MetricaEvaluacion;
import co.com.sofka.domain.generic.DomainEvent;

public class MetricaEvaluacionModificada extends DomainEvent {
    private final EvaluacionId evaluacionId;
    private final MetricaEvaluacion metricaEvaluacion;

    public MetricaEvaluacionModificada(EvaluacionId cursoId, MetricaEvaluacion metricaEvaluacion) {
        super("sofka.curso.metricaevaluacionevaluada");
        this.evaluacionId = cursoId;
        this.metricaEvaluacion = metricaEvaluacion;
    }

    public EvaluacionId getEvaluacionId() {
        return evaluacionId;
    }

    public MetricaEvaluacion getMetricaEvaluacion() {
        return metricaEvaluacion;
    }
}
