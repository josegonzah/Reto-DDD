package co.com.sofka.Curso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class Titulo implements ValueObject<String> {
    private final String value;

    public Titulo(String value) {
        this.value = value;
        if(this.value.length()<=5){
            throw new IllegalArgumentException("Titulo debe tener por lo menos 5 caracteres");
        }
        if(this.value.length()>=100){
            throw new IllegalArgumentException("Titulo debe tener maximo 100 caracteres");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Titulo that = (Titulo) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
