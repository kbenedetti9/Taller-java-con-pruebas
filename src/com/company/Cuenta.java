package com.company;

public class Cuenta {

    private final String titular;
    private double cantidad;


    public Cuenta(String titular) {
        this(titular, 0);
    }

    public Cuenta(String titular, double cantidad) {
        this.titular = titular;
        this.cantidad = cantidad;
    }

    public String getTitular() {
        return titular;
    }

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    @Override
    public String toString() {
        return "Cuenta{" +
                "titular='" + titular + '\'' +
                ", cantidad=" + cantidad +
                '}';
    }

    public void ingresar(double cantidad) {
        if (cantidad > 0) {
            this.cantidad += cantidad;
        }

    }

    public void retirar(double cantidad) {
        if (cantidad > 0) {
            this.cantidad -= cantidad;
            if (this.cantidad < 0) {
                this.cantidad = Double.valueOf(0);
            }
        }
    }
}
