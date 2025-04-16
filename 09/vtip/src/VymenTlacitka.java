import javax.swing.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class VymenTlacitka extends MouseAdapter {
    private final JButton noveNieTlacitko;
    private final JButton noveAnoTlacitko;

    public VymenTlacitka(JButton noveNieTlacitko, JButton noveAnoTlacitko) {
        this.noveNieTlacitko = noveNieTlacitko;
        this.noveAnoTlacitko = noveAnoTlacitko;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        this.noveNieTlacitko.setText("nie");
        this.noveNieTlacitko.setFocusable(false);
        this.noveAnoTlacitko.setText("áno");
        this.noveAnoTlacitko.setFocusable(true);
        this.noveAnoTlacitko.grabFocus();
    }
}
