package co.com.sofka.usecase;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Estudiante.commands.ModificarDescripcionInsignia;
import co.com.sofka.domain.Estudiante.commands.ModificarEstadoCurso;

public class modificarEstadoCursoUseCase extends UseCase<RequestCommand<ModificarEstadoCurso>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarEstadoCurso> modificarEstadoCursoRequestCommand) {
        var command = modificarEstadoCursoRequestCommand.getCommand();
        var estudiante = Estudiante.from(command.getEstudianteId(), retrieveEvents(command.getEstudianteId().value()));
        estudiante.modificarEstadoCursoEstudiante(
                command.getEstudianteId(),
                command.getEstadoCurso()
        );

        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
