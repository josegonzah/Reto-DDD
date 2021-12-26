package co.com.sofka.domain.Certificacion.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DescripcionPosiblePuesto implements ValueObject<String> {
    private final String value;

    public DescripcionPosiblePuesto(String value) {
        this.value = value;
        if(this.value.length()<=50){
            throw new IllegalArgumentException("Descripcion debe tener por lo menos 50 caracteres");
        }
        if(this.value.length()>=1000){
            throw new IllegalArgumentException("Descripcion debe tener maximo 1000 caracteres");
        }
    }

    public String value(){
        return value;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DescripcionPosiblePuesto that = (DescripcionPosiblePuesto) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
