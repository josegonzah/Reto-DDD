package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Curso.Profesor;
import co.com.sofka.domain.Curso.commands.CrearEvaluacion;
import co.com.sofka.domain.Curso.events.CursoCreado;
import co.com.sofka.domain.Curso.events.EvaluacionCreada;
import co.com.sofka.domain.Curso.values.*;
import co.com.sofka.usecase.crearEvaluacionUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class crearEvaluacionUseCaseTest {
    private final String ROOTID = "123ddf667";

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearEvaluacionTest(){
        var command = new CrearEvaluacion(CursoId.of(ROOTID), EvaluacionId.of("2343fff55"), new TemaEvaluacion("Seguridad informatica"), new MetricaEvaluacion(100));
        var useCase = new crearEvaluacionUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new CursoCreado(
                        new CursoId(ROOTID),
                        new Profesor(
                                new ProfesorId("2343fff55"),
                                new NombreProfesor("Raul")),
                        new TituloCurso("Preparacion OSCP"),
                        new DescripcionCurso("Se espera que el usuario quede preparado para la certificacion")

                )
        ));

        useCase.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCase, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("No se pudo crear la evaluacion"))
                .getDomainEvents();

        var event = (EvaluacionCreada)events.get(0);
        Assertions.assertEquals("Seguridad informatica", event.getTemaEvaluacion().value());
        Assertions.assertEquals(100, event.getMetricaEvaluacion().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }


}
