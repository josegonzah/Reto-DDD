package co.com.sofka.domain.Curso;

import co.com.sofka.domain.Curso.values.DescripcionSeccion;
import co.com.sofka.domain.Curso.values.SeccionId;
import co.com.sofka.domain.Curso.values.TituloSeccion;
import co.com.sofka.domain.generic.Entity;

public class Seccion extends Entity<SeccionId> {
    protected TituloSeccion tituloSeccion;
    protected DescripcionSeccion descripcionSeccion;

    public Seccion(SeccionId entityId, TituloSeccion tituloSeccion, DescripcionSeccion descripcionSeccion) {
        super(entityId);
        this.tituloSeccion = tituloSeccion;
        this.descripcionSeccion = descripcionSeccion;
    }

    public void ModificarTituloSeccion(TituloSeccion tituloSeccion){
        this.tituloSeccion = tituloSeccion;
    }

    public void ModificarDescripcionSeccion(DescripcionSeccion descripcionSeccion){
        this.descripcionSeccion = descripcionSeccion;
    }

    public TituloSeccion tituloSeccion() {
        return tituloSeccion;
    }

    public DescripcionSeccion descripcionSeccion() {
        return descripcionSeccion;
    }
}
