package co.com.sofka.domain.Estudiante.events;

import co.com.sofka.domain.Estudiante.Values.EvaluadoNota;
import co.com.sofka.domain.Estudiante.Values.NotaId;
import co.com.sofka.domain.generic.DomainEvent;

public class NotaEvaluada extends DomainEvent {
    private final NotaId notaId;
    private final EvaluadoNota evaluadoNota;

    public NotaEvaluada(NotaId notaId, EvaluadoNota evaluadoNota) {
        super("sofka.estudiante.notaevaluada");
        this.notaId = notaId;
        this.evaluadoNota = evaluadoNota;
    }

    public NotaId getNotaId() {
        return notaId;
    }

    public EvaluadoNota getEvaluadoNota() {
        return evaluadoNota;
    }
}
