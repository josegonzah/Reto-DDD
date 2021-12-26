package co.com.sofka.domain.Estudiante.Values;

import co.com.sofka.domain.generic.Identity;

public class EstudianteId extends Identity {
    public EstudianteId(){

    }

    public EstudianteId(String id) {
        super(id);
    }

    public static EstudianteId of(String id){
        return new EstudianteId(id);
    }
}
