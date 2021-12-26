package co.com.sofka.Curso;

import co.com.sofka.Curso.events.*;
import co.com.sofka.Curso.values.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Curso  extends AggregateEvent<CursoId> {
    protected Profesor profesor;
    protected TituloCurso tituloCurso;
    protected DescripcionCurso descripcionCurso;
    protected HashSet<Seccion> secciones;
    protected HashSet<Evaluacion> evaluaciones;

    public Curso(CursoId entityId, Profesor profesor, TituloCurso tituloCurso, DescripcionCurso descripcionCurso) {
        super(entityId);
        this.profesor = profesor;
        this.tituloCurso = tituloCurso;
        this.descripcionCurso = descripcionCurso;
    }

    private Curso(CursoId entityId) {
        super(entityId);
        subscribe(new CursoChange(this));
    }

    public static Curso from(CursoId cursoId, List<DomainEvent> events) {
        var curso = new Curso(cursoId);
        events.forEach(curso::applyEvent);
        return curso;
    }

    public void agregarSeccion(SeccionId seccionId, TituloSeccion tituloSeccion, DescripcionSeccion descripcionSeccion){
        appendChange(new SeccionAgregada(seccionId, tituloSeccion, descripcionSeccion)).apply();
    }

    public void crearProfesor(ProfesorId profesorId, NombreProfesor nombreProfesor){
        appendChange(new ProfesorCreado(profesorId, nombreProfesor)).apply();
    }

    public void crearEvaluacion(EvaluacionId evaluacionId, TemaEvaluacion temaEvaluacion, MetricaEvaluacion metricaEvaluacion){
        appendChange(new EvaluacionCreada(evaluacionId, temaEvaluacion, metricaEvaluacion)).apply();
    }

    public void modificarTituloCurso(CursoId cursoId, TituloCurso tituloCurso){
        appendChange(new TituloCursoModificado(cursoId, tituloCurso)).apply();
    }

    public void modificarDescripcionCurso(CursoId cursoId, DescripcionCurso descripcionCurso){
        appendChange(new DescripcionCursoModificada(cursoId, descripcionCurso)).apply();
    }

    public void modificarMetricaEvaluacion(EvaluacionId evaluacionId, MetricaEvaluacion metricaEvaluacion){
        appendChange(new MetricaEvaluacionModificada(evaluacionId, metricaEvaluacion)).apply();
    }

    public void modificarTemaEvaluacion(EvaluacionId evaluacionId, TemaEvaluacion temaEvaluacion){
        appendChange(new TemaEvaluacionModificado(evaluacionId, temaEvaluacion)).apply();
    }

    public void modificarNombreProfesor(ProfesorId profesorId, NombreProfesor nombreProfesor){
        appendChange(new NombreProfesorModificado(profesorId, nombreProfesor)).apply();
    }

    public void modificarTituloSeccion(SeccionId seccionId, TituloSeccion tituloSeccion){
        appendChange(new TituloSeccionModificada(seccionId, tituloSeccion)).apply();
    }

    public void modificarDescripcionSeccion(SeccionId seccionId, DescripcionSeccion descripcionSeccion){
        appendChange(new DescripcionSeccionModificada(seccionId, descripcionSeccion)).apply();
    }

    public Optional<Seccion> getSeccionPorId(SeccionId seccionId){
        return secciones
                .stream()
                .filter(seccion -> seccion.identity().equals(seccionId))
                .findFirst();
    }

    public Optional<Evaluacion> getEvaluacionPorId(EvaluacionId evaluacionId){
        return evaluaciones
                .stream()
                .filter(evaluacion -> evaluacion.identity().equals(evaluacionId))
                .findFirst();
    }

    public Profesor getProfesor() {
        return profesor;
    }

    public TituloCurso TituloCurso() {
        return tituloCurso;
    }

    public DescripcionCurso Descripcion() {
        return descripcionCurso;
    }

    public Set<Seccion> Secciones() {
        return secciones;
    }

    public Set<Evaluacion> Evaluaciones() {
        return evaluaciones;
    }
}
