package co.com.sofka.Certificacion;

import co.com.sofka.Certificacion.Values.*;
import co.com.sofka.Certificacion.events.CompaniaCreada;
import co.com.sofka.Certificacion.events.HabilidadCreada;
import co.com.sofka.Certificacion.events.PosiblePuestoCreado;
import co.com.sofka.Curso.CursoChange;
import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.generic.AggregateEvent;
import co.com.sofka.domain.generic.DomainEvent;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;

public class Certificacion extends AggregateEvent<CertificacionId> {
    protected NombreCertificacion nombreCertificacion;
    protected DescripcionCertificacion descripcionCertificacion;
    protected HashSet<Habilidad> habilidades;
    protected CursoId cursoId;
    protected EstudianteId estudianteId;
    protected PosiblePuesto posiblePuesto;
    protected CompaniaQueLoExpide companiaQueLoExpide;

    public Certificacion(CertificacionId entityId, NombreCertificacion nombreCertificacion, DescripcionCertificacion descripcionCertificacion, CursoId cursoId, EstudianteId estudianteId, PosiblePuesto posiblePuesto, CompaniaQueLoExpide companiaQueLoExpide) {
        super(entityId);
        this.nombreCertificacion = nombreCertificacion;
        this.descripcionCertificacion = descripcionCertificacion;
        this.cursoId = cursoId;
        this.estudianteId = estudianteId;
        this.posiblePuesto = posiblePuesto;
        this.companiaQueLoExpide = companiaQueLoExpide;
    }

    private Certificacion(CertificacionId entityId){
        super(entityId);
        subscribe(new CertificacionChange(this));
    }

    public static Certificacion from(CertificacionId certificacionId, List<DomainEvent> events){
        var certificacion = new Certificacion(certificacionId);
        events.forEach(certificacion::applyEvent);
        return certificacion;
    }

    public void crearCompañia(CompaniaQueLoExpideId companiaQueLoExpideId, NombreCompania nombreCompania){
        appendChange(new CompaniaCreada(companiaQueLoExpideId, nombreCompania));
    }

    public void crearHabilidad(HabilidadId habilidadId, NombreHabilidad nombreHabilidad, DescripcionHabilidad descripcionHabilidad){
        appendChange(new HabilidadCreada(habilidadId, nombreHabilidad, descripcionHabilidad));
    }

    public void crearPosiblePuesto(PosiblePuestoId posiblePuestoId, DescripcionPosiblePuesto descripcionPosiblePuesto){
        appendChange(new PosiblePuestoCreado(posiblePuestoId, descripcionPosiblePuesto));
    }

    public Optional<Habilidad> getHabilidadPorId(HabilidadId habilidadId){
        return habilidades
                .stream()
                .filter(habilidad -> habilidad.identity().equals(habilidadId))
                .findFirst();
    }

    public NombreCertificacion nombreCertificacion() {
        return nombreCertificacion;
    }

    public DescripcionCertificacion descripcionCertificacion() {
        return descripcionCertificacion;
    }

    public HashSet<Habilidad> habilidades() {
        return habilidades;
    }

    public CursoId cursoId() {
        return cursoId;
    }

    public EstudianteId estudianteId() {
        return estudianteId;
    }

    public PosiblePuesto posiblePuesto() {
        return posiblePuesto;
    }

    public CompaniaQueLoExpide companiaQueLoExpide() {
        return companiaQueLoExpide;
    }
}
