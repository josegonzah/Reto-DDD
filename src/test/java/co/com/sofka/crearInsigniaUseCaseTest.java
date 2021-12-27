package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Estudiante.Values.*;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.domain.Estudiante.events.EstudianteCreado;
import co.com.sofka.domain.Estudiante.events.InsigniaCreada;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.usecase.crearInsigniaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class crearInsigniaUseCaseTest {
    private final String ROOTID = "123ddf667";

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearInsigniaTest(){
        var command = new CrearInsignia(EstudianteId.of(ROOTID), InsigniaId.of("1234fff55"), new RangoInsignia(2), new DescripcionInsignia("La siguiente insignia certifica que el estudiante realizo nivel 1 de ethical hacking"));
        var useCase = new crearInsigniaUseCase();

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
                .orElseThrow(()->new IllegalArgumentException("No se pudo crear la insignia"))
                .getDomainEvents();


        var event = (InsigniaCreada)events.get(0);
        Assertions.assertEquals(2, event.getRangoInsignia().value());
        Assertions.assertEquals("La siguiente insignia certifica que el estudiante realizo nivel 1 de ethical hacking", event.getDescripcionInsignia().value());
        Mockito.verify(repository).getEventsBy(ROOTID);

    }
}
