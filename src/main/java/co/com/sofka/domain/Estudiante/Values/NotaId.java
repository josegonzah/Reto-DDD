package co.com.sofka.domain.Estudiante.Values;

import co.com.sofka.domain.generic.Identity;

public class NotaId extends Identity {
    public NotaId(){

    }

    public NotaId(String id) {
        super(id);
    }

    public static NotaId of(String id){
        return new NotaId(id);
    }
}
