package co.com.sofka.Certificacion;

import co.com.sofka.Certificacion.events.CertificacionCreada;
import co.com.sofka.Certificacion.events.CompaniaCreada;
import co.com.sofka.Certificacion.events.HabilidadCreada;
import co.com.sofka.Certificacion.events.PosiblePuestoCreado;
import co.com.sofka.domain.generic.EventChange;

import java.util.HashSet;

public class CertificacionChange extends EventChange {
    public CertificacionChange(Certificacion certificacion){
        apply((CertificacionCreada event)->{
            certificacion.nombreCertificacion = event.getNombreCertificacion();
            certificacion.descripcionCertificacion = event.getDescripcionCertificacion();
            certificacion.cursoId = event.getCursoId();
            certificacion.estudianteId = event.getEstudianteId();
            certificacion.posiblePuesto = event.getPosiblePuesto();
            certificacion.companiaQueLoExpide = event.getCompaniaQueLoExpide();
            certificacion.habilidades = new HashSet<>();
        });

        apply((CompaniaCreada event)->{
            certificacion.companiaQueLoExpide.nombreCompania = event.getNombreCompania();
        });

        apply((HabilidadCreada event) -> {
            certificacion.habilidades.add(new Habilidad(
                    event.getHabilidadId(),
                    event.getNombreHabilidad(),
                    event.getDescripcionHabilidad()
            ));
        });

        apply((PosiblePuestoCreado event)->{
            certificacion.posiblePuesto.descripcionPosiblePuesto = event.getDescripcionPosiblePuesto();
        });
    }
}
