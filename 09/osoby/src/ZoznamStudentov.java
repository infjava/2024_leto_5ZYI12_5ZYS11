import javax.swing.*;

public class ZoznamStudentov {
    private final JFrame okno;
    private final DefaultListModel<Student> studenti;
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

        this.studenti = new DefaultListModel<Student>();
        this.zoznam.setModel(this.studenti);

        this.studenti.addElement(new Student("Jožko", "Mrkvička", 1853));
        this.studenti.addElement(new Student("Jožko", "Mrkvička", 1853));
        this.studenti.addElement(new Student("A", "B", 200));
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
