package co.com.sofka.Estudiante.commands;

import co.com.sofka.Estudiante.Values.EstudianteId;
import co.com.sofka.Estudiante.Values.EvaluadoNota;
import co.com.sofka.Estudiante.Values.FeedbackNota;
import co.com.sofka.domain.generic.Command;

public class CrearNota extends Command {
    private final EstudianteId estudianteId;
    private final EvaluadoNota evaluadoNota;
    private final FeedbackNota feedbackNota;

    public CrearNota(EstudianteId estudianteId, EvaluadoNota evaluadoNota, FeedbackNota feedbackNota) {
        this.estudianteId = estudianteId;
        this.evaluadoNota = evaluadoNota;
        this.feedbackNota = feedbackNota;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public EvaluadoNota getEvaluadoNota() {
        return evaluadoNota;
    }

    public FeedbackNota getFeedbackNota() {
        return feedbackNota;
    }
}
