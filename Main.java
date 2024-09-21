package Fractales;

import javax.swing.JFrame;
import javax.swing.UIManager;
public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        }
        catch(Exception e) {}
        Fractal fractal = new Fractal();
        fractal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}
