package co.com.sofka.domain.Certificacion.Values;

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
