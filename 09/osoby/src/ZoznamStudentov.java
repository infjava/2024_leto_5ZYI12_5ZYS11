import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.io.*;

public class ZoznamStudentov {
    private static final int SUBOR_MAGIC_NUMBER = 564564613;
    private static final int SUBOR_VERZIA = 1;

    private final JFrame okno;
    private DefaultListModel<Student> studenti;
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
        var vyberSuboru = new JFileChooser();

        var vysledok = vyberSuboru.showOpenDialog(this.okno);

        if (vysledok == JFileChooser.APPROVE_OPTION) {
            var subor = vyberSuboru.getSelectedFile();

            try (var citac = new ObjectInputStream(new FileInputStream(subor))) {
                var nacitanyZoznam = (DefaultListModel<Student>) citac.readObject();

                this.studenti = nacitanyZoznam;
                this.zoznam.setModel(this.studenti);
            } catch (IOException | ClassNotFoundException e) {
                JOptionPane.showMessageDialog(this.okno, "Nepodarilo sa nacitat. Chyba: " + e.getMessage());
            }
        }
    }

    private void ulozitDoSuboru() {
        var vyberSuboru = new JFileChooser();

        var vysledok = vyberSuboru.showSaveDialog(this.okno);

        if (vysledok == JFileChooser.APPROVE_OPTION) {
            var subor = vyberSuboru.getSelectedFile();
            try (var zapisovac = new DataOutputStream(new FileOutputStream(subor))) {
                zapisovac.writeInt(SUBOR_MAGIC_NUMBER);
                zapisovac.writeInt(SUBOR_VERZIA);

                zapisovac.writeInt(this.studenti.getSize());
                for (int i = 0; i < this.studenti.getSize(); i++) {
                    this.studenti.get(i).ulozitDoSuboru(zapisovac);
                }
            } catch (IOException e) {
                JOptionPane.showMessageDialog(this.okno, "Nepodarilo sa ulozit. Chyba: " + e.getMessage());
            }
        }
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
