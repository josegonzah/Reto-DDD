package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Estudiante.Meta;
import co.com.sofka.domain.Estudiante.Values.*;
import co.com.sofka.domain.Estudiante.commands.CrearInsignia;
import co.com.sofka.domain.Estudiante.commands.CrearMeta;
import co.com.sofka.domain.Estudiante.events.EstudianteCreado;
import co.com.sofka.domain.Estudiante.events.InsigniaCreada;
import co.com.sofka.domain.Estudiante.events.MetaCreada;
import co.com.sofka.usecase.crearInsigniaUseCase;
import co.com.sofka.usecase.crearMetaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class crearMetaUseCaseTest {
    private final String ROOTID = "123ddf667";

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearMetaTest(){
        var command = new CrearMeta(EstudianteId.of(ROOTID), MetaId.of("1234fff55"), new EstadoMeta("Completada"), new DescripcionMeta("Meta: completar con una calificacion mayor al 80% en las lecciones de nivel 1"));
        var useCase = new crearMetaUseCase();

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
                .orElseThrow(()->new IllegalArgumentException("No se pudo crear la meta"))
                .getDomainEvents();


        var event = (MetaCreada)events.get(0);
        Assertions.assertEquals("Completada", event.getEstadoMeta().value());
        Assertions.assertEquals("Meta: completar con una calificacion mayor al 80% en las lecciones de nivel 1", event.getDescripcionMeta().value());
        Mockito.verify(repository).getEventsBy(ROOTID);

    }
}
