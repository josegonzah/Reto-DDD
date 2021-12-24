package co.com.sofka.Curso.values;

import co.com.sofka.Curso.Profesor;
import co.com.sofka.domain.generic.Identity;

public class ProfesorId extends Identity {
    public ProfesorId(){

    }

    public ProfesorId(String id) {
        super(id);
    }

    public static ProfesorId of(String id){
        return new ProfesorId(id);
    }
}
