package co.com.sofka.domain.Curso.commands;

import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Curso.values.DescripcionSeccion;
import co.com.sofka.domain.Curso.values.TituloSeccion;
import co.com.sofka.domain.generic.Command;

public class CrearSeccion extends Command {
    private final CursoId cursoId;
    private final TituloSeccion tituloSeccion;
    private final DescripcionSeccion descripcionSeccion;

    public CrearSeccion(CursoId cursoId, TituloSeccion tituloSeccion, DescripcionSeccion descripcionSeccion) {
        this.cursoId = cursoId;
        this.tituloSeccion = tituloSeccion;
        this.descripcionSeccion = descripcionSeccion;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public TituloSeccion getTituloSeccion() {
        return tituloSeccion;
    }

    public DescripcionSeccion getDescripcionSeccion() {
        return descripcionSeccion;
    }
}
