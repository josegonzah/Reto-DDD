package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Estudiante.Values.*;
import co.com.sofka.domain.Estudiante.commands.ModificarDescripcionInsignia;
import co.com.sofka.domain.Estudiante.events.DescripcionInsigniaModificada;
import co.com.sofka.domain.Estudiante.events.EstudianteCreado;
import co.com.sofka.domain.Estudiante.events.InsigniaCreada;
import co.com.sofka.usecase.modificarDescripcionInsigniaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class modificarDescripcionInsigniaUseCaseTest {
    private final String ROOTID = "145tr67";

    @Mock
    private DomainEventRepository repository;

    @Test
    void modificarDescripcionInsignia(){
        var command = new ModificarDescripcionInsignia(EstudianteId.of(ROOTID), InsigniaId.of("23er45"), new DescripcionInsignia("La insignia se ha modificado para probar el test del use case"));
        var useCase = new modificarDescripcionInsigniaUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new EstudianteCreado(
                        EstudianteId.of(ROOTID),
                        CursoId.of("2343fff55"),
                        new EstadoCurso("Cursando"),
                        new NombreEstudiante("Jose David Gonzalez")
                ),
                new InsigniaCreada(InsigniaId.of("23er45"),
                        new RangoInsignia(2),
                        new DescripcionInsignia("La insignia que hay aca es simplemente para testear el use case completamente"))

        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("No se pudo cambiar la descripcion"))
                .getDomainEvents();

        var event = (DescripcionInsigniaModificada)events.get(0);
        Assertions.assertEquals("La insignia se ha modificado para probar el test del use case", event.getDescripcionInsignia().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
