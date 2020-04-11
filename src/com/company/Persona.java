package com.company;

public class Persona {

    private String nombre;
    private int edad;
    private String dni;
    private char sexo;
    private double peso;
    private double altura;

    private final static char HOMBRE = 'H';
    private final static char MUJER = 'F';
    private final static int IDEAL = -1;
    private final static int BAJO = 0;
    private final static int SOBREPESO = 1;

    public Persona() {
        nombre = "";
        edad = 0;
        sexo = HOMBRE;
        peso = 0;
        altura = 0;
        dni = generarDNI();
    }

    public Persona(String nombre, int edad, char sexo) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = 0;
        this.altura = 0;
        this.sexo = comprobarSexo();
        this.dni = generarDNI();
    }

    public Persona(String nombre, int edad, char sexo, double peso, double altura) {
        this.nombre = nombre;
        this.edad = edad;
        this.sexo = sexo;
        this.peso = peso;
        this.altura = altura;
        this.sexo = comprobarSexo();
        this.dni = generarDNI();
    }

    public int calcularIMC(double peso, double altura) {
        double resultado;
        resultado = calculoDeIMC(peso, altura);

        if (esPesoIdeal(20, resultado)) {
            return IDEAL;
        } else if (esPesoBajo(20, 25, resultado)) {
            return BAJO;
        } else if (esSobrepeso(25, resultado)) {
            return SOBREPESO;
        }
        return 0;
    }

    private boolean esPesoIdeal(int num, double resultado) {
        return resultado < num;
    }

    private boolean esPesoBajo(int num1, int num2, double resultado) {
        if (resultado >= num1 && resultado <= num2) {
            return true;
        }
        return false;
    }

    private boolean esSobrepeso(int num, double resultado) {
        return resultado > num;
    }

    private double calculoDeIMC(double peso, double altura) {
        double resultado = peso / (Math.pow(altura, 2));
        return resultado;
    }

    public boolean esMayorDeEdad(int edad) {
        if (edad >= 18) {
            return true;
        }
        return false;
    }

    public char comprobarSexo() {
        if (sexo != MUJER && sexo != HOMBRE) {
            return HOMBRE;
        }

        return sexo;
    }

    public char generarLetra() {
        char letra = ' ';
        int numero = (int) (Math.random() * 25 + 65);
        letra = (char) numero;
        return letra;
    }

    public String generarDNI() {
        String dni = "";
        char letra = ' ';
        for (int i = 0; i < 8; i++) {
            int numero = (int) (9 * Math.random());
            dni += numero + "";
        }
        letra = generarLetra();
        dni += letra;
        return dni;
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

    public String getDni() {
        return dni;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "Persona{" +
                "nombre='" + nombre + '\'' +
                ", edad=" + edad +
                ", DNI='" + dni + '\'' +
                ", sexo=" + sexo +
                ", peso=" + peso +
                ", altura=" + altura +
                '}';
    }


}
