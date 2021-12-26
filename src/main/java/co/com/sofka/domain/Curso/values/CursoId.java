package co.com.sofka.domain.Curso.values;

import co.com.sofka.domain.generic.Identity;

public class CursoId extends Identity {
    public CursoId(){

    }

    public CursoId(String id) {
        super(id);
    }

    public static CursoId of(String id){
        return new CursoId(id);
    }
}
