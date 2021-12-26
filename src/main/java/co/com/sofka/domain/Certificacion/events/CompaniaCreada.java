package co.com.sofka.domain.Certificacion.events;

import co.com.sofka.domain.Certificacion.Values.CompaniaQueLoExpideId;
import co.com.sofka.domain.Certificacion.Values.NombreCompania;
import co.com.sofka.domain.generic.DomainEvent;

public class CompaniaCreada extends DomainEvent {
    private final CompaniaQueLoExpideId companiaQueLoExpideId;
    private final NombreCompania nombreCompania;

    public CompaniaCreada(CompaniaQueLoExpideId companiaQueLoExpideId, NombreCompania nombreCompania) {
        super("sofka.certificacion.companiacreada");
        this.companiaQueLoExpideId = companiaQueLoExpideId;
        this.nombreCompania = nombreCompania;
    }

    public CompaniaQueLoExpideId getCompaniaQueLoExpideId() {
        return companiaQueLoExpideId;
    }

    public NombreCompania getNombreCompania() {
        return nombreCompania;
    }
}
