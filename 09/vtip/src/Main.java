import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        var okno = new JFrame("Dôležitá otázka");

        okno.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        var popisok = new JLabel("Chceš úspešne absolvovať predmet Informatika 2?");

        var laveTlacitko = new JButton("áno");
        var praveTlacitko = new JButton("nie");

        praveTlacitko.setFocusable(false);

        laveTlacitko.addMouseListener(new VymenTlacitka(praveTlacitko, laveTlacitko));
        praveTlacitko.addMouseListener(new VymenTlacitka(laveTlacitko, praveTlacitko));

        laveTlacitko.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(okno, "No vidíš, tak sa snaž!");
                System.exit(0);
            }
        });

        var tlacitka = new JPanel(new GridLayout(1, 2));

        okno.add(popisok, BorderLayout.NORTH);

        tlacitka.add(laveTlacitko);
        tlacitka.add(praveTlacitko);

        okno.add(tlacitka, BorderLayout.CENTER);

        okno.pack();

        okno.setVisible(true);
    }
}
