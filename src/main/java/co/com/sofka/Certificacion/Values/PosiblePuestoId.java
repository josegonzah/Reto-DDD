package co.com.sofka.Certificacion.Values;

import co.com.sofka.Certificacion.PosiblePuesto;
import co.com.sofka.domain.generic.Identity;

public class PosiblePuestoId extends Identity {
    public PosiblePuestoId(){

    }

    public PosiblePuestoId(String id) {
        super(id);
    }

    public static PosiblePuestoId of(String id){
        return new PosiblePuestoId(id);
    }
}
