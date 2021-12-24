package co.com.sofka.Estudiante.commands;

import co.com.sofka.Estudiante.Values.EstudianteId;
import co.com.sofka.Estudiante.Values.EvaluadoNota;
import co.com.sofka.Estudiante.Values.NotaId;
import co.com.sofka.domain.generic.Command;

public class EvaluarNota extends Command {
    private final EstudianteId estudianteId;
    private final NotaId notaId;
    private final EvaluadoNota evaluadoNota;

    public EvaluarNota(EstudianteId estudianteId, NotaId notaId, EvaluadoNota evaluadoNota) {
        this.estudianteId = estudianteId;
        this.notaId = notaId;
        this.evaluadoNota = evaluadoNota;
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
}
