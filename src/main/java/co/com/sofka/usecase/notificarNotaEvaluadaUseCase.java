package co.com.sofka.usecase;

import co.com.sofka.business.generic.UseCase;
import co.com.sofka.business.support.ResponseEvents;
import co.com.sofka.business.support.TriggeredEvent;
import co.com.sofka.domain.Estudiante.Estudiante;
import co.com.sofka.domain.Estudiante.Values.EstudianteId;
import co.com.sofka.domain.Estudiante.events.EstudianteCreado;

public class notificarNotaEvaluadaUseCase extends UseCase<TriggeredEvent<EstudianteCreado>, ResponseEvents> {
    @Override
    public void executeUseCase(TriggeredEvent<EstudianteCreado> estudianteCreadoTriggeredEvent) {
        var event = estudianteCreadoTriggeredEvent.getDomainEvent();
        var estudiante = Estudiante.from(EstudianteId.of(event.aggregateRootId()), this.retrieveEvents());
        estudiante.notificarEvaluada("El estudiante se creo, evalue la nota");

        emit().onResponse(new ResponseEvents(estudiante.getUncommittedChanges()));
    }
}
