package co.com.sofka.Estudiante;

import co.com.sofka.Curso.Curso;
import co.com.sofka.Curso.CursoChange;
import co.com.sofka.Curso.Evaluacion;
import co.com.sofka.Curso.Seccion;
import co.com.sofka.Curso.events.*;
import co.com.sofka.Curso.values.*;
import co.com.sofka.Curso.values.Nombre;
import co.com.sofka.Estudiante.Values.*;
import co.com.sofka.Estudiante.events.*;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

public class Estudiante extends AggregateEvent<EstudianteId> {
    protected NombreEstudiante nombreEstudiante;
    protected CursoId cursoId;
    protected EstadoCurso estadoCurso;
    protected HashSet<Insignia> insignias;
    protected HashSet<Meta> metas;
    protected HashSet<Nota> notas;

    public Estudiante(EstudianteId entityId, NombreEstudiante nombreEstudiante, CursoId cursoId, EstadoCurso estadoCurso, HashSet<Insignia> insignias, HashSet<Meta> metas, HashSet<Nota> notas) {
        super(entityId);
        this.nombreEstudiante = nombreEstudiante;
        this.cursoId = cursoId;
        this.estadoCurso = estadoCurso;
        this.insignias = insignias;
        this.metas = metas;
        this.notas = notas;
    }

    private Estudiante(EstudianteId entityId) {
        super(entityId);
        subscribe(new CursoChange(this));
    }

    public static Estudiante from(EstudianteId estudianteId, List<DomainEvent> events) {
        var estudiante = new Estudiante(estudianteId);
        events.forEach(estudiante::applyEvent);
        return estudiante;
    }

    public void crearInsignia(InsigniaId insigniaId, RangoInsignia rangoInsignia, DescripcionInsignia descripcionInsignia){
        appendChange(new InsigniaCreada(insigniaId, rangoInsignia, descripcionInsignia)).apply();
    }

    public void crearMeta(MetaId metaId, EstadoMeta estadoMeta, DescripcionMeta descripcionMeta){
        appendChange(new MetaCreada(metaId, estadoMeta, descripcionMeta)).apply();
    }

    public void crearNota(NotaId notaId, EvaluadoNota evaluadoNota, FeedbackNota feedbackNota){
        appendChange(new NotaCreada(notaId, evaluadoNota, feedbackNota)).apply();
    }

    public void modificarDescripcionInsignia(InsigniaId insigniaId, DescripcionInsignia descripcionInsignia){
        appendChange(new DescripcionInsigniaModificada(insigniaId, descripcionInsignia)).apply();
    }

    public void modificarEstadoMeta(MetaId metaId, EstadoMeta estadoMeta){
        appendChange(new EstadoMetaModificado(metaId, estadoMeta)).apply();
    }

    public void modificarNotaEvaluada(NotaId notaId, EvaluadoNota evaluadoNota){
        appendChange(new NotaEvaluada(notaId, evaluadoNota)).apply();
    }

    public void modificarFeedbackNota(NotaId notaId, FeedbackNota feedbackNota){
        appendChange(new FeedbackNotaModificado(notaId, feedbackNota)).apply();
    }

    public void modificarEstadoCursoEstudiante(EstudianteId estudianteId, EstadoCurso estadoCurso){
        appendChange(new EstadoCursoEstudianteModificado(estudianteId, estadoCurso)).apply();
    }


    public Optional<Insignia> getInsigniaPorId(InsigniaId insigniaId){
        return insignias
                .stream()
                .filter(seccion -> seccion.identity().equals(insigniaId))
                .findFirst();
    }

    public Optional<Meta> getMetaPorId(MetaId metaId){
        return metas
                .stream()
                .filter(evaluacion -> evaluacion.identity().equals(metaId))
                .findFirst();
    }

    public Optional<Nota> NotaPorId(NotaId notaId){
        return notas
                .stream()
                .filter(evaluacion -> evaluacion.identity().equals(notaId))
                .findFirst();
    }

    public NombreEstudiante nombreEstudiante() {
        return nombreEstudiante;
    }

    public CursoId cursoId() {
        return cursoId;
    }

    public EstadoCurso estadoCurso() {
        return estadoCurso;
    }

    public HashSet<Insignia> insignias() {
        return insignias;
    }

    public HashSet<Meta> metas() {
        return metas;
    }

    public HashSet<Nota> notas() {
        return notas;
    }
}
