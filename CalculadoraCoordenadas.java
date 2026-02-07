import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class CalculadoraCoordenadas {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Calculadora - Coordenadas");
        JPanel panel = new JPanel();
        panel.setSize(400, 400);

        // Añadir el listener al panel o a los botones
        panel.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // Obtener coordenadas locales al componente
                int x = e.getX();
                int y = e.getY();
                System.out.println("Clic en: X=" + x + ", Y=" + y);
            }
        });

        frame.add(panel);
        frame.setSize(400, 400);
    }
}
