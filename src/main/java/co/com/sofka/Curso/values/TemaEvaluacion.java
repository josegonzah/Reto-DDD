package co.com.sofka.Curso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class TemaEvaluacion implements ValueObject<String> {
    private final String value;

    public TemaEvaluacion(String value) {
        this.value = value;
        if(this.value.length()<=20){
            throw new IllegalArgumentException("Descripcion debe tener por lo menos 20 caracteres");
        }
        if(this.value.length()>=200){
            throw new IllegalArgumentException("Descripcion debe tener maximo 200 caracteres");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TemaEvaluacion that = (TemaEvaluacion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
