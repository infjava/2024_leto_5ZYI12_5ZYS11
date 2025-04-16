import javax.swing.*;

public class ZoznamStudentov {
    private final JFrame okno;
    private JList zoznam;
    private JPanel obsahOkna;
    private JTextField meno;
    private JTextField priezvisko;
    private JTextField rokNarodenia;
    private JButton pridat;
    private JButton odstranit;
    private JButton upravit;

    public ZoznamStudentov() {
        this.okno = new JFrame("Zoznam študentov");
        this.okno.add(this.obsahOkna);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
