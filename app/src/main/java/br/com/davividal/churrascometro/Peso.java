package br.com.davividal.churrascometro;

/**
 * Created by davi_000 on 05/04/2016.
 */
public class Peso {
    private Float peso;
    private Integer power = 1;

    public Peso(Integer peso) {
        this.peso = peso.floatValue();

        if (peso >= 1000) {
            this.power = 3;
            this.peso /= 1000;
        }
    }

    @Override
    public String toString() {
        String suffix = " g";
        if (3 == this.power) {
             suffix = " kg";
        }
        return this.peso.toString() + suffix;
    }
}
