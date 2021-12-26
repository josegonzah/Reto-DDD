package co.com.sofka.Certificacion.Values;

import co.com.sofka.Certificacion.Habilidad;
import co.com.sofka.Estudiante.Values.InsigniaId;
import co.com.sofka.domain.generic.Identity;

public class HabilidadId extends Identity {
    public HabilidadId(){

    }

    public HabilidadId(String id) {
        super(id);
    }

    public static HabilidadId of(String id){
        return new HabilidadId(id);
    }
}
