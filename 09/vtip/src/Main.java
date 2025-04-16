import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var okno = new JFrame("Dôležitá otázka");

        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        var popisok = new JLabel("Chceš úspešne absolvovať predmet Informatika 2?");

        var anoTlacitko = new JButton("áno");
        var nieTlacitko = new JButton("nie");

        var tlacitka = new JPanel(new GridLayout(1, 2));

        okno.add(popisok, BorderLayout.NORTH);

        tlacitka.add(anoTlacitko);
        tlacitka.add(nieTlacitko);

        okno.add(tlacitka, BorderLayout.CENTER);

        okno.pack();

        okno.setVisible(true);
    }
}
