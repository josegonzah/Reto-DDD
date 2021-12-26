package co.com.sofka.Certificacion.commands;

import co.com.sofka.Certificacion.Values.CertificacionId;
import co.com.sofka.Certificacion.Values.CompaniaQueLoExpideId;
import co.com.sofka.Certificacion.Values.NombreCompania;
import co.com.sofka.domain.generic.Command;

public class CrearCompania extends Command {
    private final CertificacionId certificacionId;
    private final CompaniaQueLoExpideId companiaQueLoExpideId;
    private final NombreCompania nombreCompania;

    public CrearCompania(CertificacionId certificacionId, CompaniaQueLoExpideId companiaQueLoExpideId, NombreCompania nombreCompania) {
        this.certificacionId = certificacionId;
        this.companiaQueLoExpideId = companiaQueLoExpideId;
        this.nombreCompania = nombreCompania;
    }

    public CertificacionId getCertificacionId() {
        return certificacionId;
    }

    public CompaniaQueLoExpideId getCompaniaQueLoExpideId() {
        return companiaQueLoExpideId;
    }

    public NombreCompania getNombreCompania() {
        return nombreCompania;
    }
}
