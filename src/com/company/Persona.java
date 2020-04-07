package com.company;

public class Persona {

    private String nombre;
    private int edad;
    private String DNI;
    private char sexo;
    private double peso;
    private double altura;

    private final static char SEXO = 'H';
    private final static int IDEAL = -1;
    private final static int BAJO = 0;
    private final static int SOBREPESO = 1;

    public Persona() {
        nombre = "";
        edad = 0;
        sexo = SEXO;
        peso = 0;
        altura = 0;
        generarDNI();
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        peso = 0;
        altura = 0;
        comprobarSexo();
        generarDNI();
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        comprobarSexo();
        generarDNI();
    }

    public int calcularIMC(double peso, double altura) {
        double resultado;
        resultado = peso / (Math.pow(altura, 2));

        if (resultado < 20) {
            return IDEAL;
        } else if (resultado >= 20 && resultado <= 25) {
            return BAJO;
        } else if (resultado > 25) {
            return SOBREPESO;
        }
        return 0;
    }

    public boolean esMayorDeEdad(int edad) {
        if (edad >= 18) {
            return true;
        }
        return false;
    }

    public void comprobarSexo() {
        if (sexo != 'F' && sexo != 'H') {
            this.sexo = SEXO;
        }
    }

    public char generarLetra() {
        char letra = ' ';
        int numero = (int) (Math.random() * 25 + 65);
        letra = (char) numero;
        return letra;
    }

    public void generarDNI() {
        String DNI = "";
        char letra = ' ';
        for (int i = 0; i < 8; i++) {
            int numero = (int) (9 * Math.random());
            DNI += numero + "";
        }
        letra = generarLetra();
        DNI += letra;
        this.DNI = DNI;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public char getSexo() {
        return sexo;
    }

    public void setSexo(char sexo) {
        this.sexo = sexo;
    }

    public double getPeso() {
        return peso;
    }

    public void setPeso(double peso) {
        this.peso = peso;
    }

    public double getAltura() {
        return altura;
    }

    public String getDNI() {
        return DNI;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", DNI='" + DNI + '\'' +
                ", sexo=" + sexo +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }
}
