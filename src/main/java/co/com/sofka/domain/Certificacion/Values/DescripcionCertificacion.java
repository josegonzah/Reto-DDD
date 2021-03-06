package co.com.sofka.domain.Certificacion.Values;

import co.com.sofka.domain.generic.ValueObject;

import java.util.Objects;

public class DescripcionCertificacion implements ValueObject<String> {
    private final String value;

    public DescripcionCertificacion(String value) {
        this.value = value;
        if(this.value.length()<=30){
            throw new IllegalArgumentException("Descripcion debe tener por lo menos 30 caracteres");
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
        DescripcionCertificacion that = (DescripcionCertificacion) o;
        return Objects.equals(value, that.value);
    }

    @Override
    public int hashCode() {
        return Objects.hash(value);
    }
}
