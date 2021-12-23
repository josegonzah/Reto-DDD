package co.com.sofka.Curso.values;

import co.com.sofka.domain.generic.Identity;

public class SeccionId extends Identity {
    public SeccionId(){

    }

    public SeccionId(String id) {
        super(id);
    }

    public static SeccionId of(String id){
        return new SeccionId(id);
    }
}
