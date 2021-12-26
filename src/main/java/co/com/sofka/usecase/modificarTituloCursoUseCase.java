package co.com.sofka.usecase;

import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.domain.Curso.Curso;
import co.com.sofka.domain.Curso.commands.ModificarTituloCurso;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Estudiante.commands.ModificarDescripcionInsignia;
import co.com.sofka.domain.Estudiante.commands.ModificarEstadoMeta;

public class modificarTituloCursoUseCase extends UseCase<RequestCommand<ModificarTituloCurso>, ResponseEvents> {

    @Override
    public void executeUseCase(RequestCommand<ModificarTituloCurso> modificarTituloRequestCommand) {
        var command = modificarTituloRequestCommand.getCommand();
        var curso = Curso.from(command.getCursoId(), retrieveEvents(command.getCursoId().value()));
        curso.modificarTituloCurso(
                command.getCursoId(),
                command.getTitulo()
        );

        emit().onResponse(new ResponseEvents(curso.getUncommittedChanges()));
    }
}
