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

        this.pridat.addActionListener(e -> this.pridatStudenta());
    }

    private void pridatStudenta() {
        var meno = this.meno.getText();
        var priezvisko = this.priezvisko.getText();
        var rokNarodenia = Integer.parseInt(this.rokNarodenia.getText());

        var student = new Student(meno, priezvisko, rokNarodenia);

        this.studenti.addElement(student);
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
