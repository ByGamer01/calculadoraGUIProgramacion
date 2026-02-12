package com.example;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class CalculadoraVisual extends JFrame implements KeyListener, ActionListener { // KeyListener para los botones

    // Atributos de clase (accesibles desde todos los métodos)
    private JLabel lblHistorico;
    private JLabel lblPantalla;

    // Calculadora Logica
    private CalculadoraLogica logica = new CalculadoraLogica();

    public CalculadoraVisual() {
        this.setTitle("Calculadora GUI - David");
        this.setSize(400, 500);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // 1. Definir el layout principal
        this.setLayout(new BorderLayout());

        // 2. Crear los 3 componentes
        lblHistorico = new JLabel(" ");
        lblPantalla = new JLabel("0");
        JPanel panelBotones = new JPanel();

        // 3. Añade los 3 componentes al JFrame usando BorderLayout

        // - lblHistorico va en NORTH
        this.add(lblHistorico, BorderLayout.NORTH);

        // - lblPantalla va en CENTER
        this.add(lblPantalla, BorderLayout.CENTER);

        // - panelBotones va en SOUTH
        this.add(panelBotones, BorderLayout.SOUTH);

        // Añadir los botones al panel | grid de botones
        panelBotones.setLayout(new GridLayout(4, 4, 5, 5));

        // Los botones se añaden en orden de lectura (izquierda a derecha, arriba a
        // abajo)
        // Primera Division
        JButton btn7 = new JButton("7");
        panelBotones.add(btn7);
        btn7.addActionListener(this);
        JButton btn8 = new JButton("8");
        panelBotones.add(btn8);
        btn8.addActionListener(this);
        JButton btn9 = new JButton("9");
        panelBotones.add(btn9);
        btn9.addActionListener(this);
        JButton btnDiv = new JButton("/");
        panelBotones.add(btnDiv);
        btnDiv.addActionListener(this);

        // Segunda División
        JButton btn4 = new JButton("4");
        panelBotones.add(btn4);
        btn4.addActionListener(this);
        JButton btn5 = new JButton("5");
        panelBotones.add(btn5);
        btn5.addActionListener(this);
        JButton btn6 = new JButton("6");
        panelBotones.add(btn6);
        btn6.addActionListener(this);
        JButton btnMult = new JButton("*");
        panelBotones.add(btnMult);
        btnMult.addActionListener(this);

        // Tercera Division
        JButton btn1 = new JButton("1");
        panelBotones.add(btn1);
        btn1.addActionListener(this);
        JButton btn2 = new JButton("2");
        panelBotones.add(btn2);
        btn2.addActionListener(this);
        JButton btn3 = new JButton("3");
        panelBotones.add(btn3);
        btn3.addActionListener(this);
        JButton btnSum = new JButton("+");
        panelBotones.add(btnSum);
        btnSum.addActionListener(this);

        // Cuarta Division
        JButton btn0 = new JButton("0");
        panelBotones.add(btn0);
        btn0.addActionListener(this);
        JButton btnC = new JButton("C");
        btnC.setBackground(Color.RED);
        panelBotones.add(btnC);
        btnC.addActionListener(this);
        JButton btnResultado = new JButton("=");
        panelBotones.add(btnResultado);
        btnResultado.addActionListener(this);
        JButton btnResta = new JButton("-");
        panelBotones.add(btnResta);
        btnResta.addActionListener(this);
        this.addKeyListener(this);
        this.setFocusable(true);

        this.setVisible(true);
    }

    @Override
    public void keyTyped(KeyEvent evt) {

    }

    @Override
    public void keyPressed(KeyEvent evt) {
        String comando;

        if (evt.getKeyCode() == KeyEvent.VK_ENTER) { // el enter es como hacer el =
            comando = "=";
        } else {
            comando = String.valueOf(evt.getKeyChar());
        }

        String resultado = logica.procesarEntrada(comando);
        lblPantalla.setText(resultado);
        lblHistorico.setText(logica.getHistorico());

        if (resultado.equals("Error")) { // El mismo caso que el action performed para que no haya brechas.
            JOptionPane.showMessageDialog(this,
                    "indivisible por 0 :D",
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void keyReleased(KeyEvent evt) {

    }

    @Override
    public void actionPerformed(ActionEvent evt) {
        String comando = evt.getActionCommand();
        System.out.println("Botón pulsado: " + comando);
        String resultado = logica.procesarEntrada(comando);
        lblPantalla.setText(resultado);
        lblHistorico.setText(logica.getHistorico());

        if (resultado.equals("Error")) {
            JOptionPane.showMessageDialog(this,
                    "Indivisible por 0", // no se puede dividir por 0 :D
                    "Error",
                    JOptionPane.ERROR_MESSAGE);
        }
    }

}
