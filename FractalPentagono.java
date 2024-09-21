package Fractales;
import javax.swing.*;
import java.awt.*;
import java.awt.geom.Path2D;

    public class  FractalPentagono extends JPanel {

        private int depth; // Profundidad de la recursión

        public FractalPentagono(int depth) {
            this.depth = depth;
        }

        @Override
        protected void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2d = (Graphics2D) g;
            g2d.setColor(Color.RED);
            drawPentagon(g2d, getWidth() / 2, getHeight() / 2, 200, depth);
        }

        // Método para dibujar un pentágono y sus fractales
        private void drawPentagon(Graphics2D g2d, double x, double y, double size, int depth) {
            if (depth == 0) {
                return;
            }

            // Crea un pentágono
            Path2D pentagon = new Path2D.Double();
            for (int i = 0; i < 10; i++) {
                double angle = 2 * Math.PI / 5 * i;
                double xVertex = x + size * Math.cos(angle);
                double yVertex = y + size * Math.sin(angle);
                if (i == 0) {
                    pentagon.moveTo(xVertex, yVertex);
                } else {
                    pentagon.lineTo(xVertex, yVertex);
                }
            }
            pentagon.closePath();

            // Dibuja el pentágono
            g2d.draw(pentagon);

            // Llama recursivamente para dibujar los pentágonos en las esquinas
            double newSize = size / 2;
            for (int i = 0; i < 10; i++) {
                double angle = 2 * Math.PI / 5 * i;
                double xOffset = size * Math.cos(angle);
                double yOffset = size * Math.sin(angle);
                drawPentagon(g2d, x + xOffset, y + yOffset, newSize, depth - 1);
            }
        }

        public static void main(String[] args) {
            JFrame frame = new JFrame("Árbol Fractal de Pentágonos");
            FractalPentagono fractal = new FractalPentagono(4); // Ajusta la profundidad
            frame.add(fractal);
            frame.setSize(800, 800);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.setVisible(true);
        }
    }