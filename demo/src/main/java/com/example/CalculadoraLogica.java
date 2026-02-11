package com.example;

public class CalculadoraLogica {

    private double numero1;
    private String operacion;
    private boolean nuevoNumero;

    public CalculadoraLogica() {
        this.numero1 = 0;
        this.operacion = "";
        this.nuevoNumero = true;
    }

    public String procesarEntrada(String comando) {
        return comando;
    }
}