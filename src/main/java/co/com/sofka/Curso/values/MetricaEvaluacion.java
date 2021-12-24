package co.com.sofka.Curso.values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class MetricaEvaluacion implements ValueObject<Integer> {
    private final Integer value;

    public MetricaEvaluacion(Integer value) {
        this.value = value;
        if(this.value <= 0){
            throw new IllegalArgumentException("Valor menor a 0 no es posible");
        }
        if(this.value >=1000000){
            throw new IllegalArgumentException("Valor metrica debe ser menor a 1000000");
        }
    }

    public Integer value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MetricaEvaluacion that = (MetricaEvaluacion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
