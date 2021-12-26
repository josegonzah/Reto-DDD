package co.com.sofka.Certificacion.Values;

import co.com.sofka.domain.generic.Identity;

public class CompaniaQueLoExpideId extends Identity {
    public CompaniaQueLoExpideId(){

    }

    public CompaniaQueLoExpideId(String id) {
        super(id);
    }

    public static CompaniaQueLoExpideId of(String id){
        return new CompaniaQueLoExpideId(id);
    }
}
