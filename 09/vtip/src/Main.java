import javax.swing.*;
import java.awt.*;

public class Main {
    public static void main(String[] args) {
        var okno = new JFrame("Dôležitá otázka");

        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        okno.setLayout(new BorderLayout());

        var popisok = new JLabel("Chceš úspešne absolvovať predmet Informatika 2?");

        var anoTlacitko = new JButton("áno");
        var nieTlacitko = new JButton("nie");

        okno.add(popisok, BorderLayout.NORTH);
        okno.add(anoTlacitko, BorderLayout.WEST);
        okno.add(nieTlacitko, BorderLayout.EAST);

        okno.pack();

        okno.setVisible(true);
    }
}
