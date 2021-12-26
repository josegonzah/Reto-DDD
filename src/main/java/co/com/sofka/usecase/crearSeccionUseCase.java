package co.com.sofka.usecase;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Curso.Curso;
import co.com.sofka.domain.Curso.commands.AgregarSeccion;
import co.com.sofka.domain.Curso.commands.CrearSeccion;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;

public class crearSeccionUseCase extends UseCase<RequestCommand<AgregarSeccion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<AgregarSeccion> agregarSeccionRequestCommand) {
        var command = agregarSeccionRequestCommand.getCommand();
        var curso = Curso.from(command.getCursoId(), retrieveEvents(command.getCursoId().value()));
        curso.agregarSeccion(
                command.getSeccionId(),
                command.getTituloSeccion(),
                command.getDescripcionSeccion()
        );

        emit().onResponse(new ResponseEvents(curso.getUncommittedChanges()));
    }
}
