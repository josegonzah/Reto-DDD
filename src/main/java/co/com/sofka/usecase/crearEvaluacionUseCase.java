package co.com.sofka.usecase;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Curso.Curso;
import co.com.sofka.domain.Curso.commands.CrearEvaluacion;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;

public class crearEvaluacionUseCase extends UseCase<RequestCommand<CrearEvaluacion>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<CrearEvaluacion> crearEvaluacionRequestCommand) {
        var command = crearEvaluacionRequestCommand.getCommand();
        var curso = Curso.from(command.getCursoId(), retrieveEvents(command.getCursoId().value()));
        curso.crearEvaluacion(
                command.getEvaluacionId(),
                command.getTemaEvaluacion(),
                command.getMetricaEvaluacion()
        );

        emit().onResponse(new ResponseEvents(curso.getUncommittedChanges()));
    }
}