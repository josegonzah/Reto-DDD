package co.com.sofka.usecase;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Estudiante.commands.ModificarDescripcionInsignia;

public class modificarDescripcionInsigniaUseCase extends UseCase<RequestCommand<ModificarDescripcionInsignia>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarDescripcionInsignia> modificarDescripcionInsigniaRequestCommand) {
        var command = modificarDescripcionInsigniaRequestCommand.getCommand();
        var estudiante = Estudiante.from(command.getEstudianteId(), retrieveEvents(command.getEstudianteId().value()));
        estudiante.modificarDescripcionInsignia(
                command.getInsigniaId(),
                command.getDescripcionInsignia()
        );

        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}