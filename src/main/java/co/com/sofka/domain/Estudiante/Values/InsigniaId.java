package co.com.sofka.domain.Estudiante.Values;

import co.com.sofka.domain.generic.Identity;

public class InsigniaId extends Identity {
    public InsigniaId(){

    }

    public InsigniaId(String id) {
        super(id);
    }

    public static InsigniaId of(String id){
        return new InsigniaId(id);
    }
}
