package co.com.sofka.domain.Certificacion;

import co.com.sofka.domain.Certificacion.Values.CompaniaQueLoExpideId;
import co.com.sofka.domain.Certificacion.Values.NombreCompania;
import co.com.sofka.domain.generic.Entity;

public class CompaniaQueLoExpide extends Entity<CompaniaQueLoExpideId> {
    protected NombreCompania nombreCompania;

    public CompaniaQueLoExpide(CompaniaQueLoExpideId entityId, NombreCompania nombreCompania) {
        super(entityId);
        this.nombreCompania = nombreCompania;
    }

    public NombreCompania getNombreCompania() {
        return nombreCompania;
    }
}
