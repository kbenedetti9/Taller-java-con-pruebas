package com.company;

public class Password {

    private int longitud;
    private String contrasena;
    private final static int LONGITUD = 8;

    public Password() {
        this.longitud = LONGITUD;
        contrasena = generarContrasena();
    }

    public Password(int longitud) {
        this.longitud = longitud;
        contrasena = generarContrasena();
    }

    public boolean esFuerte(String contrasena) {
        boolean verificacion = false;
        int conteoMayuscula = 0;
        int conteoMiniscula = 0;
        int conteoNumero = 0;
        for (int i = 0; i < contrasena.length(); i++) {
            if (Character.isUpperCase(contrasena.charAt(i))) {
                conteoMayuscula++;
            } else if (Character.isLowerCase(contrasena.charAt(i))) {
                conteoMiniscula++;
            } else if (Character.isDigit(contrasena.charAt(i))) {
                conteoNumero++;
            }

            if (verificacionNumero(conteoMayuscula, 2) &&
                    verificacionNumero(conteoMiniscula, 1) &&
                    verificacionNumero(conteoNumero, 5)) {
                verificacion = true;
            }
        }
        return verificacion;
    }

    public String generarContrasena() {
        String password = "";
        for (int i = 0; i < longitud; i++) {
            int eleccion = (generarNumeroAleatorio(4,1,1));
            if (eleccion == 1) {
                char minusculas = (char) (generarNumeroAleatorio(123,97,97));
                password += minusculas;
            } else {
                if (eleccion == 2) {
                    char mayusculas = (char) (generarNumeroAleatorio(91,65,65));
                    password += mayusculas;
                } else {
                    char numeros = (char) (generarNumeroAleatorio(58,48,48));
                    password += numeros;
                }
            }
        }

        return password;
    }

    public int getLongitud() {
        return longitud;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setLongitud(int longitud) {
        this.longitud = longitud;
    }

    public boolean verificacionNumero(int conteo, int numero) {

        if (conteo > numero) {
            return true;
        }
        return false;
    }

    public int generarNumeroAleatorio(int n1, int n2, int n3) {

       return ((int) Math.floor(Math.random() * (n1 - n2) + n3));
    }

}
