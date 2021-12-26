package co.com.sofka.domain.Estudiante.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class FeedbackNota implements ValueObject<String> {
    private final String value;

    public FeedbackNota(String value) {
        this.value = value;
        if(this.value.length()<=50){
            throw new IllegalArgumentException("Feedback debe tener por lo menos 50 caracteres");
        }
        if(this.value.length()>=10000){
            throw new IllegalArgumentException("Feedback debe tener maximo 10000 caracteres");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        FeedbackNota that = (FeedbackNota) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
