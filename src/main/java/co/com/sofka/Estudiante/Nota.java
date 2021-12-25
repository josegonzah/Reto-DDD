package co.com.sofka.Estudiante;

import co.com.sofka.Estudiante.Values.EvaluadoNota;
import co.com.sofka.Estudiante.Values.FeedbackNota;
import co.com.sofka.Estudiante.Values.NotaId;
import co.com.sofka.domain.generic.Entity;

public class Nota extends Entity<NotaId> {
    protected EvaluadoNota evaluadoNota;
    protected FeedbackNota feedbackNota;

    public Nota(NotaId entityId, EvaluadoNota evaluadoNota, FeedbackNota feedbackNota) {
        super(entityId);
        this.evaluadoNota = evaluadoNota;
        this.feedbackNota = feedbackNota;
    }

    public EvaluadoNota getEvaluadoNota() {
        return evaluadoNota;
    }

    public FeedbackNota getFeedbackNota() {
        return feedbackNota;
    }

    public void modificarFeedbackNota(FeedbackNota feedbackNota){
        this.feedbackNota = feedbackNota;
    }

    public void evaluarNota(EvaluadoNota evaluadoNota){
        this.evaluadoNota = evaluadoNota;
    }
}
