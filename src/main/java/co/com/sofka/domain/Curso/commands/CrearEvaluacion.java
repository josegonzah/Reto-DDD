package co.com.sofka.domain.Curso.commands;

import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Curso.values.EvaluacionId;
import co.com.sofka.domain.Curso.values.MetricaEvaluacion;
import co.com.sofka.domain.Curso.values.TemaEvaluacion;
import co.com.sofka.domain.generic.Command;

public class CrearEvaluacion extends Command {
    private final CursoId cursoId;
    private final EvaluacionId evaluacionId;
    private final TemaEvaluacion temaEvaluacion;
    private final MetricaEvaluacion metricaEvaluacion;


    public CrearEvaluacion(CursoId cursoId, EvaluacionId evaluacionId, TemaEvaluacion temaEvaluacion, MetricaEvaluacion metricaEvaluacion) {
        this.cursoId = cursoId;
        this.evaluacionId = evaluacionId;
        this.temaEvaluacion = temaEvaluacion;
        this.metricaEvaluacion = metricaEvaluacion;
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

    public MetricaEvaluacion getMetricaEvaluacion() {
        return metricaEvaluacion;
    }
}
