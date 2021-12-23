package co.com.sofka.Curso;

import co.com.sofka.Curso.values.EvaluacionId;
import co.com.sofka.Curso.values.MetricaEvaluacion;
import co.com.sofka.Curso.values.TemaEvaluacion;
import co.com.sofka.domain.generic.Entity;

public class Evaluacion extends Entity<EvaluacionId> {
    protected TemaEvaluacion temaEvaluacion;
    protected MetricaEvaluacion metricaEvaluacion;

    public Evaluacion(EvaluacionId entityId, TemaEvaluacion temaEvaluacion, MetricaEvaluacion metricaEvaluacion) {
        super(entityId);
        this.temaEvaluacion = temaEvaluacion;
        this.metricaEvaluacion = metricaEvaluacion;
    }

    public void ModificarMetrica(MetricaEvaluacion metricaEvaluacion){
        this.metricaEvaluacion = metricaEvaluacion;
    }

    public void ModificarTema(TemaEvaluacion temaEvaluacion){
        this.temaEvaluacion = temaEvaluacion;
    }

    public TemaEvaluacion temaEvaluacion() {
        return temaEvaluacion;
    }

    public MetricaEvaluacion metricaEvaluacion() {
        return metricaEvaluacion;
    }
}
