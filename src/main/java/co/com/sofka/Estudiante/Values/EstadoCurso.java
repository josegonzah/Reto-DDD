package co.com.sofka.Estudiante.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoCurso implements ValueObject<String> {
    private final String value;

    public EstadoCurso(String value) {
        this.value = value;
        if(this.value.length()<=3){
            throw new IllegalArgumentException("EstadoCurso debe tener por lo menos 3 caracteres");
        }
        if(this.value.length()>=50){
            throw new IllegalArgumentException("EstadoCurso debe tener maximo 50 caracteres");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoCurso that = (EstadoCurso) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
