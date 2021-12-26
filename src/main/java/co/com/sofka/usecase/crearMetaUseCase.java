package co.com.sofka.usecase;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Estudiante.commands.CrearMeta;

public class crearMetaUseCase extends UseCase<RequestCommand<CrearMeta>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearMeta> crearMetaRequestCommand) {
        var command = crearMetaRequestCommand.getCommand();
        var estudiante = Estudiante.from(command.getEstudianteId(), retrieveEvents(command.getEstudianteId().value()));
        estudiante.crearMeta(
                command.getMetaId(),
                command.getEstadoMeta(),
                command.getDescripcionMeta()
        );

        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}