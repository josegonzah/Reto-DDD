package co.com.sofka.domain.Estudiante.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EstadoMeta implements ValueObject<String> {
    private final String value;

    public EstadoMeta(String value) {
        this.value = value;
        if(this.value.length()<=3){
            throw new IllegalArgumentException("EstadoMeta debe tener por lo menos 3 caracteres");
        }
        if(this.value.length()>=50){
            throw new IllegalArgumentException("EstadoMeta debe tener maximo 50 caracteres");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EstadoMeta that = (EstadoMeta) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
