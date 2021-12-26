package co.com.sofka.Certificacion.Values;

import co.com.sofka.Certificacion.Certificacion;
import co.com.sofka.Estudiante.Values.InsigniaId;
import co.com.sofka.domain.generic.Identity;

public class CertificacionId extends Identity {
    public CertificacionId(){

    }

    public CertificacionId(String id) {
        super(id);
    }

    public static CertificacionId of(String id){
        return new CertificacionId(id);
    }

}
