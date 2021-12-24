package co.com.sofka.Estudiante.events;

import co.com.sofka.Estudiante.Values.EvaluadoNota;
import co.com.sofka.Estudiante.Values.FeedbackNota;
import co.com.sofka.Estudiante.Values.NotaId;
import co.com.sofka.domain.generic.DomainEvent;

public class NotaCreada extends DomainEvent {
    private final NotaId notaId;
    private final EvaluadoNota evaluadoNota;
    private final FeedbackNota feedbackNota;


    public NotaCreada(NotaId notaId, EvaluadoNota evaluadoNota, FeedbackNota feedbackNota) {
        super("sofka.estudiante.notacreada");
        this.notaId = notaId;
        this.evaluadoNota = evaluadoNota;
        this.feedbackNota = feedbackNota;
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
