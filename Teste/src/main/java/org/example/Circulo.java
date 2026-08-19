package org.example;

public class Circulo {

    private final double raio;

    public Circulo(double raio) {
        if (raio <= 0) {
            throw new IllegalArgumentException("O raio deve ser maior que zero");
        }
        this.raio = raio;
    }

    public double calcularArea() {
        return Math.PI * raio * raio;
    }

    public boolean verificarSeCirculoEGrande() {
        return raio >= 10;
    }

    public boolean verificarSeCirculoPequeno(){
        return raio < 10;
    }

    public double calcularCircunferencia() {
        return 2 * Math.PI * raio;
    }

}
