package co.com.sofka.Curso;

import co.com.sofka.Curso.events.*;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;
import java.util.Set;

public class CursoChange extends EventChange {
    public CursoChange(Curso curso){
        apply((CursoCreado event)->{
            curso.titulo = event.getTitulo();
            curso.profesorId = event.getProfesorId();
            curso.descripcion = event.getDescripcion();
            curso.secciones = new HashSet<>();
            curso.evaluaciones = new HashSet<>();
        });

        apply((SeccionAgregada event)->{
            curso.secciones.add(new Seccion(
                    event.getSeccionId(),
                    event.getTituloSeccion(),
                    event.getDescripcionSeccion()
            ));
        });

        apply((EvaluacionCreada event)->{
            curso.evaluaciones.add(new Evaluacion(
                    event.getEvaluacionId(),
                    event.getTemaEvaluacion(),
                    event.getMetricaEvaluacion()
            ));
        });

        apply((ProfesorCreado event )->{
            curso.profesorId = event.getProfesorId();
        });

        apply((TituloCursoModificado event )->{
            curso.titulo = event.getTitulo();
        });

        apply((DescripcionCursoModificada event )->{
            curso.descripcion = event.getDescripcion();
        });

        apply((MetricaEvaluacionModificada event )->{
            var funcion = curso.getEvaluacionPorId(event.getEvaluacionId())
                    .orElseThrow(()-> new IllegalArgumentException("No se encuentra evaluacion"));
            funcion.ModificarMetrica(event.getMetricaEvaluacion());
        });

        apply((TemaEvaluacionModificado event )->{
            var funcion = curso.getEvaluacionPorId(event.getEvaluacionId())
                    .orElseThrow(()-> new IllegalArgumentException("No se encuentra evaluacion"));
            funcion.ModificarTema(event.getTemaEvaluacion());
        });

        apply((TituloSeccionModificada event )->{
            var funcion = curso.getSeccionPorId(event.getSeccionId())
                    .orElseThrow(()-> new IllegalArgumentException("No se encuentra seccion"));
            funcion.ModificarTituloSeccion(event.getTituloSeccion());
        });

        apply((DescripcionSeccionModificada event )->{
            var funcion = curso.getSeccionPorId(event.getSeccionId())
                    .orElseThrow(()-> new IllegalArgumentException("No se encuentra seccion"));
            funcion.ModificarDescripcionSeccion(event.getDescripcionSeccion());
        });

    }
}
