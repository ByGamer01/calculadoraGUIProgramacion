package com.example;

import javax.swing.UIManager;

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel("com.jtattoo.plaf.hifi.HiFiLookAndFeel"); // L&F oscuro, queria ponerle uno de MacOS pero no he podido porque yo no programo en MacOS, estoy en windows. Tampoco queria ponerle un FlatLaf lo veia muy soso 
        } catch (Exception e) {
            System.out.println("No s'ha pogut aplicar el tema");
        }
        new CalculadoraVisual(); // asi lo inicializamos mejor
    }
}
