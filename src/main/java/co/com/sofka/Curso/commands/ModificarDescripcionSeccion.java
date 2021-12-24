package co.com.sofka.Curso.commands;

import co.com.sofka.Curso.values.CursoId;
import co.com.sofka.Curso.values.DescripcionSeccion;
import co.com.sofka.Curso.values.SeccionId;
import co.com.sofka.domain.generic.Command;

public class ModificarDescripcionSeccion extends Command {
    private final CursoId cursoId;
    private final SeccionId seccionId;
    private final DescripcionSeccion descripcionSeccion;

    public ModificarDescripcionSeccion(CursoId cursoId, SeccionId seccionId, DescripcionSeccion descripcionSeccion) {
        this.cursoId = cursoId;
        this.seccionId = seccionId;
        this.descripcionSeccion = descripcionSeccion;
    }

    public CursoId getCursoId() {
        return cursoId;
    }

    public SeccionId getSeccionId() {
        return seccionId;
    }

    public DescripcionSeccion getDescripcionSeccion() {
        return descripcionSeccion;
    }
}
