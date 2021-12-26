package co.com.sofka.domain.Estudiante.commands;

import co.com.sofka.domain.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.Estudiante.Values.EvaluadoNota;
import co.com.sofka.domain.Estudiante.Values.FeedbackNota;
import co.com.sofka.domain.Estudiante.Values.NotaId;
import co.com.sofka.domain.generic.Command;

public class CrearNota extends Command {
    private final EstudianteId estudianteId;
    private final NotaId notaId;
    private final EvaluadoNota evaluadoNota;
    private final FeedbackNota feedbackNota;

    public CrearNota(EstudianteId estudianteId, NotaId notaId, EvaluadoNota evaluadoNota, FeedbackNota feedbackNota) {
        this.estudianteId = estudianteId;
        this.notaId = notaId;
        this.evaluadoNota = evaluadoNota;
        this.feedbackNota = feedbackNota;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public NotaId getNotaId() {
        return notaId;
    }

    public EvaluadoNota getEvaluadoNota() {
        return evaluadoNota;
    }

    public FeedbackNota getFeedbackNota() {
        return feedbackNota;
    }
}
