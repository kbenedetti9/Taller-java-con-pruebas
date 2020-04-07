package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PasswordTest {

    @Test
    void crearPasswordTest() {
        Password nuevaPassword = new Password();
        Assertions.assertEquals(8, nuevaPassword.getLongitud());
    }

    @Test
    void crearPasswordConLogitudTest() {
        Password nuevaPassword = new Password(6);
        Assertions.assertEquals(6, nuevaPassword.getLongitud());
    }

    @Test
    void longitudContrasenaTest() {
        Password nuevaPassword = new Password(6);
        String contrasena = nuevaPassword.getContrasena();
        Assertions.assertEquals(6, contrasena.length());
    }

    @Test
    void longitudContrasenaPorDefectoTest() {
        Password nuevaPassword = new Password();
        String contrasena = nuevaPassword.getContrasena();
        Assertions.assertEquals(8, contrasena.length());
    }

    @Test
    void contrasenaCaracterTest() {
        Password nuevaPassword = new Password(4);
        String contrasena = nuevaPassword.getContrasena();
        char primero = contrasena.charAt(0);
        char segundo = contrasena.charAt(1);
        char tercero = contrasena.charAt(2);
        char cuarto = contrasena.charAt(3);
        Assertions.assertEquals(true, Character.isLetterOrDigit(primero));
        Assertions.assertEquals(true, Character.isLetterOrDigit(segundo));
        Assertions.assertEquals(true, Character.isLetterOrDigit(tercero));
        Assertions.assertEquals(true, Character.isLetterOrDigit(cuarto));
    }

    @Test
    void noEsFuerteTest() {
        Password nuevaPassword = new Password(6);
        String contrasena = nuevaPassword.getContrasena();
        Assertions.assertEquals(false, nuevaPassword.esFuerte(contrasena));
    }

    @Test
    void noEsFuerteConCaracteresTest() {
        Password nuevaPassword = new Password(4);
        String contrasena = "MEr5";
        Assertions.assertEquals(false, nuevaPassword.esFuerte(contrasena));
    }

    @Test
    void esFuerteTest() {
        Password nuevaPassword = new Password(11);
        String contrasena = "MEStr123465";
        Assertions.assertEquals(true, nuevaPassword.esFuerte(contrasena));
    }


}