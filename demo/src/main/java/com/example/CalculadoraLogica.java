package com.example;

public class CalculadoraLogica {

    private double numero1;
    private String operacion;
    private boolean nuevoNumero;
    private String pantalla;
    private String historico = "";

    public CalculadoraLogica() {
        this.numero1 = 0;
        this.operacion = "";
        this.nuevoNumero = true;
        this.pantalla = "0";
    }

    public String procesarEntrada(String comando) {

        // CASO 1: Número
        if ("0123456789".contains(comando)) { // Mejor asi, si el comando contiene uno de los siguientes numeros entra
                                              // en este bucle.
            if (nuevoNumero) {
                pantalla = comando;
                nuevoNumero = false;
            } else {
                pantalla = pantalla + comando;
                historico = historico + comando;
            }
            historico = historico + comando;

            // CASO 2: Operación
        } else if (comando.equals("+") || comando.equals("-") || comando.equals("*") || comando.equals("/")) {
            // Tal vez es muy largo arriba :D ; pero mas bonito
            numero1 = Double.parseDouble(pantalla); // Lo mismo que dije antes, esto es como un parseInt
            operacion = comando;
            nuevoNumero = true;
            historico = pantalla + " " + comando + " ";

            // CASO 3: Igual
        } else if (comando.equals("=")) { // Si la operacion contiene un = hacemos las operaciones
            double numero2 = Double.parseDouble(pantalla);
            double resultado = 0;

            switch (operacion) {
                case "+":
                    resultado = numero1 + numero2;
                    break;
                case "-":
                    resultado = numero1 - numero2;
                    break;
                case "*":
                    resultado = numero1 * numero2;
                    break;
                case "/":
                    if (numero2 == 0) {
                        pantalla = "Error";
                        historico = "indivisible por 0";
                        nuevoNumero = true;
                        return pantalla;
                    }
                    resultado = numero1 / numero2;
                    break;
            }
            historico = pantalla + " " + comando + " ";
            pantalla = String.valueOf(resultado);
            nuevoNumero = true;
        } else if (comando.equals("C")) { // Si es la C reseteamos todo el comando
            numero1 = 0;
            operacion = "";
            nuevoNumero = true;
            pantalla = "0";
            historico = " ";
        }

        return pantalla;
    }

    public String getHistorico() {
        return historico;
    }
}
