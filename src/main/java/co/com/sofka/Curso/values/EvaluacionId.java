package co.com.sofka.Curso.values;

import co.com.sofka.domain.generic.Identity;

public class EvaluacionId extends Identity {
    public EvaluacionId(){

    }

    public EvaluacionId(String id) {
        super(id);
    }

    public static EvaluacionId of(String id){
        return new EvaluacionId(id);
    }
}
