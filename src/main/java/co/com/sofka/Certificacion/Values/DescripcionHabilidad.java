package co.com.sofka.Certificacion.Values;

import co.com.sofka.Estudiante.Values.DescripcionInsignia;
import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DescripcionHabilidad implements ValueObject<String> {
    private final String value;

    public DescripcionHabilidad(String value) {
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
        DescripcionHabilidad that = (DescripcionHabilidad) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
