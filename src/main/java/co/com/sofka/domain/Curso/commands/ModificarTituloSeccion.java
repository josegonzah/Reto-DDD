package co.com.sofka.domain.Curso.commands;

import co.com.sofka.domain.Curso.values.CursoId;
import co.com.sofka.domain.Curso.values.SeccionId;
import co.com.sofka.domain.Curso.values.TituloSeccion;
import co.com.sofka.domain.generic.Command;

public class ModificarTituloSeccion extends Command {
    private final CursoId cursoId;
    private final SeccionId seccionId;
    private final TituloSeccion tituloSeccion;

    public ModificarTituloSeccion(CursoId cursoId, SeccionId seccionId, TituloSeccion tituloSeccion) {
        this.cursoId = cursoId;
        this.seccionId = seccionId;
        this.tituloSeccion = tituloSeccion;
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
}
