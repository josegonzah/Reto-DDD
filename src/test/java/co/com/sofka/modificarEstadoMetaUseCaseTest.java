package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Estudiante.Values.*;
import co.com.sofka.domain.Estudiante.commands.ModificarEstadoMeta;
import co.com.sofka.domain.Estudiante.events.EstadoMetaModificado;
import co.com.sofka.domain.Estudiante.events.EstudianteCreado;
import co.com.sofka.domain.Estudiante.events.MetaCreada;
import co.com.sofka.usecase.modificarEstadoCursoUseCase;
import co.com.sofka.usecase.modificarEstadoMetaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class modificarEstadoMetaUseCaseTest {
    private final String ROOTID = "145tr67";

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarEstadoMeta(){
        var command = new ModificarEstadoMeta(EstudianteId.of(ROOTID), MetaId.of("23er45"), new EstadoMeta("Meta sin completar 50%"));
        var useCase = new modificarEstadoMetaUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new EstudianteCreado(
                        EstudianteId.of(ROOTID),
                        CursoId.of("2343fff55"),
                        new EstadoCurso("Cursando"),
                        new NombreEstudiante("Jose David Gonzalez")
                ),
                new MetaCreada(
                        MetaId.of("23er45"),
                        new EstadoMeta("Sin completar progreso 10%"),
                        new DescripcionMeta("Meta: Completar el tercer nivel del curso de introduccion al pentesting y hacking etico")
                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("Something went wrong while changing the clothes to the referee"))
                .getDomainEvents();

        var event = (EstadoMetaModificado)events.get(0);
        Assertions.assertEquals("Meta sin completar 50%", event.getEstadoMeta().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
