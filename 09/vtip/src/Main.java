import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var okno = new JFrame("Dôležitá otázka");

        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        okno.setLayout(new GridLayout(2, 2));

        var popisok = new JLabel("Chceš úspešne absolvovať predmet Informatika 2?");

        var anoTlacitko = new JButton("áno");
        var nieTlacitko = new JButton("nie");

        okno.add(popisok);
        okno.add(new JLabel());
        okno.add(anoTlacitko);
        okno.add(nieTlacitko);

        okno.pack();

        okno.setVisible(true);
    }
}
