package co.com.sofka.usecase;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Estudiante.commands.ModificarDescripcionInsignia;
import co.com.sofka.domain.Estudiante.commands.ModificarEstadoMeta;
import co.com.sofka.domain.Estudiante.commands.ModificarFeedbackNota;

public class modificarFeedbackNotaUseCase extends UseCase<RequestCommand<ModificarFeedbackNota>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarFeedbackNota> modificarFeedbackNotaRequestCommand) {
        var command = modificarFeedbackNotaRequestCommand.getCommand();
        var estudiante = Estudiante.from(command.getEstudianteId(), retrieveEvents(command.getEstudianteId().value()));
        estudiante.modificarFeedbackNota(
                command.getNotaId(),
                command.getFeedbackNota()
        );

        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
