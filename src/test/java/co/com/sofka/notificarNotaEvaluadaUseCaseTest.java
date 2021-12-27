package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Estudiante.Values.EstadoCurso;
import co.com.sofka.domain.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.Estudiante.Values.NombreEstudiante;
import co.com.sofka.domain.Estudiante.events.EstudianteCreado;
import co.com.sofka.domain.generics.Events.NotificacionEnviada;
import co.com.sofka.usecase.notificarNotaEvaluadaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class notificarNotaEvaluadaUseCaseTest {
    private final String ROOTID = "ds78jds999";

    @Mock
    private DomainEventRepository repository;

    @Test
    void notificarNotaEvaluada(){
        var event = new EstudianteCreado(
                EstudianteId.of(ROOTID),
                CursoId.of("dsds78jds88"),
                new EstadoCurso("Sin completar 20%"),
                new NombreEstudiante("Jose David Gonzalez")
        );

        event.setAggregateRootId(ROOTID);

        var useCase = new notificarNotaEvaluadaUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                event
        ));
        useCase.addRepository(repository);

        var events = UseCaseHandler.getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new TriggeredEvent<>(event))
                .orElseThrow()
                .getDomainEvents();
        var mensaje = (NotificacionEnviada)events.get(0);
        Assertions.assertEquals("El estudiante se creo, evalue la nota", mensaje.getMensaje());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
