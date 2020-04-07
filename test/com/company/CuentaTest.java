package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class CuentaTest {

    @Test
    void crearCuentaTest() {
        Cuenta nuevaCuenta = new Cuenta("Karen Benedetti");
        Assertions.assertEquals("Karen Benedetti", nuevaCuenta.getTitular());
    }

    @Test
    void crearCuentaConCantidadPorDefectoTest() {
        Cuenta nuevaCuenta = new Cuenta("Karen Benedetti");
        Assertions.assertEquals(0, nuevaCuenta.getCantidad());
    }

    @Test
    void crearCuentaSinCantidadTest() {
        Cuenta nuevaCuenta = new Cuenta("Juan Velez");
        Assertions.assertEquals("Juan Velez", nuevaCuenta.getTitular());
        Assertions.assertEquals(0, nuevaCuenta.getCantidad());
    }

    @Test
    void crearCuentaConCantidadTest() {
        Cuenta nuevaCuenta = new Cuenta("Karen Benedetti", 13000);
        Assertions.assertEquals("Karen Benedetti", nuevaCuenta.getTitular());
        Assertions.assertEquals(13000, nuevaCuenta.getCantidad());
    }

    @Test
    void crearCuentaConDecimalTest() {
        Cuenta nuevaCuenta = new Cuenta("Karen Benedetti", 1.003);
        Assertions.assertEquals("Karen Benedetti", nuevaCuenta.getTitular());
        Assertions.assertEquals(1.003, nuevaCuenta.getCantidad());
    }

    @Test
    void crearCuentaConCantodadCeroTest() {
        Cuenta nuevaCuenta = new Cuenta("Karen Benedetti", 0);
        Assertions.assertEquals("Karen Benedetti", nuevaCuenta.getTitular());
        Assertions.assertEquals(0, nuevaCuenta.getCantidad());
    }

    @Test
    void ingresarDineroTest() {
        Cuenta nuevaCuenta = new Cuenta("Karen Benedetti");
        nuevaCuenta.ingresar(2000);

        Assertions.assertEquals(2000, nuevaCuenta.getCantidad());
    }

    @Test
    void ingresarCeroTest() {
        Cuenta nuevaCuenta = new Cuenta("Karen Benedetti", 300);
        nuevaCuenta.ingresar(0);

        Assertions.assertEquals(300, nuevaCuenta.getCantidad());
    }

    @Test
    void ingresarDecimalTest() {
        Cuenta nuevaCuenta = new Cuenta("Karen Benedetti", 3000);
        nuevaCuenta.ingresar(2.50);

        Assertions.assertEquals(3002.50, nuevaCuenta.getCantidad());
    }

    @Test
    void retirarDineroTest() {
        Cuenta nuevaCuenta = new Cuenta("Karen Benedetti", 13000);
        nuevaCuenta.retirar(3000);

        Assertions.assertEquals(10000, nuevaCuenta.getCantidad());
    }

    @Test
    void retirarMasDeLaCantidadTest() {
        Cuenta nuevaCuenta = new Cuenta("Karen Benedetti", 13000);
        nuevaCuenta.retirar(15000);

        Assertions.assertEquals(0, nuevaCuenta.getCantidad());
    }

    @Test
    void retirarCeroTest() {
        Cuenta nuevaCuenta = new Cuenta("Karen Benedetti", 13000);
        nuevaCuenta.retirar(0);

        Assertions.assertEquals(13000, nuevaCuenta.getCantidad());
    }

}