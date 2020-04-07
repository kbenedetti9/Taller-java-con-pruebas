package com.company;

import javax.swing.*;

public class Main {

    public static void main(String[] args) {
        int ejercicio;
        do {

            int opcion = Integer.parseInt(JOptionPane.showInputDialog("Escoja un ejercicio [2] o [3]"));
            ejercicio = opcion;
            switch (opcion) {
                case 2:
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

                    break;

                case 3:
                    int numero = Integer.parseInt(JOptionPane.showInputDialog("Ingrese numero de contraseñas que desea generar"));

                    Password listaContrasenas[] = new Password[numero];

                    for (int i = 0; i < numero; i++) {
                        Password contrasena = new Password();
                        int longitud = Integer.parseInt(JOptionPane.showInputDialog("Ingresa el tamaño para la contraseña numero #" + i));
                        contrasena.setLongitud(longitud);
                        contrasena.generarContrasena();

                        listaContrasenas[i] = contrasena;

                        JOptionPane.showMessageDialog(null, "La contraseña #" + i + "generada fue " + listaContrasenas[i].getLongitud());
                    }
                    break;
            }

        } while (ejercicio != 2 && ejercicio != 3);
    }
}