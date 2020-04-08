package com.company;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PersonaTest {

    @Test
    void crearPersonaPorDefectoTest() {
        Persona nuevaPersona = new Persona();
        Assertions.assertEquals("", nuevaPersona.getNombre());
        Assertions.assertEquals(0, nuevaPersona.getEdad());
        Assertions.assertEquals('H', nuevaPersona.getSexo());
        Assertions.assertEquals(0, nuevaPersona.getPeso());
        Assertions.assertEquals(0, nuevaPersona.getAltura());
    }

    @Test
    void crearPersonaSinMedidas() {
        Persona personaSinMedidas = new Persona("Juan", 18, 'H');
        Assertions.assertEquals("Juan", personaSinMedidas.getNombre());
        Assertions.assertEquals(18, personaSinMedidas.getEdad());
        Assertions.assertEquals('H', personaSinMedidas.getSexo());
        Assertions.assertEquals(0, personaSinMedidas.getPeso());
        Assertions.assertEquals(0, personaSinMedidas.getAltura());
    }

    @Test
    void crearPersonaConMedidas() {
        Persona personaConMedidas = new Persona("Juan", 18, 'H', 75, 1.70);
        Assertions.assertEquals("Juan", personaConMedidas.getNombre());
        Assertions.assertEquals(18, personaConMedidas.getEdad());
        Assertions.assertEquals('H', personaConMedidas.getSexo());
        Assertions.assertEquals(75, personaConMedidas.getPeso());
        Assertions.assertEquals(1.70, personaConMedidas.getAltura());
    }

    @Test
    void IMCAltoTest() {
        Persona personaConMedidas = new Persona("Juan", 18, 'H', 75, 1.70);
        int IMC = personaConMedidas.calcularIMC(personaConMedidas.getPeso(), personaConMedidas.getAltura());
        Assertions.assertEquals(1, IMC);
    }

    @Test
    void IMCBajoTest() {
        Persona personaConMedidas = new Persona("Juan", 18, 'H', 45, 1.70);
        int IMC = personaConMedidas.calcularIMC(personaConMedidas.getPeso(), personaConMedidas.getAltura());
        Assertions.assertEquals(-1, IMC);
    }

    @Test
    void IMCNormalTest() {
        Persona personaConMedidas = new Persona("Juan", 18, 'H', 70, 1.70);
        int IMC = personaConMedidas.calcularIMC(personaConMedidas.getPeso(), personaConMedidas.getAltura());
        Assertions.assertEquals(0, IMC);
    }

    @Test
    void esMayorTest() {
        Persona personaConMedidas = new Persona("Juan", 28, 'H', 70, 1.70);
        boolean mayor = personaConMedidas.esMayorDeEdad(personaConMedidas.getEdad());
        Assertions.assertEquals(true, mayor);
    }

    @Test
    void esMenorTest() {
        Persona personaConMedidas = new Persona("Juan", 10, 'H', 70, 1.70);
        boolean mayor = personaConMedidas.esMayorDeEdad(personaConMedidas.getEdad());
        Assertions.assertEquals(false, mayor);
    }

    @Test
    void tieneDieciochoTest() {
        Persona personaConMedidas = new Persona("Juan", 18, 'H', 70, 1.70);
        boolean mayor = personaConMedidas.esMayorDeEdad(personaConMedidas.getEdad());
        Assertions.assertEquals(true, mayor);
    }

    @Test
    void comprobarSexoDefinidoHTest() {
        Persona personaConMedidas = new Persona("Juan", 18, 'H', 70, 1.70);
        Assertions.assertEquals('H', personaConMedidas.getSexo());
    }

    @Test
    void comprobarSexoDefinidoMTest() {
        Persona personaConMedidas = new Persona("Diana", 25, 'F', 70, 1.65);
        Assertions.assertEquals('F', personaConMedidas.getSexo());
    }

    @Test
    void comprobarSexoInvalidoTest() {
        Persona personaConMedidas = new Persona("Juan", 18, 'T', 70, 1.70);
        Assertions.assertEquals('H', personaConMedidas.getSexo());
    }

    @Test
    void generarDNICantidadCaracteresTest() {
        Persona personaConMedidas = new Persona("Juan", 18, 'T', 70, 1.70);
        String DNI = personaConMedidas.getDni();
        Assertions.assertEquals(9, DNI.length());
    }

    @Test
    void DNIUltimoEsLetraTest() {
        Persona personaConMedidas = new Persona("Juan", 18, 'T', 70, 1.70);
        String DNI = personaConMedidas.getDni();
        char ultimo = DNI.charAt(8);
        Assertions.assertEquals(true, Character.isLetter(ultimo));
    }

    @Test
    void DNISonDigitosTest() {
        Persona personaConMedidas = new Persona("Juan", 18, 'T', 70, 1.70);
        String DNI = personaConMedidas.getDni();
        char primero = DNI.charAt(0);
        char segundo = DNI.charAt(1);
        char tercero = DNI.charAt(2);
        char cuarto = DNI.charAt(3);
        char quinto = DNI.charAt(4);
        char sexto = DNI.charAt(5);
        char septimo = DNI.charAt(6);
        char octavo = DNI.charAt(7);
        Assertions.assertEquals(true, Character.isDigit(primero));
        Assertions.assertEquals(true, Character.isDigit(segundo));
        Assertions.assertEquals(true, Character.isDigit(tercero));
        Assertions.assertEquals(true, Character.isDigit(cuarto));
        Assertions.assertEquals(true, Character.isDigit(quinto));
        Assertions.assertEquals(true, Character.isDigit(sexto));
        Assertions.assertEquals(true, Character.isDigit(septimo));
        Assertions.assertEquals(true, Character.isDigit(octavo));
    }

    @Test
    void generarLetraTest() {
        Persona personaConMedidas = new Persona("Juan", 18, 'T', 70, 1.70);
        char letra = personaConMedidas.generarLetra();
        Assertions.assertEquals(true, Character.isLetter(letra));
    }

    @Test
    void generarLetraPersonaPorDefectoTest() {
        Persona personaConMedidas = new Persona();
        char letra = personaConMedidas.generarLetra();
        Assertions.assertEquals(true, Character.isLetter(letra));
    }

    @Test
    void generarLetraPersonaSinMedidasTest() {
        Persona personaSinMedidas = new Persona("Juan", 18, 'H');
        char letra = personaSinMedidas.generarLetra();
        Assertions.assertEquals(true, Character.isLetter(letra));
    }
}