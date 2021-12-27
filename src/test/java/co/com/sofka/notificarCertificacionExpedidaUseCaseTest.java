package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.Certificacion.CompaniaQueLoExpide;
import co.com.sofka.domain.Certificacion.PosiblePuesto;
import co.com.sofka.domain.Certificacion.Values.*;
import co.com.sofka.domain.Certificacion.events.CertificacionCreada;
import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.generics.Events.NotificacionEnviada;
import co.com.sofka.usecase.notificarCertificacionExpedidaUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class notificarCertificacionExpedidaUseCaseTest {
    private final String ROOTID = "ds78jds999";

    @Mock
    private DomainEventRepository repository;

    @Test
    void notificarCertificacionExpedida(){
        var event = new CertificacionCreada(
                new CertificacionId("2343fff55"),
                new NombreCertificacion("OSCP Certified"),
                new DescripcionCertificacion("Entidad certifica a usuario como hacker etico con capacidad de hacer pentesting"),
                new CursoId("2343fff55"),
                new EstudianteId("2343ddd55"),
                new PosiblePuesto(
                        new PosiblePuestoId("2355fff12"),
                        new DescripcionPosiblePuesto("Analista seguridad red team, puede hacer auditorias de hacking etico a empresas")
                ),
                new CompaniaQueLoExpide(
                        new CompaniaQueLoExpideId("2343fff67"),
                        new NombreCompania("Cisco")
                )
        );

        event.setAggregateRootId(ROOTID);

        var useCase = new notificarCertificacionExpedidaUseCase();

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
        Assertions.assertEquals("Se creo la ceertifiacion, apruevela para ser expedida", mensaje.getMensaje());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }
}
