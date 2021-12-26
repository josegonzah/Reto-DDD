package co.com.sofka.domain.Curso.commands;

import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Curso.values.EvaluacionId;
import co.com.sofka.domain.Curso.values.MetricaEvaluacion;
import co.com.sofka.domain.generic.Command;

public class ModificarMetricaEvaluacion extends Command {
    private final CursoId cursoId;
    private final EvaluacionId evaluacionId;
    private final MetricaEvaluacion metricaEvaluacion;

    public ModificarMetricaEvaluacion(CursoId cursoId, EvaluacionId evaluacionId, MetricaEvaluacion metricaEvaluacion) {
        this.cursoId = cursoId;
        this.evaluacionId = evaluacionId;
        this.metricaEvaluacion = metricaEvaluacion;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public EvaluacionId getEvaluacionId() {
        return evaluacionId;
    }

    public MetricaEvaluacion getMetricaEvaluacion() {
        return metricaEvaluacion;
    }
}
