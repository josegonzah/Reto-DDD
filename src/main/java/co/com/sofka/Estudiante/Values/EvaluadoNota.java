package co.com.sofka.Estudiante.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class EvaluadoNota implements ValueObject<Boolean> {
    private final Boolean value;

    public EvaluadoNota(Boolean value) {
        this.value = value;
    }

    public Boolean value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        EvaluadoNota that = (EvaluadoNota) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
