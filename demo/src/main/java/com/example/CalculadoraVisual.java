package com.example;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.Border;

public class CalculadoraVisual extends JFrame implements KeyListener { // KeyListener para los botones

    public CalculadoraVisual() {
        this.setTitle("Calculadora GUI - David");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. Definir el layout principal
        this.setLayout(new BorderLayout());

        // 2. Crear los 3 componentes
        JLabel lblHistorico = new JLabel(" ");
        JLabel lblPantalla = new JLabel("0");
        JPanel panelBotones = new JPanel();

        // 3. TODO: Añade los 3 componentes al JFrame usando BorderLayout
        // - lblHistorico va en NORTH
        this.add(lblHistorico, BorderLayout.NORTH);
        // - lblPantalla va en CENTER
        this.add(lblPantalla, BorderLayout.CENTER);
        // - panelBotones va en SOUTH
        this.add(panelBotones, BorderLayout.SOUTH);

        

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent evt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent evt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent evt) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
