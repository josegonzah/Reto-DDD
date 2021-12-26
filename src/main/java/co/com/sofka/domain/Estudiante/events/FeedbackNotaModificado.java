package co.com.sofka.domain.Estudiante.events;

import co.com.sofka.domain.Estudiante.Values.FeedbackNota;
import co.com.sofka.domain.Estudiante.Values.NotaId;
import co.com.sofka.domain.generic.DomainEvent;

public class FeedbackNotaModificado extends DomainEvent {
    private final NotaId notaId;
    private final FeedbackNota feedbackNota;

    public FeedbackNotaModificado(NotaId notaId, FeedbackNota feedbackNota) {
        super("sofka.estudiante.feedbacknotamodificado");
        this.notaId = notaId;
        this.feedbackNota = feedbackNota;
    }

    public NotaId getNotaId() {
        return notaId;
    }

    public FeedbackNota getFeedbackNota() {
        return feedbackNota;
    }
}
