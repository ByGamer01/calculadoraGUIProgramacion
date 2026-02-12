package com.example;

public class CalculadoraLogica {

    private double numero1;
    private String operacion;
    private boolean nuevoNumero;
    private String pantalla;

    public CalculadoraLogica() {
        this.numero1 = 0;
        this.operacion = "";
        this.nuevoNumero = true;
        this.pantalla = "0";
    }

    public String procesarEntrada(String comando) {
        if (comando.equals("+") || comando.equals("-") ||
                comando.equals("*") || comando.equals("/")) { // Logica grande para las operaciones matematicas
            // CASO 2: Operación
            numero1 = Double.parseDouble(pantalla); // similar al parseInt solo que con numeros con decimales
            operacion = comando;
            nuevoNumero = true;

        } else {
            // CASO 1:  Es un numero entre 0 y 9
            if (nuevoNumero) { 
                pantalla = comando;
                nuevoNumero = false;
            } else {
                pantalla = pantalla + comando;
            }
        }
        return pantalla;
    }
}
