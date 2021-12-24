package co.com.sofka.Curso.values;

import co.com.sofka.domain.generic.Identity;

public class Nombre extends Identity {
    public Nombre(){

    }

    public Nombre(String id) {
        super(id);
    }

    public static Nombre of(String id){
        return new Nombre(id);
    }
}
