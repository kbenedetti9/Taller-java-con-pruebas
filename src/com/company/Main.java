package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        String nombre = JOptionPane.showInputDialog("Ingrese su nombre");
        int edad = Integer.parseInt(JOptionPane.showInputDialog("Ingrese su edad"));
        char sexo = JOptionPane.showInputDialog("Ingrese el se (H)Hombre (M)Mujer").charAt(0);
        double peso = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su peso en Kg"));
        double altura = Double.parseDouble(JOptionPane.showInputDialog("Ingrese su altura en mts"));
        Persona nuevaPersona = new Persona(nombre, edad, sexo, peso, altura);
        Persona personaSinMedidas = new Persona("Juan", 18, 'H');
        Persona personaSinInfo = new Persona();

        personaSinMedidas.setPeso(50);
        personaSinMedidas.setAltura(1.55);
        personaSinInfo.setNombre("Karen");
        personaSinInfo.setEdad(23);
        personaSinInfo.setSexo('M');
        personaSinInfo.setPeso(51);
        personaSinInfo.setAltura(1.68);

        System.out.println("Persona 1 - Su IMC es: " + nuevaPersona.calcularIMC(peso, altura));
        System.out.println("Persona 2 - Su IMC es: " + personaSinMedidas.calcularIMC(personaSinMedidas.getPeso(), personaSinMedidas.getAltura()));
        System.out.println("Persona 3 - Su IMC es: " + personaSinInfo.calcularIMC(personaSinInfo.getPeso(), personaSinInfo.getAltura()));

        if (nuevaPersona.esMayorDeEdad(edad)) {
            System.out.println("Persona 1 - es mayor");
        } else {
            System.out.println("Persona 1 - es menor");
        }

        if (personaSinMedidas.esMayorDeEdad(personaSinMedidas.getEdad())) {
            System.out.println("Persona 2 - es mayor");
        } else {
            System.out.println("Persona 2 - es menor");
        }

        if (personaSinInfo.esMayorDeEdad(personaSinInfo.getEdad())) {
            System.out.println("Persona 3 - es mayor");
        } else {
            System.out.println("Persona 3 - es menor");
        }

        System.out.println(nuevaPersona.toString());
        System.out.println(personaSinMedidas.toString());
        System.out.println(personaSinInfo.toString());
    }
}
