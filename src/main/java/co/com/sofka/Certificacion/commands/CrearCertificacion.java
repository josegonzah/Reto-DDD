package co.com.sofka.Certificacion.commands;

import co.com.sofka.Certificacion.CompaniaQueLoExpide;
import co.com.sofka.Certificacion.PosiblePuesto;
import co.com.sofka.Certificacion.Values.CertificacionId;
import co.com.sofka.Certificacion.Values.DescripcionCertificacion;
import co.com.sofka.Certificacion.Values.NombreCertificacion;
import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.generic.Command;

public class CrearCertificacion extends Command {
    private final CertificacionId certificacionId;
    private final NombreCertificacion nombreCertificacion;
    private final DescripcionCertificacion descripcionCertificacion;
    private final CursoId cursoId;
    private final EstudianteId estudianteId;
    private final PosiblePuesto posiblePuesto;
    private final CompaniaQueLoExpide companiaQueLoExpide;

    public CrearCertificacion(CertificacionId certificacionId, NombreCertificacion nombreCertificacion, DescripcionCertificacion descripcionCertificacion, CursoId cursoId, EstudianteId estudianteId, PosiblePuesto posiblePuesto, CompaniaQueLoExpide companiaQueLoExpide) {
        this.certificacionId = certificacionId;
        this.nombreCertificacion = nombreCertificacion;
        this.descripcionCertificacion = descripcionCertificacion;
        this.cursoId = cursoId;
        this.estudianteId = estudianteId;
        this.posiblePuesto = posiblePuesto;
        this.companiaQueLoExpide = companiaQueLoExpide;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }

    public NombreCertificacion getNombreCertificacion() {
        return nombreCertificacion;
    }

    public DescripcionCertificacion getDescripcionCertificacion() {
        return descripcionCertificacion;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public EstudianteId getEstudianteId() {
        return estudianteId;
    }

    public PosiblePuesto getPosiblePuesto() {
        return posiblePuesto;
    }

    public CompaniaQueLoExpide getCompaniaQueLoExpide() {
        return companiaQueLoExpide;
    }
}
