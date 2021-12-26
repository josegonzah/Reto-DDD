package co.com.sofka.usecase;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Estudiante.commands.CrearNota;

public class crearNotaUseCase extends UseCase<RequestCommand<CrearNota>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearNota> crearNotaRequestCommand) {
        var command = crearNotaRequestCommand.getCommand();
        var estudiante = Estudiante.from(command.getEstudianteId(), retrieveEvents(command.getEstudianteId().value()));
        estudiante.crearNota(
                command.getNotaId(),
                command.getEvaluadoNota(),
                command.getFeedbackNota()
        );

        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
