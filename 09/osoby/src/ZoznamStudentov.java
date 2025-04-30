import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

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
    private JButton ulozit;
    private JButton nacitat;

    public ZoznamStudentov() {
        this.okno = new JFrame("Zoznam študentov");
        this.okno.add(this.obsahOkna);
        this.okno.pack();

        this.studenti = new DefaultListModel<Student>();
        this.zoznam.setModel(this.studenti);

        this.meno.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                ZoznamStudentov.this.vlastnostiSaZmenili();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                ZoznamStudentov.this.vlastnostiSaZmenili();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                ZoznamStudentov.this.vlastnostiSaZmenili();
            }
        });

        this.pridat.addActionListener(e -> this.pridatStudenta());

        this.ulozit.addActionListener(e -> this.ulozitDoSuboru());
        this.nacitat.addActionListener(e -> this.nacitatZoSuboru());
    }

    private void nacitatZoSuboru() {

    }

    private void ulozitDoSuboru() {

    }

    private void vlastnostiSaZmenili() {
        var spravneMeno = !this.meno.getText().isBlank();
        var spravnePriezvisko = !this.priezvisko.getText().isBlank();
        var spravnyRokNarodenia = !this.rokNarodenia.getText().isBlank();

        this.pridat.setEnabled(spravneMeno && spravnePriezvisko && spravnyRokNarodenia);
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
