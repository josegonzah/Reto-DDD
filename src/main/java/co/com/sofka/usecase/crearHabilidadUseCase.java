package co.com.sofka.usecase;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Certificacion.Certificacion;
import co.com.sofka.domain.Certificacion.commands.CrearHabilidad;
import co.com.sofka.domain.Curso.Curso;
import co.com.sofka.domain.Curso.commands.CrearEvaluacion;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;

public class crearHabilidadUseCase extends UseCase<RequestCommand<CrearHabilidad>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearHabilidad> crearHabilidadRequestCommand) {
        var command = crearHabilidadRequestCommand.getCommand();
        var certificacion = Certificacion.from(command.getCertificacionId(), retrieveEvents(command.getCertificacionId().value()));
        certificacion.crearHabilidad(
                command.getHabilidadId(),
                command.getNombreHabilidad(),
                command.getDescripcionHabilidad()
        );

        emit().onResponse(new ResponseEvents(certificacion.getUncommittedChanges()));
    }
}