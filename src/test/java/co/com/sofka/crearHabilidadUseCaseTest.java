package co.com.sofka;

import co.com.sofka.business.generic.UseCaseHandler;
import co.com.sofka.business.repository.DomainEventRepository;
import co.com.sofka.business.support.RequestCommand;
import co.com.sofka.domain.Certificacion.CompaniaQueLoExpide;
import co.com.sofka.domain.Certificacion.PosiblePuesto;
import co.com.sofka.domain.Certificacion.Values.*;
import co.com.sofka.domain.Certificacion.commands.CrearHabilidad;
import co.com.sofka.domain.Certificacion.events.CertificacionCreada;
import co.com.sofka.domain.Certificacion.events.HabilidadCreada;
import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.generic.DomainEvent;
import co.com.sofka.usecase.crearHabilidadUseCase;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class crearHabilidadUseCaseTest {
    private final String ROOTID = "123ddf667";

    @Mock
    private DomainEventRepository repository;

    @Test
    void crearHabilidadTest(){
        var command = new CrearHabilidad(CertificacionId.of(ROOTID), HabilidadId.of("2343fff55"), new NombreHabilidad("Hacking etico"), new DescripcionHabilidad("Encontrar vulnerabilidades en sistemas informaticos y redes de comunicacion"));
        var useCsse = new crearHabilidadUseCase();

        Mockito.when(repository.getEventsBy(ROOTID)).thenReturn(List.of(
                new CertificacionCreada(
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
                )
        ));

        useCsse.addRepository(repository);
        var events = UseCaseHandler
                .getInstance()
                .setIdentifyExecutor(ROOTID)
                .syncExecutor(useCsse, new RequestCommand<>(command))
                .orElseThrow(()->new IllegalArgumentException("No se pudo crear la habilidad"))
                .getDomainEvents();

        var event = (HabilidadCreada)events.get(0);
        Assertions.assertEquals("Hacking etico", event.getNombreHabilidad().value());
        Assertions.assertEquals("Encontrar vulnerabilidades en sistemas informaticos y redes de comunicacion", event.getDescripcionHabilidad().value());
        Mockito.verify(repository).getEventsBy(ROOTID);
    }

}
