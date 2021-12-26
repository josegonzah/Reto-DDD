package co.com.sofka.usecase;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;

public class crearInsigniaUseCase extends UseCase<RequestCommand<CrearInsignia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearInsignia> crearInsigniaRequestCommand) {
        var command = crearInsigniaRequestCommand.getCommand();
        var estudiante = Estudiante.from(command.getEstudianteId(), retrieveEvents(command.getEstudianteId().value()));
        estudiante.crearInsignia(
                command.getInsigniaId(),
                command.getRangoInsignia(),
                command.getDescripcionInsignia()
        );

        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
