package co.com.sofka;


import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Estudiante.Values.*;
import co.com.sofka.domain.Estudiante.commands.ModificarNotaEvaluada;
import co.com.sofka.domain.Estudiante.events.EstudianteCreado;
import co.com.sofka.domain.Estudiante.events.NotaCreada;
import co.com.sofka.domain.Estudiante.events.NotaEvaluada;
import co.com.sofka.usecase.evaluarNotaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class evaluarNotaClaseUseCaseTest {
    private final String ROOTID = "145tr67";

    @Mock
    private DomainEventRepository repository;

    @Test
    void evaluarNotaUseCase(){
        var command = new ModificarNotaEvaluada(EstudianteId.of(ROOTID), NotaId.of("23er45"), new EvaluadoNota(true));
        var useCase = new evaluarNotaUseCase();

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
                .orElseThrow(()->new IllegalArgumentException("No se puede evaluar la nota"))
                .getDomainEvents();
        var event = (NotaEvaluada)events.get(0);
        Assertions.assertEquals(true, event.getEvaluadoNota().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }


}
