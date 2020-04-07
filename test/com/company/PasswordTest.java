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
}