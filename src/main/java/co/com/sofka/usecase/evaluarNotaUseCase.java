package co.com.sofka.usecase;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Estudiante.commands.EvaluarNota;

public class evaluarNotaUseCase extends UseCase<RequestCommand<EvaluarNota>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<EvaluarNota> evaluarNotaRequestCommand) {
        var command = evaluarNotaRequestCommand.getCommand();
        var estudiante = Estudiante.from(command.getEstudianteId(), retrieveEvents(command.getEstudianteId().value()));
        estudiante.modificarNotaEvaluada(
                command.getNotaId(),
                command.getEvaluadoNota()
        );

        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
