package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Estudiante.Nota;
import co.com.sofka.domain.Estudiante.Values.*;
import co.com.sofka.domain.Estudiante.commands.CrearMeta;
import co.com.sofka.domain.Estudiante.commands.CrearNota;
import co.com.sofka.domain.Estudiante.events.EstudianteCreado;
import co.com.sofka.domain.Estudiante.events.MetaCreada;
import co.com.sofka.domain.Estudiante.events.NotaCreada;
import co.com.sofka.usecase.crearMetaUseCase;
import co.com.sofka.usecase.crearNotaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class crearNotaUseCaseTest {
    private final String ROOTID = "123ddf667";

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearNotaTest(){
        var command = new CrearNota(EstudianteId.of(ROOTID), NotaId.of("1234fff55"), new EvaluadoNota(false), new FeedbackNota("Aun no hay feedback, no esta evaluado el estudiante todavia"));
        var useCase = new crearNotaUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new EstudianteCreado(
                        new EstudianteId("2343fff33"),
                        new CursoId("2343fff55"),
                        new EstadoCurso("Cursando"),
                        new NombreEstudiante("Jose David Gonzalez")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("No se pudo crear la nota"))
                .getDomainEvents();


        var event = (NotaCreada)events.get(0);
        Assertions.assertEquals(false, event.getEvaluadoNota().value());
        Assertions.assertEquals("Aun no hay feedback, no esta evaluado el estudiante todavia", event.getFeedbackNota().value());
        Mockito.verify(repository).getEventsBy(ROOTID);

    }
}
