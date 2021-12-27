package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.Certificacion.Certificacion;
import co.com.sofka.domain.Certificacion.Values.CertificacionId;
import co.com.sofka.domain.Certificacion.events.CertificacionCreada;

public class notificarCertificacionExpedidaUseCase extends UseCase<TriggeredEvent<CertificacionCreada>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<CertificacionCreada> certificacionCreadaTriggeredEvent) {
        var event = certificacionCreadaTriggeredEvent.getDomainEvent();
        var certificacion = Certificacion.from(CertificacionId.of(event.aggregateRootId()), this.retrieveEvents());
        certificacion.notificarCertificacionExpedida("Se creo la ceertifiacion, apruevela para ser expedida");

        emit().onResponse(new ResponseEvents(certificacion.getUncommittedChanges()));
    }
}
