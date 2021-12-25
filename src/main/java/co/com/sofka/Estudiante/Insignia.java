package co.com.sofka.Estudiante;

import co.com.sofka.Estudiante.Values.DescripcionInsignia;
import co.com.sofka.Estudiante.Values.InsigniaId;
import co.com.sofka.Estudiante.Values.RangoInsignia;
import co.com.sofka.domain.generic.Entity;

public class Insignia extends Entity<InsigniaId> {
    protected RangoInsignia rangoInsignia;
    protected DescripcionInsignia descripcionInsignia;

    public Insignia(InsigniaId insigniaId, RangoInsignia rangoInsignia, DescripcionInsignia descripcionInsignia){
        super((insigniaId));
        this.rangoInsignia = rangoInsignia;
        this.descripcionInsignia = descripcionInsignia;
    }

    public void modificarDescripcionInsignia(DescripcionInsignia descripcionInsignia){
        this.descripcionInsignia = descripcionInsignia;
    }

    public RangoInsignia getRangoInsignia() {
        return rangoInsignia;
    }

    public DescripcionInsignia getDescripcionInsignia() {
        return descripcionInsignia;
    }
}
