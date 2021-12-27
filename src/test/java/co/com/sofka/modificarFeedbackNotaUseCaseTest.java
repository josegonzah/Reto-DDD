package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Estudiante.Values.*;
import co.com.sofka.domain.Estudiante.commands.ModificarFeedbackNota;
import co.com.sofka.domain.Estudiante.events.EstudianteCreado;
import co.com.sofka.domain.Estudiante.events.FeedbackNotaModificado;
import co.com.sofka.domain.Estudiante.events.NotaCreada;
import co.com.sofka.usecase.modificarFeedbackNotaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class modificarFeedbackNotaUseCaseTest {
    private final String ROOTID = "145tr67";

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarFeedbackNota(){
        var command = new ModificarFeedbackNota(EstudianteId.of(ROOTID), NotaId.of("23er45"), new FeedbackNota("Hemos cambiado el feedback de esta nota para hacer la prueba unitaria"));
        var useCase = new modificarFeedbackNotaUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new EstudianteCreado(
                        EstudianteId.of(ROOTID),
                        CursoId.of("2343fff55"),
                        new EstadoCurso("Cursando"),
                        new NombreEstudiante("Jose David Gonzalez")
                ),
                new NotaCreada(NotaId.of("23er45"),
                        new EvaluadoNota(false),
                        new FeedbackNota("Se mandara de nuevo para revision la nota previamnete evaluada"))
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong while changing the clothes to the referee"))
                .getDomainEvents();

        var event = (FeedbackNotaModificado)events.get(0);
        Assertions.assertEquals("Hemos cambiado el feedback de esta nota para hacer la prueba unitaria", event.getFeedbackNota().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
