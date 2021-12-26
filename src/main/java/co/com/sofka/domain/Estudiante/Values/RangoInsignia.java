package co.com.sofka.domain.Estudiante.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class RangoInsignia implements ValueObject<Integer> {
    private final Integer value;

    public RangoInsignia(Integer value) {
        this.value = value;
        if(this.value <= 0){
            throw new IllegalArgumentException("rango menor a 0 no es posible");
        }
        if(this.value >=10){
            throw new IllegalArgumentException("Rango metrica debe ser menor a 10");
        }
    }

    public Integer value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RangoInsignia that = (RangoInsignia) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
