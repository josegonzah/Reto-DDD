package co.com.sofka.domain.Estudiante;

import co.com.sofka.domain.Estudiante.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class EstudianteChange extends EventChange {
    public EstudianteChange(Estudiante estudiante){
        apply((EstudianteCreado event)->{
            estudiante.nombreEstudiante = event.getNombreEstudiante();
            estudiante.cursoId = event.getCursoId();
            estudiante.estadoCurso = event.getEstadoCurso();
            estudiante.insignias = new HashSet<>();
            estudiante.metas = new HashSet<>();
            estudiante.notas = new HashSet<>();
        });

        apply((MetaCreada event)->{
            estudiante.metas.add(new Meta(
                    event.getMetaId(),
                    event.getEstadoMeta(),
                    event.getDescripcionMeta()
            ));
        });

        apply((NotaCreada event) -> {
            estudiante.notas.add(new Nota(
                    event.getNotaId(),
                    event.getEvaluadoNota(),
                    event.getFeedbackNota()
            ));
        });

        apply((InsigniaCreada event) -> {
            estudiante.insignias.add(new Insignia(
                    event.getInsigniaId(),
                    event.getRangoInsignia(),
                    event.getDescripcionInsignia()
            ));
        });

        apply((EstadoCursoEstudianteModificado event) -> {
            estudiante.estadoCurso = event.getEstadoCurso();
        });

        apply((DescripcionInsigniaModificada event) -> {
            var funcion = estudiante.getInsigniaPorId(event.getInsigniaId())
                    .orElseThrow(()-> new IllegalArgumentException("No se encuentra insignia"));
            funcion.modificarDescripcionInsignia(event.getDescripcionInsignia());
        });

        apply((EstadoMetaModificado event) -> {
            var funcion = estudiante.getMetaPorId(event.getMetaId())
                    .orElseThrow(()-> new IllegalArgumentException("No se encuentra meta"));
            funcion.modificarEstadoMeta(event.getEstadoMeta());
        });

        apply((FeedbackNotaModificado event) -> {
            var funcion = estudiante.getNotaPorId(event.getNotaId())
                    .orElseThrow(()-> new IllegalArgumentException("No se encuentra la nota"));
            funcion.modificarFeedbackNota(event.getFeedbackNota());
        });

        apply((NotaEvaluada event) -> {
            var funcion = estudiante.getNotaPorId(event.getNotaId())
                    .orElseThrow(()-> new IllegalArgumentException("No se encuentra la nota"));
            funcion.evaluarNota(event.getEvaluadoNota());
        });
    }
}
