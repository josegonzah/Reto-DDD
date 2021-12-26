package co.com.sofka.domain.Estudiante.commands;

import co.com.sofka.domain.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.Estudiante.Values.FeedbackNota;
import co.com.sofka.domain.Estudiante.Values.NotaId;
import co.com.sofka.domain.generic.Command;

public class ModificarFeedbackNota extends Command {
    private final EstudianteId estudianteId;
    private final NotaId notaId;
    private final FeedbackNota feedbackNota;

    public ModificarFeedbackNota(EstudianteId estudianteId, NotaId notaId, FeedbackNota feedbackNota) {
        this.estudianteId = estudianteId;
        this.notaId = notaId;
        this.feedbackNota = feedbackNota;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public NotaId getNotaId() {
        return notaId;
    }

    public FeedbackNota getFeedbackNota() {
        return feedbackNota;
    }


}
