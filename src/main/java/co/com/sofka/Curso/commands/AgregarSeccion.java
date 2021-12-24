package co.com.sofka.Curso.commands;

import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.DescripcionSeccion;
import co.com.sofka.Curso.values.SeccionId;
import co.com.sofka.Curso.values.TituloSeccion;
import co.com.sofka.domain.generic.Command;

public class AgregarSeccion extends Command {
    private final CursoId cursoId;
    private final SeccionId seccionId;
    private final TituloSeccion tituloSeccion;
    private final DescripcionSeccion descripcionSeccion;


    public AgregarSeccion(CursoId cursoId, SeccionId seccionId, TituloSeccion tituloSeccion, DescripcionSeccion descripcionSeccion) {
        this.cursoId = cursoId;
        this.seccionId = seccionId;
        this.tituloSeccion = tituloSeccion;
        this.descripcionSeccion = descripcionSeccion;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public SeccionId getSeccionId() {
        return seccionId;
    }

    public TituloSeccion getTituloSeccion() {
        return tituloSeccion;
    }

    public DescripcionSeccion getDescripcionSeccion() {
        return descripcionSeccion;
    }
}
