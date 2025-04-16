import javax.swing.*;

public class ZoznamStudentov {
    private final JFrame okno;
    private JList zoznam;
    private JPanel obsahOkna;

    public ZoznamStudentov() {
        this.okno = new JFrame("Zoznam študentov");
        this.okno.add(this.obsahOkna);
        this.okno.pack();
    }

    public void zobraz() {
        this.okno.setVisible(true);
    }
}
