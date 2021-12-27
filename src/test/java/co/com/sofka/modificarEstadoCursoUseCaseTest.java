package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Estudiante.Values.EstadoCurso;
import co.com.sofka.domain.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.Estudiante.Values.NombreEstudiante;
import co.com.sofka.domain.Estudiante.commands.ModificarEstadoCurso;
import co.com.sofka.domain.Estudiante.events.EstadoCursoEstudianteModificado;
import co.com.sofka.domain.Estudiante.events.EstudianteCreado;
import co.com.sofka.usecase.modificarEstadoCursoUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class modificarEstadoCursoUseCaseTest {
    private final String ROOTID = "145tr67";

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarEstadoCurso(){
        var command = new ModificarEstadoCurso(EstudianteId.of(ROOTID), new EstadoCurso("Sin completar"));
        var useCase = new modificarEstadoCursoUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new EstudianteCreado(
                        EstudianteId.of(ROOTID),
                        CursoId.of("2343fff55"),
                        new EstadoCurso("Cursando"),
                        new NombreEstudiante("Jose David Gonzalez")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("No se pudo cambiar estado del curso"))
                .getDomainEvents();
        var event = (EstadoCursoEstudianteModificado)events.get(0);
        Assertions.assertEquals("Sin completar", event.getEstadoCurso().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
