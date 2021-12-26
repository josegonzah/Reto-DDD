package co.com.sofka.usecase;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Estudiante.commands.ModificarDescripcionInsignia;
import co.com.sofka.domain.Estudiante.commands.ModificarEstadoMeta;

public class modificarEstadoMetaUseCase extends UseCase<RequestCommand<ModificarEstadoMeta>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarEstadoMeta> modificarEstadoMetaRequestCommand) {
        var command = modificarEstadoMetaRequestCommand.getCommand();
        var estudiante = Estudiante.from(command.getEstudianteId(), retrieveEvents(command.getEstudianteId().value()));
        estudiante.modificarEstadoMeta(
                command.getMetaId(),
                command.getEstadoMeta()
        );

        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}